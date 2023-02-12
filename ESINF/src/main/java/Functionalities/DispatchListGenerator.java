package Functionalities;

import Controller.App;
import Domain.DistributionNetworkData;
import Domain.Participants.Client;
import Domain.Participants.Producer;
import Domain.Products.BasketOrder;
import Domain.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class DispatchListGenerator {

    private final DistributionNetworkData networkData = App.getInstance().getSystemData();
    private final List<Product> productsAvailableInTheNetwork;
    private int numberOfProducersToConsiderPerClient;
    private List<Product> productsToBeUsedInOrder;

    public DispatchListGenerator() {
        productsAvailableInTheNetwork = networkData.getProductsAvailableInTheNetwork();
    }

    /**
     * Generate simple dispatch list.
     *
     * @param orders the orders
     * @param day    the day
     * @return the list
     */
    public List<BasketOrder> generateSimpleDispatchList(List<BasketOrder> orders, int day) {
        // Generate the dispatch list
        List<BasketOrder> dispatchList = generateDispatchList(orders, day, true);
        // Add the dispatch list to the list of simple dispatch lists
        if (dispatchList != null) {
            networkData.getSimpleDispatchLists().add(dispatchList);
        }
        return dispatchList;
    }

    /**
     * Generate dispatch list with restrictions.
     *
     * @param orders the orders
     * @param day    the day
     * @param n      the n
     * @return the list
     */
    public List<BasketOrder> generateDispatchListWithRestrictions(List<BasketOrder> orders, int day, int n) {
        // Set the number of producers to consider per client
        numberOfProducersToConsiderPerClient = n;
        // Generate the dispatch list
        List<BasketOrder> dispatchList = generateDispatchList(orders, day, false);
        // Add the dispatch list to the list of dispatch lists with restrictions
        if (dispatchList != null) {
            networkData.getDispatchListsWithRestrictions().add(dispatchList);
        }
        return dispatchList;
    }

    // Given a list of orders, generate a dispatch list
    private List<BasketOrder> generateDispatchList(List<BasketOrder> orders, int day, boolean isSimpleDispatchList) {

        List<BasketOrder> dispatchList = new ArrayList<>();

        // Get the list of orders of that day
        List<BasketOrder> ordersOfThatDay = orders.stream()
                .filter(order -> order.getDay() == day)
                .toList();

        // For each order fill it with the products available
        for (BasketOrder order : ordersOfThatDay) {
            if (productsAvailableInTheNetwork.isEmpty()) {
                order.setIsFulfilled(false);
                break;
            }

            setProductsToBeUsedInOrder(order, isSimpleDispatchList);

            // For each product in the order, try to fill it
            boolean isOrderFulfilled = false;
            for (Product product : order.getProducts()) {

                // Fill the product with the products available
                boolean isProductFilled = fillProductRecursively(product, day, order);

                // If the filling is successful, set the order as fulfilled
                if (isProductFilled) {
                    isOrderFulfilled = true;
                } else order.setIsFulfilled(false);

            }

            // If the order is fulfilled, add it to the dispatch list and remove it from the orders list
            if (isOrderFulfilled) {
                dispatchList.add(order);
                orders.remove(order);
            }
        }

        // If no orders were fulfilled, return null
        if (dispatchList.isEmpty()) {
            return null;
        }

        return dispatchList;
    }

    private void setProductsToBeUsedInOrder(BasketOrder order, boolean isSimpleDispatchList) {

        if (isSimpleDispatchList) {
            productsToBeUsedInOrder = productsAvailableInTheNetwork;
        } else {
            productsToBeUsedInOrder = getProductsForDispatchListWithRestrictions(order.getClient(), numberOfProducersToConsiderPerClient);
        }

    }

    // Recursive method to fill a product with the equivalent product
    private boolean fillProductRecursively(Product product, int day, BasketOrder order) {
        boolean result = false;
        // Get the equivalent product from the available products
        Product equivalentProduct = getEquivalentProduct(product, day);
        if (equivalentProduct != null) {
            result = true;
            // Fill the product with the equivalent product
            boolean isProducedProductFullyConsumed = product.fillProduct(equivalentProduct);
            // Check if the produced product is fully consumed
            if (isProducedProductFullyConsumed) {
                // Remove the produced product from the available products if it is fully consumed
                networkData.removeAndUpdateProductsSoldOutByProducer(equivalentProduct.getProducer(), equivalentProduct);

                if (product.getQuantity() != 0) {
                    // Check if the same producer still has the same product available
                    Producer producer = equivalentProduct.getProducer();
                    Product sameProductFromSameProducer = getProductXFromSameProducer(producer, product, day);

                    if (sameProductFromSameProducer != null) {
                        // Recursively call the method to try filling the product with the same product from the same producer
                        return fillProductRecursively(product, day, order);
                    } else order.setIsFulfilled(false);
                }
            }
        }
        return result;
    }

    // Searches for an equivalent product in the available products - ProducedProduct
    private Product getEquivalentProduct(Product product, int day) {

        // Gets the first product that is of the same type
        for (Product productAvailable : productsToBeUsedInOrder) {
            if (productAvailable.getName().equals(product.getName())) {
                // Check if the product has already expired
                if (productAvailable.isTimelyAvailable(day)) {
                    // If not expired, return the product
                    return productAvailable;
                }
            }
        }
        return null;
    }

    // Gets the products available for the dispatch list with restrictions
    private List<Product> getProductsForDispatchListWithRestrictions(Client client, int n) {
        // Get the list of N producers that are closest to the client
        List<Producer> eligibleProducers = networkData.getDistributionNetwork().getNProducersClosestToClientHub(client, n);

        // Get the list of products available from the eligible producers
        List<Product> productsAvailable = new ArrayList<>();
        for (Producer producer : eligibleProducers) {
            // Filter the products available in the network by the producers that are eligible
            productsAvailable.addAll(productsAvailableInTheNetwork.stream()
                    .filter(product -> product.getProducer().equals(producer))
                    .toList());
        }

        return productsAvailable;
    }

    // Searches for a product of the same type from the same producer - ProducedProduct
    private Product getProductXFromSameProducer(Producer producer, Product productX, int day) {
        for (Product product : productsAvailableInTheNetwork) {
            if (product.getProducer().equals(producer) && product.equals(productX)) {
                if (product.isTimelyAvailable(day)) {
                    return product;
                }
            }
        }
        return null;
    }

}
