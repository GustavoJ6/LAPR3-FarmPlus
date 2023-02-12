package Controller;

import Domain.DistributionNetworkData;

import java.util.List;

/**
 * The Find hubs controller.
 */
public class DefineHubsController {
    private final DistributionNetworkData networkData = App.getInstance().getSystemData();

    /**
     * Checks if the number of hubs valid.
     *
     * @param numberOfHubs the number of hubs
     * @return true if the number of hubs is valid, false otherwise
     */
    public boolean isNumberOfHubsValid(int numberOfHubs) {
        int numOfCompanies = networkData.getDistributionNetwork().getNumOfCompanies();

        return numberOfHubs > 0 && numberOfHubs <= numOfCompanies;
    }

    public int getNumOfCompanies() {
        return networkData.getDistributionNetwork().getNumOfCompanies();
    }

    /**
     * Gets the hubs.
     *
     * @param numberOfHubs the number of hubs
     */
    public List<String> getHubs(int numberOfHubs) {
        return networkData.getDistributionNetwork().determineHubs(numberOfHubs);
    }
}
