package Controller;

import Domain.Participants.Client;
import Domain.Products.BasketOrder;
import Domain.DistributionNetworkData;
import Functionalities.DispatchListGenerator;

import java.util.List;

// This class should be used for all the dispatch list generators
public class  GenerateDispatchListController {
    private final DistributionNetworkData distributionNetworkData = App.getInstance().getSystemData();
    private final DispatchListGenerator listGenerator = new DispatchListGenerator();

    /**
     * Generate simple dispatch list.
     *
     * @param day the day
     * @return the list
     */
    public List<BasketOrder> generateSimpleDispatchList(int day) {
        // Check if the dispatch list is already generated
        List<BasketOrder> dispatchList = getSimpleDispatchListOfDayIfAlreadyGenerated(day);
        if (dispatchList != null) {
            return dispatchList;
        }

        simulateSimpleGenerationsBeforeDay(day);
        return listGenerator.generateSimpleDispatchList(distributionNetworkData.getOrders(), day);
    }

    /**
     * Generate dispatch list with restrictions list.
     *
     * @param day the day
     * @param n   the n
     * @return the list
     */
    public List<BasketOrder> generateDispatchListWithRestrictions(int day, int n) {

        // Get the client's closest hub
        List<Client> listOfClients = distributionNetworkData.getDistributionNetwork().getListOfClients();
        if (listOfClients.get(0).getNearestHubId() == null) {
            distributionNetworkData.getDistributionNetwork().findNearestHUB(listOfClients);
        }

        simulateDispatchListsWithRestrictionsBeforeDay(day, n);
        return listGenerator.generateDispatchListWithRestrictions(distributionNetworkData.getOrders(), day, n);
    }

    public List<BasketOrder> getDispatchListWithRestrictionsOfDayIfAlreadyExists(int day) {

        try {
            return distributionNetworkData.getDispatchListsWithRestrictions().stream()
                    .filter(dispatchList -> dispatchList.get(0).getDay() == day)
                    .findFirst()
                    .orElse(null);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * Checks if there orders for the day.
     *
     * @param day the day
     * @return the boolean
     */
    public boolean areThereOrdersForDay(int day) {
        return distributionNetworkData.areThereOrdersForDay(day);
    }

    /**
     * Checks if there N producers in the day
     *
     * @param n the n
     * @return the boolean
     */
    public boolean areThereNProducersInTheNetwork(int n) {
        return distributionNetworkData.areThereNProducersInTheNetwork(n);
    }
    private void simulateSimpleGenerationsBeforeDay(int day) {
        for (int daySimulator = 1; daySimulator < day; daySimulator++) {
            listGenerator.generateSimpleDispatchList(distributionNetworkData.getOrders(), daySimulator);
        }
    }

    private void simulateDispatchListsWithRestrictionsBeforeDay(int day, int n) {
        for (int daySimulator = 1; daySimulator < day; daySimulator++) {
            listGenerator.generateDispatchListWithRestrictions(distributionNetworkData.getOrders(), daySimulator, n);
        }
    }

    private List<BasketOrder> getSimpleDispatchListOfDayIfAlreadyGenerated(int day) {
        return distributionNetworkData.getSimpleDispatchLists().stream()
                .filter(dispatchList -> dispatchList.get(0).getDay() == day)
                .findFirst()
                .orElse(null);
    }
}
