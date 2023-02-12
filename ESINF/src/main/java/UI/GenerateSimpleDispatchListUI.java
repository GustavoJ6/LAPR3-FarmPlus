package UI;

import Controller.GenerateDispatchListController;
import Domain.Products.BasketOrder;
import Domain.Products.Product;
import Utils.Constants;
import Utils.Utils;

import java.util.List;

public class GenerateSimpleDispatchListUI implements Runnable {

    private final GenerateDispatchListController controller = new GenerateDispatchListController();

    @Override
    public void run() {

        System.out.println(Constants.PURPLE + "------------------------");
        System.out.println("|Generate Dispatch List|");
        System.out.println("------------------------" + Constants.RESET);

        int day = Utils.readIntegerFromConsole("Please insert the day to generate the dispatch list: ");

        // If there are no orders for the day, then there is no need to generate a dispatch list
        if (!controller.areThereOrdersForDay(day)) {
            System.out.println(Constants.RED + "There are no orders for the day " + day + ". It is not possible to generate a dispatch list!!!\n" + Constants.RESET);
            return;
        }

        // Get the dispatch list
        List<BasketOrder> dispatchList = controller.generateSimpleDispatchList(day);

        if (dispatchList != null){
            // Print the dispatch list
            printDispatchList(dispatchList);
            System.out.println();
        }else{
            System.out.println(Constants.RED + "There are no products available to fulfill the orders for the day " + day + ". It is not possible to generate a dispatch list!!!\n" + Constants.RESET);
        }


    }

    private void printDispatchList(List<BasketOrder> dispatchList) {


        System.out.printf("\nThe dispatch list for day: %s %d %s is:\n\n", Constants.RED, dispatchList.get(0).getDay(), Constants.RESET);
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
