package Domain;

import Controller.App;
import Domain.Participants.Participant;
import Domain.Participants.Producer;
import Domain.Products.BasketOrder;
import Domain.Products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Distribution network data.
 */
public class DistributionNetworkData {

    // Distribution Network - Graph with the participants of the distribution network and the routes between them
    private final DistributionNetwork distributionNetwork = new DistributionNetwork();

    // List of the products that are available in the distribution network (given by the producers)
    private final List<Product> productsAvailableInTheNetwork = new ArrayList<>();

    // List of orders by the clients
    private final List<BasketOrder> orders = new ArrayList<>();

    // List of simple dispatch lists
    private final List<List<BasketOrder>> simpleDispatchLists = new ArrayList<>();

    // List of dispatch lists with restrictions
    private final List<List<BasketOrder>> dispatchListsWithRestrictions = new ArrayList<>();

    // List of the products completely sold out in the distribution network
    private final Map<Producer, List<Product>> productsSoldOutByProducer = new HashMap<>();


    /**
     * Remove a products from the list of products available in the distribution network if it is sold out
     * Add the product to the list of products sold out by the producer
     *
     * @param product  - Product to be removed
     * @param producer - Producer of the product
     */
    public void removeAndUpdateProductsSoldOutByProducer(Producer producer, Product product) {
        productsAvailableInTheNetwork.remove(product);
        List<Product> productsSoldOut = productsSoldOutByProducer.get(producer);
        if (productsSoldOut == null)
            productsSoldOut = new ArrayList<>();

        productsSoldOut.add(product);
        productsSoldOutByProducer.put(producer, productsSoldOut);
    }

    /**
     * Getter of the map containing the products sold out by the producers
     *
     * @return - number of products sold out
     */
    public int getNrProdsSoldOut(Producer producer) {
        return productsSoldOutByProducer.get(producer).size();
    }

    /**
     * Gets the distribution network.
     *
     * @return the distribution network
     */
    public DistributionNetwork getDistributionNetwork() {
        return distributionNetwork;
    }

    /**
     * Gets the products available in the network.
     *
     * @return the products available in the network
     */
    public List<Product> getProductsAvailableInTheNetwork() {
        return productsAvailableInTheNetwork;
    }

    /**
     * Gets the orders.
     *
     * @return the orders
     */
    public List<BasketOrder> getOrders() {
        return orders;
    }

    /**
     * Gets the simple dispatch lists.
     *
     * @return the simple dispatch lists
     */
    public List<List<BasketOrder>> getSimpleDispatchLists() {
        return simpleDispatchLists;
    }

    /**
     * Gets the dispatch lists with restrictions.
     *
     * @return the dispatch lists with restrictions
     */
    public List<List<BasketOrder>> getDispatchListsWithRestrictions() {
        return dispatchListsWithRestrictions;
    }

    /**
     * Checks if there are hubs defined.
     *
     * @return the boolean
     */
    public boolean areThereNoHubsDefined() {
        return distributionNetwork.getHubs().isEmpty();
    }

    /**
     * Hard Clears all the data from the system.
     */
    public void clearFullData() {
        distributionNetwork.clear();
        App.getInstance().loadedData.put(1, false);
        clearProductsRelatedData();
    }

    public void clearNetworkData() {
        distributionNetwork.clear();
        productsAvailableInTheNetwork.clear();
        orders.clear();
        simpleDispatchLists.clear();
        dispatchListsWithRestrictions.clear();
        productsSoldOutByProducer.clear();
    }

    public void clearProductsRelatedData() {
        productsAvailableInTheNetwork.clear();
        orders.clear();
        simpleDispatchLists.clear();
        dispatchListsWithRestrictions.clear();
        productsSoldOutByProducer.clear();
        App.getInstance().loadedData.put(2, false);
    }

    /**
     * Checks if there are orders for day.
     *
     * @param day the day
     * @return the boolean
     */
    public boolean areThereOrdersForDay(int day) {
        for (BasketOrder order : orders) {
            if (order.getDay() == day) {
                if (!order.isFulfilled()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean areThereNProducersInTheNetwork(int n) {
        return distributionNetwork.getListOfParticipantsWithFilter(Participant.PRODUCER).size() >= n;
    }
}