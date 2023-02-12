package Controller;

import DTO.DijkstraObjectDTO;
import Domain.Participants.Participant;
import Functionalities.ExpeditionListMinimizedPathGenerator;

import java.util.*;

public class ExpeditionListMinimizedPathController {

    private final ExpeditionListMinimizedPathGenerator expeditionListMinimizedPathGenerator = new ExpeditionListMinimizedPathGenerator();

    public boolean isDispatchListRequiredValid(int day, boolean restrictDispatchList) {
        return expeditionListMinimizedPathGenerator.isDispatchListRequiredValid(day, restrictDispatchList);
    }

    /**
     * Free to access producers for day list.
     *
     * @return the list
     */
    public List<String> getProducersFromExpeditionList() {
        return expeditionListMinimizedPathGenerator.getListOfProducers();
    }

    /**
     * Sets producers list.
     *
     * @param day                  the day
     * @param restrictDispatchList the restricted dispatch list
     */
    public void setProducersList(int day, boolean restrictDispatchList) {
        expeditionListMinimizedPathGenerator.fillWithProducersAndHubs(day, restrictDispatchList);
    }

    /**
     * Gets baskets dropped per hub.
     *
     * @return the baskets dropped per hub
     */
    public Map<String, Integer> getBasketsDroppedPerHub() {
        return expeditionListMinimizedPathGenerator.getBasketsDroppedPerHub();
    }

    /**
     * Gets minimum delivery path.
     *
     * @param startingPointId the starting point id
     */
    public Map<List<List<DijkstraObjectDTO<Participant, Double>>>, List<Double>> returnMinimizedPath(String startingPointId) {
        return expeditionListMinimizedPathGenerator.getMinimumDeliveryPathForExpeditionList(startingPointId);
    }
}