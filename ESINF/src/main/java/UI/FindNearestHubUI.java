package UI;

import Controller.FindNearestHubController;
import Utils.Constants;

import java.util.Map;

public class FindNearestHubUI implements Runnable {

    private final FindNearestHubController findNearestHubController = new FindNearestHubController();

    @Override
    public void run() {
        // If the hub's list is empty, then there are no hubs to find the nearest one
        if (!findNearestHubController.hubExist()) {
            Map<String, String> clientIdToHUBId = findNearestHubController.getNearestHub();
            printClientIdAndHubId(clientIdToHUBId);
        }
        else {
            System.out.println("Please at least one" + Constants.BLUE + " Hub " + Constants.RESET + "to use this functionality\n");
        }
    }

    private void printClientIdAndHubId(Map<String, String> clientIdToHUBId) {
        System.out.print("-------------\n|Nearest" + Constants.PURPLE + " HUB" +  Constants.RESET + "|\n-------------\n\n");

        // Print the client id and the nearest hub id
        for (Map.Entry<String, String> entry : clientIdToHUBId.entrySet()) {
            System.out.printf("[Client" + Constants.RED + " ID" + Constants.RESET + "]: " + entry.getKey() + " -> [HUB" + Constants.BLUE + " ID" + Constants.RESET + "]: " + entry.getValue() + "\n\n");
        }
        System.out.println();
    }
}
