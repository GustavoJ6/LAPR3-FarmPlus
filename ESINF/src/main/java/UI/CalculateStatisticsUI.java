package UI;

import Controller.CalculateStatisticsController;
import Miscellaneous.*;
import Utils.Constants;
import Utils.Utils;

import java.util.*;

public class CalculateStatisticsUI implements Runnable {

    private final CalculateStatisticsController controller;

    public CalculateStatisticsUI() {
        controller = new CalculateStatisticsController();
    }


    @Override
    public void run() {
        int typeOption, listOption, statsOption;
        System.out.printf(Constants.PURPLE + "|---------------------------------------------|%n              Calculate Statistics   %n|---------------------------------------------|%n" + Constants.RESET);

        typeOption = Utils.showAndSelectIndex(List.of(new String[]{Constants.BLUE + "Simple" + Constants.RESET + " Dispatch List", Constants.RED + "Restricted" + Constants.RESET + " Dispatch List"}), "Select the type of dispatch list you want to use:");
        if (typeOption == -1) return;
        boolean isSimple = typeOption != 1;


        System.out.printf("%n");
        if (isSimple) {
            listOption = Utils.showAndSelectIndex(controller.getSimpleDispatchListToPrint(), "Simple Dispatch Lists");
            if (listOption == -1) return;
            controller.calculateStatistics(listOption, true);
        } else {
            listOption = Utils.showAndSelectIndex(controller.getDispatchListWithRestrictionToPrint(), "Dispatch Lists With Restrictions");
            if (listOption == -1) return;
            controller.calculateStatistics(listOption, false);
        }

        do {

            System.out.printf("%nChoose the " + Constants.GREEN + " statistics" + Constants.RESET + " you want to visualize:%n");


            System.out.printf(
                    Constants.BLUE + "1 - Basket Order%n" +
                            "2 - Client%n" +
                            "3 - Producer%n" +
                            "4 - Hub%n" +
                            Constants.RESET + "0 - Back%n");

            statsOption = Utils.readIntegerFromConsole("Option: ");
            System.out.println();


            switch (statsOption) {
                case 0 -> {
                    System.out.println("Returning to Main Menu...");
                    return;
                }
                case 1 -> {
                    System.out.printf("%n" + Constants.BLUE + "%-5s" +  Constants.GREEN + "%-5s"  + Constants.RED + "%-5s" + Constants.YELLOW + "%-5s" + Constants.PURPLE + "%-5s" + Constants.RESET + "%n",
                            "TS", "PS", "NS", "%S", "NP");
                    for (BasketOrderStatistics info : controller.getBasketOrderStatistics())
                        System.out.println(info);

                    System.out.printf("%n%n" +
                            Constants.BLUE   + "TS " + Constants.RESET + "- Number of Products Totally Satisfied%n" +
                            Constants.GREEN  + "PS " + Constants.RESET + "- Number of Products Partially Satisfied%n" +
                            Constants.RED    + "NS " + Constants.RESET + "- Number of Products Not Satisfied%n" +
                            Constants.YELLOW + "%%S " + Constants.RESET + "- Percentage of Satisfaction%n" +
                            Constants.PURPLE + "NP " + Constants.RESET + "- Number of Different Producers%n" +
                            "");
                }
                case 2 -> {
                    System.out.printf("%n" + Constants.YELLOW + "%-5s" +  Constants.GREEN + "%-5s" + Constants.BLUE + "%-5s" + Constants.RED + "%-5s" + Constants.RESET + "%n", "ID", "TS", "PS", "NP");

                    for (ClientStatistics info : controller.getClientStatistics())
                        System.out.println(info);

                    System.out.printf("%n%n" +
                            Constants.YELLOW  + "ID" + Constants.RESET + " - Client ID%n" +
                            Constants.GREEN   + "TS" + Constants.RESET + " - Totally Satisfied%n" +
                            Constants.BLUE    + "PS" + Constants.RESET + " - Partially Satisfied%n" +
                            Constants.RED     + "NP" + Constants.RESET + " - Number of Different Producers%n"
                            );
                }
                case 3 -> {
                    // Folow the same pattern as the HubStats
                    System.out.printf("%n" + Constants.YELLOW + "%-5s" +  Constants.GREEN + "%-5s" + Constants.BLUE + "%-5s"  + Constants.RED + "%-5s" + Constants.CYAN + "%-5s" + Constants.PURPLE + "%-5s" + Constants.RESET + "%n",
                            "ID", "TS", "PS", "NC", "NSO", "NH");
                    for (ProducerStatistics info : controller.getProducersStatistics())
                        System.out.println(info);

                    System.out.printf("%n%n" +
                            Constants.YELLOW + "ID " + Constants.RESET + " - Producer Id%n" +
                            Constants.GREEN  + "TS " + Constants.RESET + " - Totally Satisfied%n" +
                            Constants.BLUE   + "PS " + Constants.RESET + " - Partially Satisfied%n" +
                            Constants.RED    + "NC " + Constants.RESET + " - Number of Different Clients%n" +
                            Constants.CYAN   + "NSO " + Constants.RESET + "- Number of Products Sold out%n" +
                            Constants.PURPLE + "NH " + Constants.RESET + " - Number of Supplied Huds%n" +
                            "");
                }
                case 4 -> {
                    System.out.printf("%n" + Constants.YELLOW + "%-5s" +  Constants.BLUE + "%-5s" + Constants.RED + "%-5s" + Constants.RESET + "%n", "ID", "NC", "NP");

                    for (HubStatistics info : controller.getHubStatistics())
                        System.out.println(info);

                    System.out.printf("%n%n" +
                            Constants.YELLOW + "ID " + Constants.RESET + "- Hub Id%n" +
                            Constants.BLUE   + "NC " + Constants.RESET + "- Number of Different Clients%n" +
                            Constants.RED    + "NP " + Constants.RESET + "- Number of Different Producers%n" +
                            "");
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
}
