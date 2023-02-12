package Functionalities;

import Controller.App;
import DTO.DijkstraObjectDTO;
import Domain.DistributionNetwork;
import Domain.DistributionNetworkData;
import Domain.Graph.DijkstraObject;
import Domain.Participants.Company;
import Domain.Participants.Participant;
import Domain.Participants.Particular;
import Domain.Participants.Producer;
import Domain.Products.BasketOrder;
import Domain.Products.Product;
import Mapper.DijkstraObjectMapper;
import Miscellaneous.AuxiliaryAlgorithms;

import java.util.*;

public class ExpeditionListMinimizedPathGenerator {

    private final DistributionNetwork distributionNetwork = App.getInstance().getSystemData().getDistributionNetwork();

    private final DistributionNetworkData distributionNetworkData = App.getInstance().getSystemData();

    private final List<Participant> participantsPresentInDispatchList = new ArrayList<>();

    private final List<String> listOfProducers = new ArrayList<>();

    private List<BasketOrder> getSimpleDispatchList(int day) {
        // Get the dispatch list of the day
        return distributionNetworkData.getSimpleDispatchLists().stream()
                .filter(dispatchList -> dispatchList.get(0).getDay() == day)
                .findFirst()
                .orElse(null);
    }

    private List<BasketOrder> getRestrictedDispatchList(int day) {
        // Get restricted dispatch list of the day
        return distributionNetworkData.getDispatchListsWithRestrictions().stream()
                .filter(dispatchList -> dispatchList.get(0).getDay() == day)
                .findFirst()
                .orElse(null);
    }

    private final Map<String, Integer> basketsDroppedPerHub = new HashMap<>();

    /**
     * Gets baskets dropped per hub.
     *
     * @return the baskets dropped per hub
     */
    public Map<String, Integer> getBasketsDroppedPerHub() {
        return basketsDroppedPerHub;
    }

    /**
     * Gets list of producers.
     *
     * @return the list of producers
     */
    public List<String> getListOfProducers() {
        return listOfProducers;
    }

    /**
     * Is dispatch list required valid boolean.
     *
     * @param day                  the day
     * @param restrictDispatchList the restricted dispatch list
     * @return the boolean
     */
    public boolean isDispatchListRequiredValid(int day, boolean restrictDispatchList) {
        // Check if the day has an associated dispatch list
        if (restrictDispatchList) return (getRestrictedDispatchList(day) != null);
        else return (getSimpleDispatchList(day) != null);
    }

    /**
     * Fill with producers and hubs.
     *
     * @param day                  the day
     * @param restrictDispatchList the restricted dispatch list
     */
    public void fillWithProducersAndHubs(int day, boolean restrictDispatchList) {
        // Variable to initialize the number of baskets dropped per hub
        int FIRST_BASKET = 1;

        // Filling the dispatch list for the given day, depending on the restriction
        List<BasketOrder> dispatchListForSelectedDay;
        if (restrictDispatchList) dispatchListForSelectedDay = getRestrictedDispatchList(day);
        else dispatchListForSelectedDay = getSimpleDispatchList(day);

        // Filling the Producers and Hubs
        Set<Producer> producersPresentInDispatchSet = new HashSet<>();
        Set<Company> hubsPresentInDispatchSet = new HashSet<>();

        // Making sure that no basket is fully empty
        boolean basketIsEmpty = true;

        for (BasketOrder basketOrderForTheDay : dispatchListForSelectedDay) {
            for (Product product : basketOrderForTheDay.getProducts()) {
                if (product.getProducer() != null) {
                    producersPresentInDispatchSet.add(product.getProducer());
                    basketIsEmpty = false;
                }
            }

            if (!basketIsEmpty) {
                hubsPresentInDispatchSet.add((Company) distributionNetwork.getParticipantByID(basketOrderForTheDay.getClient().getNearestHubId()));

                if (!basketsDroppedPerHub.containsKey(basketOrderForTheDay.getClient().getNearestHubId())) basketsDroppedPerHub.put(basketOrderForTheDay.getClient().getNearestHubId(), FIRST_BASKET);

                else basketsDroppedPerHub.put(basketOrderForTheDay.getClient().getNearestHubId(), basketsDroppedPerHub.get(basketOrderForTheDay.getClient().getNearestHubId()) + 1);
            }
        }

        listOfProducers.addAll(producersPresentInDispatchSet.stream().map(Producer::getParticipantId).toList());

        // Fill the main list with the participants
        participantsPresentInDispatchList.addAll(producersPresentInDispatchSet);
        participantsPresentInDispatchList.addAll(hubsPresentInDispatchSet);
    }

    private Map<List<List<DijkstraObjectDTO<Participant, Double>>>, List<Double>> setToUI(List<List<DijkstraObject<Participant, Double>>> pathPointsAndDistancesBetweenThem, List<Double> distancesBetweenPoints) {
        Map<List<List<DijkstraObjectDTO<Participant, Double>>>, List<Double>> map = new HashMap<>();
        List<List<DijkstraObjectDTO<Participant, Double>>> pathPointsAndDistancesBetweenThemDTO = new ArrayList<>();

        // Convert the DijkstraObject to DijkstraObjectDTO
        for (List<DijkstraObject<Participant, Double>> list : pathPointsAndDistancesBetweenThem) {

            List<DijkstraObjectDTO<Participant, Double>> listDTO = new ArrayList<>();

            for (DijkstraObject<Participant, Double> dijkstraObject : list) {

                listDTO.add(DijkstraObjectMapper.toDTO(dijkstraObject));
            }

            pathPointsAndDistancesBetweenThemDTO.add(listDTO);
        }

        map.put(pathPointsAndDistancesBetweenThemDTO, distancesBetweenPoints);
        return map;
    }

    /**
     * Gets minimum delivery path.
     *
     * @param startingPointId the starting point id
     */
    public Map<List<List<DijkstraObjectDTO<Participant, Double>>>, List<Double>> getMinimumDeliveryPathForExpeditionList(String startingPointId) {
        // Setting the starting point
        Participant startingPoint;

        // Starting point must be a Producer, otherwise exit
        if (!(startingPointId.startsWith("P"))) return null;
        else startingPoint = distributionNetwork.getParticipantByID(startingPointId);

        // Getting the minimum delivery path
        List<List<DijkstraObject<Participant, Double>>> pathPointsAndDistancesBetweenThem = new ArrayList<>();
        List<Double> distancesBetweenPoints = new ArrayList<>();

        // We don't need the first producer in the list, since it is the starting point
        participantsPresentInDispatchList.remove(startingPoint);

        // Lists of visited producers and hubs, to avoid visiting them again
        Set<Producer> visitedProducers = new HashSet<>();
        Set<Company> visitedHubs = new HashSet<>();

        for (Participant inListProducerOrHub : participantsPresentInDispatchList) {


            // If the participant is a Producer
            if (inListProducerOrHub instanceof Producer) {

                // If the producer has not been visited yet
                if (!visitedProducers.contains(inListProducerOrHub)) {

                    // Get the minimum delivery path between the starting point and the producer (building a list of points and distances between them)
                    Map<Participant, DijkstraObject<Participant, Double>> distanceFromStartingPointToAllReachableVertices = distributionNetwork.runDijkstra(startingPoint);
                    List<DijkstraObject<Participant, Double>> shortestPathFromOriginToDestination = new ArrayList<>();
                    AuxiliaryAlgorithms.buildPath(shortestPathFromOriginToDestination, distanceFromStartingPointToAllReachableVertices, startingPoint, inListProducerOrHub);

                    // Set the starting point to the producer
                    startingPoint = inListProducerOrHub;

                    // Add the path to the list of paths and setting the new starting point
                    for (DijkstraObject<Participant, Double> pathPoint : shortestPathFromOriginToDestination) {
                        if (!(pathPoint.getKey() instanceof Company) && !(pathPoint.getKey() instanceof Particular)) {
                                visitedProducers.add((Producer) pathPoint.getKey());
                        }
                    }

                    // After each iteration, add the path to the list of paths and the distance to the list of distances
                    pathPointsAndDistancesBetweenThem.add(shortestPathFromOriginToDestination);
                    distancesBetweenPoints.add(shortestPathFromOriginToDestination.get(shortestPathFromOriginToDestination.size() - 1).getDistance());
                }
            }

            // If the participant is a Hub
            else if (inListProducerOrHub instanceof Company) {

                // If the hub has not been visited yet
                if (!visitedHubs.contains(inListProducerOrHub)) {

                    // Get the minimum delivery path between the starting point and the hub
                    Map<Participant, DijkstraObject<Participant, Double>> distanceFromStartingPointToAllReachableVertices = distributionNetwork.runDijkstra(startingPoint);
                    List<DijkstraObject<Participant, Double>> shortestPathFromOriginToDestination = new ArrayList<>();
                    AuxiliaryAlgorithms.buildPath(shortestPathFromOriginToDestination, distanceFromStartingPointToAllReachableVertices, startingPoint, inListProducerOrHub);

                    // Set the starting point to the hub
                    startingPoint = inListProducerOrHub;

                    // Visiting the generated path and removing hubs that are present in that path, so we do not iterate over them again
                    for (DijkstraObject<Participant, Double> pathPoint : shortestPathFromOriginToDestination) {
                        if (!(pathPoint.getKey() instanceof Producer) && !(pathPoint.getKey() instanceof Particular)) {
                                visitedHubs.add((Company) pathPoint.getKey());
                        }
                    }

                    // After each iteration, add the path to the list of paths and the distance to the list of distances
                    pathPointsAndDistancesBetweenThem.add(shortestPathFromOriginToDestination);
                    distancesBetweenPoints.add(shortestPathFromOriginToDestination.get(shortestPathFromOriginToDestination.size() - 1).getDistance());
                }
            }
        }

        return setToUI(pathPointsAndDistancesBetweenThem, distancesBetweenPoints);
    }

}