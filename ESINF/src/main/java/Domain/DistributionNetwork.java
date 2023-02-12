package Domain;

import Domain.Graph.Algorithms;
import Domain.Graph.DijkstraObject;
import Domain.Graph.Edge;
import Domain.Graph.Graph;
import Domain.Graph.map.MapGraph;
import Domain.Participants.*;
import Miscellaneous.AuxiliaryAlgorithms;

import java.util.*;

/**
 * The type Distribution network.
 */
public class DistributionNetwork {

    private Graph<Participant, Double> distributionNetwork;

    /**
     * Instantiates a new Distribution network.
     */
    public DistributionNetwork() {
        distributionNetwork = new MapGraph<>(false);
    }

    /**
     * Gets participant by the id.
     * Returns null if there is no such participant.
     *
     * @param participantID the participant id
     * @return the participant by id
     */
    public Participant getParticipantByID(String participantID) {
        for (Participant participant : distributionNetwork.vertices()) {
            if (participant.getParticipantId().equals(participantID)) {
                return participant;
            }
        }
        return null;
    }

    /**
     * Returns the Distribution Network
     *
     * @return Graph<?, ?>  the Distribution Network
     */
    public Graph<Participant, Double> getDistributionNetwork() {
        return distributionNetwork;
    }

    /**
     * Add participant.
     *
     * @param participant the participant
     */
    public void addParticipant(Participant participant) {
        distributionNetwork.addVertex(participant);
    }

    /**
     * Add route.
     *
     * @param p1     the p 1
     * @param p2     the p 2
     * @param meters the meters
     */
    public void addRoute(Participant p1, Participant p2, double meters) {
        distributionNetwork.addEdge(p1, p2, meters);
    }

    /**
     * Gets the Participant by its location id. ( Location id is unique )
     *
     * @param locationId the location id
     * @return the participant
     */
    public Participant participantByLocationId(String locationId) {

        ArrayList<Participant> vertices = distributionNetwork.vertices();

        for (Participant p : vertices) {
            String pLocationId = p.getLocation().getLocationId();
            if (pLocationId.equals(locationId)) return p;
        }
        return null;
    }

    /**
     * Gets list of participants with filter.
     *
     * @param filter the filter
     * @return the list of participants with filter
     */
    public List<Participant> getListOfParticipantsWithFilter(String filter) {
        List<Participant> participantList = new ArrayList<>();

        ArrayList<Participant> vertices = distributionNetwork.vertices();

        for (Participant p : vertices) {
            if (p.getParticipantId().startsWith(filter)) participantList.add(p);
        }
        return participantList;
    }

    /**
     * Gets list of clients.
     *
     * @return the list of clients
     */
    public List<Client> getListOfClients() {
        List<Client> participantList = new ArrayList<>();

        ArrayList<Participant> vertices = distributionNetwork.vertices();

        String participantIdentifier;
        for (Participant p : vertices) {
            if (p instanceof Client) {

                participantIdentifier = p.getParticipantId().substring(0, 1);
                if (participantIdentifier.equals(Participant.COMPANY) || participantIdentifier.equals(Participant.PARTICULAR))
                    participantList.add((Client) p);
            }
        }
        return participantList;
    }

    /**
     * Checks if there are hubs
     *
     * @return the of hub
     */
    public boolean getListOfHUB() {
        List<Company> companyList = new ArrayList<>();

        ArrayList<Participant> vertices = distributionNetwork.vertices();

        for (Participant p : vertices) {
            if (p.getParticipantId().startsWith(Participant.COMPANY)) {
                if (((Company) p).isHub()) companyList.add((Company) p);
            }
        }
        return companyList.isEmpty();
    }

    /**
     * Checks if the network has any information.
     *
     * @return true if the network has no information, false otherwise
     */
    public boolean isEmpty() {
        return distributionNetwork.numVertices() == 0 || distributionNetwork.edges() == null;
    }


    /**
     * Gets number participants.
     *
     * @return the num participants
     */
    public int getNumParticipants() {
        return distributionNetwork.numVertices();
    }

    /**
     * Clear.
     */
    public void clear() {
        distributionNetwork = new MapGraph<>(false);
    }


    /**
     * Determine hubs list.
     *
     * @param numberOfHubs the number of hubs
     * @return the list
     */
    public List<String> determineHubs(int numberOfHubs) {
        // Get a list of all the companies
        List<Participant> companies = getCompanies();
        // Array with all the distances between the companies and other participants
        List<Hub> hubs = new ArrayList<>();

        // For each company, get the distance to all the other participants
        double companyAverageDistance;
        for (Participant company : companies) {
            companyAverageDistance = calculateDistancesAverage(company);
            hubs.add(new Hub(company.getParticipantId(), companyAverageDistance));
        }

        // Sort the array
        Collections.sort(hubs);

        // Get the first numberOfHubs elements
        List<String> hubIds = new ArrayList<>();
        for (int i = 0; i < numberOfHubs; i++) {
            String id = hubs.get(i).participantID();
            hubIds.add(id);
            Company newHub = (Company) getParticipantByID(id);
            newHub.markAsHub();
        }

        return hubIds;
    }

    /**
     * Run dijkstra map.
     *
     * @param source the source
     * @return the map
     */
    public Map<Participant, DijkstraObject<Participant, Double>> runDijkstra(Participant source) {

        // Map containing the vertices and a boolean to check whether they have been visited
        Map<Participant, Boolean> visited = new HashMap<>();

        /* This map will keep track of the connections with the least cost, meaning all the path from the source to any destination
           It's a map because this way it's easier to get the corresponding object giving the vertex */
        Map<Participant, DijkstraObject<Participant, Double>> dijkstraObjectMap = new HashMap<>();
        DijkstraObject<Participant, Double> first = new DijkstraObject<>(source, 0.0, null);

        dijkstraObjectMap.put(source, first);

        // If filter is null, then we want to visit all the vertices
        List<Participant> vertices = distributionNetwork.vertices();

        // When starting the algorithm, all the distance are considered infinite and all the vertices are unvisited
        for (Participant participant : vertices) {
            if (!participant.equals(source))
                dijkstraObjectMap.put(participant, new DijkstraObject<>(participant, null, null));
            visited.put(participant, false);
        }

        // Call the dijkstra algorithm
        AuxiliaryAlgorithms.shortestPathDijkstra(distributionNetwork, source, visited, dijkstraObjectMap);

        return dijkstraObjectMap;
    }

    /**
     * Calculate the distances average of all the routes of a company .
     *
     * @param company the company
     * @return the average distance
     */
    private double calculateDistancesAverage(Participant company) {

        // Sum the distance of all the routes of the company
        double totalDistance = 0;

        Map<Participant, DijkstraObject<Participant, Double>> dijkstraObjectMap = runDijkstra(company);

        // Get the total distance
        for (DijkstraObject<Participant, Double> dijkstraObject : dijkstraObjectMap.values()) {
            if (dijkstraObject.getDistance() != null)
                totalDistance += dijkstraObject.getDistance();
        }

        // Calculate the average distance and return it
        return totalDistance / (distributionNetwork.numVertices() - 1);
    }

    /**
     * Gets all the companies in the network.
     *
     * @return a List with all the companies
     */
    private List<Participant> getCompanies() {
        List<Participant> companies = new ArrayList<>();
        for (Participant p : distributionNetwork.vertices()) {
            if (Participant.COMPANY.equals(p.getParticipantId().substring(0, 1))) {
                companies.add(p);
            }
        }
        return companies;
    }

    /**
     * Gets the number of companies in the network.
     *
     * @return the num of companies
     */
    public int getNumOfCompanies() {
        return getCompanies().size();
    }

    /**
     * Checks if the Network Contains participant.
     *
     * @param participant the participant
     * @return the boolean
     */
    public boolean containsParticipant(Participant participant) {
        // Get the list of all the participants
        ArrayList<Participant> vertices = distributionNetwork.vertices();

        // Return true if the list contains the participant
        return vertices.contains(participant);
    }

    /**
     * Generates a map with the relation of tje participants and the nearest hub.
     *
     * @param listOfClients the list of clients
     * @return the map
     */
    public Map<String, String> findNearestHUB(List<Client> listOfClients) {
        // Map containing the clients and the nearest hub
        Map<String, String> clientIdToHubId = new HashMap<>();

        // Get the list of all the hubs
        for (Client client : listOfClients) {
            String id = findNearestHUBDistance(client);
            // Add the client and the nearest hub to the map if the hub exists and is not the client itself
            if (id != null) clientIdToHubId.put(client.getParticipantId(), id);
        }

        return clientIdToHubId;
    }

    /**
     * Find the nearest hub to a client.
     *
     * @param client the company
     * @return the average distance
     */
    public String findNearestHUBDistance(Client client) {
        double minDistance = Double.MAX_VALUE;
        List<String> hubIds = new ArrayList<>();

        Map<Participant, DijkstraObject<Participant, Double>> dijkstraObjectMap = runDijkstra(client);

        // Get the total distance to each HUB and determine the minimum
        for (DijkstraObject<Participant, Double> dijkstraObject : dijkstraObjectMap.values()) {
            if (dijkstraObject.getKey().getParticipantId().charAt(0) == 'E' && dijkstraObject.getDistance() != null && dijkstraObject.getDistance() < minDistance) {
                Company p = (Company) dijkstraObject.getKey();

                // If the participant is a hub and is not the client him-self, add it to the list
                if (p.isHub() && !client.equals(dijkstraObject.getKey())) {

                    // If the distance is the same or less than the minimum, add it to the list
                    minDistance = dijkstraObject.getDistance();
                    hubIds.add(dijkstraObject.getKey().getParticipantId());
                }
            }
        }

        // Return the id of the nearest HUB to the client
        if (hubIds.size() > 0) {
            String nearestHub = hubIds.get(hubIds.size() - 1);
            client.setNearestHub(nearestHub);
            return nearestHub;
        } else return null;
    }

    /**
     * Gets the N producers that are closest to client hub.
     *
     * @param client the client
     * @param n      the n
     * @return the n producers closest to client hub
     */
    public List<Producer> getNProducersClosestToClientHub(Client client, int n) {

        // Get Dijkstra's map from the hub (distanceToAllTheParticipants)
        Map<Participant, DijkstraObject<Participant, Double>> distanceToAllTheParticipants = runDijkstra(getParticipantByID(client.getNearestHubId()));

        // Get a map with the producers and their distance from the hub
        Map<Participant, DijkstraObject<Participant, Double>> distanceToAllTheProducers = new HashMap<>();
        for (Participant participant : distanceToAllTheParticipants.keySet()) {
            if (participant.getParticipantId().startsWith(Participant.PRODUCER)) {
                distanceToAllTheProducers.put(participant, distanceToAllTheParticipants.get(participant));
            }
        }

        // Sort the map by the distance
        List<Map.Entry<Participant, DijkstraObject<Participant, Double>>> sortedMap = new ArrayList<>(distanceToAllTheProducers.entrySet());
        sortedMap.sort(Comparator.comparingDouble(o -> o.getValue().getDistance()));


        // Get the n producers that are closest to the hub
        List<Producer> closestProducers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            closestProducers.add((Producer) sortedMap.get(i).getKey());
        }

        return closestProducers;
    }

    /**
     * Gets the hubs of the network.
     *
     * @return the hubs
     */
    public List<Company> getHubs() {
        List<Company> hubs = new ArrayList<>();
        for (Participant p : distributionNetwork.vertices()) {
            if (Participant.COMPANY.equals(p.getParticipantId().substring(0, 1))) {
                Company c = (Company) p;
                if (c.isHub()) hubs.add(c);
            }
        }
        return hubs;
    }

}