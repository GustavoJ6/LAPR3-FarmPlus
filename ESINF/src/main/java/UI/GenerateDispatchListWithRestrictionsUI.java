package UI;

import Controller.GenerateDispatchListController;
import Domain.Products.BasketOrder;
import Domain.Products.Product;
import Utils.Constants;
import Utils.Utils;

import java.util.List;

public class GenerateDispatchListWithRestrictionsUI implements Runnable {

    private final GenerateDispatchListController controller = new GenerateDispatchListController();

    @Override
    public void run() {

        System.out.println(Constants.PURPLE + "-----------------------------------------------------");
        System.out.println("|Generate Dispatch List With The N Closest Producers|");
        System.out.println("-----------------------------------------------------" + Constants.RESET);

        int day = Utils.readIntegerFromConsole("Please insert the day to generate the dispatch list: ");
        // If there are no orders for the day, then there is no need to generate a dispatch list
        if (!controller.areThereOrdersForDay(day)) {
            System.out.println(Constants.RED + "There are no orders for the day " + day + ". It is not possible to generate a dispatch list!!!\n" + Constants.RESET);
            return;
        }

        // If there are not enough producers in the network, then it cant be generated a dispatch list
        int nProducers = Utils.readIntegerFromConsole("Please insert the number of producers to consider, per client: ");
        if (!controller.areThereNProducersInTheNetwork(nProducers)) {
            System.out.println(Constants.RED + "There are not enough producers in the network to generate a dispatch list with " + nProducers + " producers per client!!!\n" + Constants.RESET);
            return;
        }

        // Get the dispatch list
        List<BasketOrder> dispatchList = controller.generateDispatchListWithRestrictions(day, nProducers);

        if (dispatchList != null) {
            // Print the dispatch list
            printDispatchList(dispatchList, nProducers);
            System.out.println();
        } else {
            System.out.println(Constants.RED + "The eligible producers do not have products available to fulfill the orders for the day " + day + ". It is not possible to generate a dispatch list!!!\n" + Constants.RESET);
        }


    }

    private void printDispatchList(List<BasketOrder> dispatchList, int nProducers) {
        System.out.printf("\nThe dispatch list for day: %s %d %s, with the %d closest producers for each client's hub is:\n\n", Constants.RED, dispatchList.get(0).getDay(), Constants.RESET, nProducers);
        for (BasketOrder order : dispatchList) {
            System.out.printf(Constants.CYAN + "Client: " + Constants.RESET + order.getClient().getClientId() + "\n");
            printProductsPerOrder(order);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void printProductsPerOrder(BasketOrder order) {
        for (Product product : order.getProducts()) {
            System.out.println(product);
        }
        System.out.println();
    }


}
