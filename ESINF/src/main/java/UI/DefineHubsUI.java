package UI;

import Controller.DefineHubsController;
import Utils.Constants;
import Utils.Utils;

import java.util.List;
import java.util.Scanner;

public class DefineHubsUI implements Runnable {

    private final DefineHubsController controller = new DefineHubsController();

    @Override
    public void run() {
        System.out.printf(Constants.PURPLE + "|---------------------------------------------|%n                 Define Hubs%n|---------------------------------------------|%n");
        Scanner sc = new Scanner(System.in);

        // Ask for the number of hubs to be determined and get the answer
        int numberOfHubs = Utils.readIntegerFromConsole(Constants.CYAN + "Insert the number of hubs to be determined: ");
        System.out.println();

        // Check if the number of hubs is valid
        if (!isNumberOfHubsValid(numberOfHubs))  return;

        // If the number of hubs is valid, call the controller to get the hubs
        List<String> hubs = controller.getHubs(numberOfHubs);

        // Print the hubs
        if (numberOfHubs == 1)
            System.out.println(Constants.GREEN + "The hub of the distribution network is: " + Constants.RESET);
        else System.out.println(Constants.GREEN + "The hubs of the distribution network are: " + Constants.RESET);

        for (String hub : hubs) {
            System.out.printf("[HUB " + Constants.RED + "ID" + Constants.RESET + "]: %s%n", hub);
        }

        // End of the java.UI
        System.out.printf(Constants.BLUE + "%nPress enter to continue...%n%n" + Constants.RESET);
        sc.nextLine();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private boolean isNumberOfHubsValid(int numberOfHubs) {
        // Verify if the number of hubs is valid (if it is greater than 0 and less than the number of participants)
        if (!controller.isNumberOfHubsValid(numberOfHubs)) {
            System.out.printf(Constants.RED + "The number of hubs must be greater than 0 and less (or equal) than the number of companies%n%n" + Constants.RESET);
            try {
                Thread.sleep(1750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

}
