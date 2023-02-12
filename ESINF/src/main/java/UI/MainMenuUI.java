package UI;

import Controller.App;
import Utils.Constants;
import Utils.Utils;

public class MainMenuUI implements Runnable {

    private final App app = App.getInstance();

    @Override
    public void run() {

        int option;
        do {
            System.out.print(Constants.PURPLE + "|---------------------------------------------|\n                   Main Menu\n|---------------------------------------------|\n");

            System.out.println(Constants.GREEN + "Choose what you want to do:");

            System.out.printf(Constants.BLUE + "1 - Load data from files - [US301 + US307]%n" +
                    "2 - Check if the graph is connected and the furthest pair of vertices - [US302]%n" +
                    "3 - Define the 'N' hubs of the distribution network - [US303]%n" +
                    "4 - Find the nearest hub to each client - [US304]%n" +
                    "5 - Get the Network that connects all the clients and producers - [US305]\n" +
                    "6 - Check Watering Controller - [US306]%n" +
                    "7 - Generate a dispatch list for a given day, with no restrictions - [US308]%n" +
                    "8 - Generate a dispatch list for a given day, with the N closest producers of a client's hub, for each client - [US309]%n" +
                    "9 - Generate the minimized cost delivery path for an expedition list - [US310]%n" +
                    "10 - Calculate Statistics for the Distribution Network - [US311]%n" +
                    Constants.RED + "0 - Exit%n " + Constants.RESET);

            option = Utils.readIntegerFromConsole("Option: ");
            System.out.println();

            switch (option) {
                case 0 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                case 1 -> {
                    LoadDataFromFilesUI loadDataFromFilesUI = new LoadDataFromFilesUI();
                    loadDataFromFilesUI.run();
                }
                case 2 -> {
                    // Can only run if there is a graph and connections loaded
                    if (app.isSystemDataEmpty())
                        noData("No data loaded yet");

                    else if (app.isRouteEmpty())
                        noData("No routes loaded yet");

                    else {
                        MostDistantPairOfVertivesUI ui = new MostDistantPairOfVertivesUI();
                        ui.run();

                    }
                }
                case 3 -> {
                    // Can only run if there is a graph and connections loaded
                    if (app.isSystemDataEmpty())
                        noData("No data loaded yet");

                    else if (app.isRouteEmpty())
                        noData("No routes loaded yet");

                    else {
                        DefineHubsUI ui = new DefineHubsUI();
                        ui.run();
                    }
                }
                case 4 -> {
                    FindNearestHubUI findNearestHubUI = new FindNearestHubUI();
                    findNearestHubUI.run();
                }
                case 5 -> {
                    ConnectionNetworkUI connectionNetworkUI = new ConnectionNetworkUI();
                    connectionNetworkUI.run();
                }
                case 6 -> {
                    if (!app.isWateringStoreEmpty()) {
                        WateringUI ui = new WateringUI();
                        ui.run();
                    } else
                        noData("You need to load a watering plan first");

                }
                case 7 -> {
                    if (app.isSystemDataEmpty())
                        noData("No data loaded yet");

                    else if (app.isRouteEmpty())
                        noData("No routes loaded yet");

                    else if (app.getSystemData().getOrders().isEmpty())
                        noData("No orders loaded yet");

                    else {
                        GenerateSimpleDispatchListUI ui = new GenerateSimpleDispatchListUI();
                        ui.run();
                    }
                }
                case 8 -> {
                    if (app.isSystemDataEmpty())
                        noData("No data loaded yet");

                    else if (app.isRouteEmpty())
                        noData("No routes loaded yet");

                    else if (app.getSystemData().getOrders().isEmpty())
                        noData("No orders loaded yet");

                    else if (app.getSystemData().areThereNoHubsDefined())
                        noData("No hubs defined yet");

                    else {
                        GenerateDispatchListWithRestrictionsUI ui = new GenerateDispatchListWithRestrictionsUI();
                        ui.run();
                    }
                }

                case 9 -> {
                    if (app.isSystemDataEmpty())
                        noData("No data loaded yet");

                    else if (app.isRouteEmpty())
                        noData("No routes loaded yet");

                    else if (app.getSystemData().getOrders().isEmpty())
                        noData("No orders loaded yet");

                    else if (app.getSystemData().areThereNoHubsDefined())
                        noData("No hubs defined yet");

                    else if (!app.isThereAnyNearestHubDefined())
                        noData("No nearest hub defined yet");

                    else if (app.getSystemData().getSimpleDispatchLists().isEmpty() && app.getSystemData().getDispatchListsWithRestrictions().isEmpty())
                        noData("No dispatch lists generated yet");

                    else {
                        ExpeditionListMinimizedPathUI ui = new ExpeditionListMinimizedPathUI();
                        ui.run();
                    }
                }
                case 10 -> {
                    if (app.isSystemDataEmpty())
                        noData("No data loaded yet");

                    else if (app.isRouteEmpty())
                        noData("No routes loaded yet");

                    else if (app.getSystemData().getOrders().isEmpty())
                        noData("No orders loaded yet");

                    else if (app.getSystemData().areThereNoHubsDefined())
                        noData("No hubs defined yet");

                    else if (!app.isThereAnyNearestHubDefined())
                        noData("No nearest hub defined yet");

                    else if (app.getSystemData().getSimpleDispatchLists().isEmpty() && app.getSystemData().getDispatchListsWithRestrictions().isEmpty())
                        noData("No dispatch lists generated yet");

                    else {
                        CalculateStatisticsUI ui = new CalculateStatisticsUI();
                        ui.run();
                    }
                }


                default -> {
                    System.out.printf(Constants.RED + "Invalid option" + Constants.RESET + "%n%n");
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } while (true);
    }

    private void noData(String message) {
        System.out.printf(Constants.RED + message + Constants.RESET + "%n%n");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
