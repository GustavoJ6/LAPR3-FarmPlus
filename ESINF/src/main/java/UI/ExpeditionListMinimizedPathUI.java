package UI;

import Controller.ExpeditionListMinimizedPathController;
import DTO.DijkstraObjectDTO;
import Domain.Participants.Participant;
import Utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpeditionListMinimizedPathUI implements Runnable {

    private final ExpeditionListMinimizedPathController expeditionListMinimizedPathController = new ExpeditionListMinimizedPathController();

    @Override
    public void run() {

        // Main Title
        mainTitle();

        // Allow the user to choose between the simple and restricted dispatch list
        int option = Utils.showAndSelectIndex(List.of(new String[]{Constants.BLUE + "Simple" + Constants.RESET + " Dispatch List", Constants.RED + "Restricted" + Constants.RESET + " Dispatch List"}), "Select the type of dispatch list you want to use:");
        if (option == -1) return;
        boolean restrictDispatchList = option == 1;

        int day = Utils.readIntegerFromConsole("Please insert the " + Constants.GREEN + "day" + Constants.RESET + " to generate the minimized cost path for an expedition list: ");

        // Check if there is a filled dispatch list for the day
        if (expeditionListMinimizedPathController.isDispatchListRequiredValid(day, restrictDispatchList)) {
            // Get the list with all the available starting points
            expeditionListMinimizedPathController.setProducersList(day, restrictDispatchList);

            // Allow the user to select the starting point of the expedition list
            int startingPoint = Utils.showAndSelectIndex(expeditionListMinimizedPathController.getProducersFromExpeditionList(), "\nPlease select the" + Constants.YELLOW + " starting point" + Constants.RESET + " of the expedition list: ");

            // Baskets dropped per hub (Output Requirement)
            Map<String, Integer> basketsDroppedPerHub = expeditionListMinimizedPathController.getBasketsDroppedPerHub();

            // Print the numbers of baskets dropped per hub
            printBasketsDroppedPerHub(basketsDroppedPerHub);

            // Generate the expedition list
            Map<List<List<DijkstraObjectDTO<Participant, Double>>>, List<Double>> pathsAndDistances = expeditionListMinimizedPathController.returnMinimizedPath(expeditionListMinimizedPathController.getProducersFromExpeditionList().get(startingPoint));

            // Print the expedition list
            printExpeditionList(pathsAndDistances);

        } else System.out.println("\nThere is" + Constants.RED + " no" + Constants.RESET + " filled dispatch list for the day " + Constants.RED + day + Constants.RESET + ".\n");

    }

    private void mainTitle() {
        System.out.printf("----------------\n|" + Constants.GREEN + "Minimized Path" + Constants.RESET + "|\n----------------\n\n");
    }

    private void printBasketsDroppedPerHub(Map<String, Integer> basketsDroppedPerHub) {
        // Data to be displayed in the bar chart
        List<Integer> data = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        int counterFor5;

        System.out.println(Constants.BLUE + "\nBaskets " + Constants.RESET + "dropped per" + Constants.YELLOW + " hub" + Constants.RESET + ":\n");

        for (Map.Entry<String, Integer> entry : basketsDroppedPerHub.entrySet()) {
            data.add(entry.getValue());
            labels.add(entry.getKey());
        }

        // Create the bar chart
        for (int i = 0; i < data.size(); i++) {
            System.out.printf("%s | ", labels.get(i));
            counterFor5 = 1;
            for (int j = 0; j < data.get(i); j++) {
                System.out.print("*");
                if (counterFor5 % 5 == 0) {
                    System.out.print(" ");
                }
                counterFor5++;
            }
            System.out.printf(" | (%d baskets dropped)", data.get(i));
            System.out.print("\n");
        }
    }
    private void printExpeditionList(Map<List<List<DijkstraObjectDTO<Participant, Double>>>, List<Double>> pathsAndDistances) {
        System.out.println();
        for (Map.Entry<List<List<DijkstraObjectDTO<Participant, Double>>>, List<Double>> entry : pathsAndDistances.entrySet()) {
            List<List<DijkstraObjectDTO<Participant, Double>>> paths = entry.getKey();
            List<Double> distances = entry.getValue();

            int pathIndex = 1;
            for (List<DijkstraObjectDTO<Participant, Double>> path : paths) {

                System.out.printf("Path Segment " + Constants.GREEN + pathIndex + Constants.RESET + ":\n");

                for (int position = 0; position < path.size(); position++) {
                    if (position != path.size() - 1)
                        System.out.print(path.get(position).getKey().getParticipantId() + Constants.BLUE + " -> " + Constants.RESET);
                    else System.out.printf(path.get(position).getKey().getParticipantId() + "\n");
                }
                System.out.printf(Constants.PURPLE + "Distance" + Constants.RESET + ": %.1fm\n\n", distances.get(pathIndex - 1));
                pathIndex++;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            // Print the total distance of the expedition list
            System.out.printf(Constants.YELLOW + "Total Distance" + Constants.RESET + ": %.1fm\n\n", distances.stream().mapToDouble(Double::doubleValue).sum());
        }
    }
}