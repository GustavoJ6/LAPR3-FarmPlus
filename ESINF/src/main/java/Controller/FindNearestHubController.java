package Controller;

import Domain.Participants.Client;
import Domain.DistributionNetworkData;

import java.util.List;
import java.util.Map;

/**
 * The type Find the nearest hub controller.
 */
public class FindNearestHubController {
    private final DistributionNetworkData networkData = App.getInstance().getSystemData();

    /**
     * Hub exist boolean.
     *
     * @return the boolean
     */
    public boolean hubExist() {
        return networkData.getDistributionNetwork().getListOfHUB();
    }

    private List<Client> getListOfClients() {
        return networkData.getDistributionNetwork().getListOfClients();
    }

    /**
     * Gets the nearest hub.
     *
     * @return the nearest hub
     */
    public Map<String, String> getNearestHub() {
        List<Client> listOfClients = getListOfClients();
        return networkData.getDistributionNetwork().findNearestHUB(listOfClients);
    }
}