package Functionalities;

import Controller.*;
import Domain.*;
import Domain.Participants.*;
import Domain.Products.BasketOrder;
import Domain.Products.Product;
import Miscellaneous.*;

import java.util.*;

public class CalculateStatistics {

    private List<BasketOrder> dispatchedList;

    private final List<BasketOrderStatistics> basketOrderStatistics;
    private final Map<Client, ClientStatistics> mapClientStats;
    private final Map<Producer, ProducerStatistics> mapProducerStats;
    private final Map<String, HubStatistics> mapHubStats;
    private final DistributionNetworkData data;

    /**
     * Construtor of the Class CalculateStatistics
     *
     * @param dispatchedList - Choosen Dispacthed List
     */
    public CalculateStatistics(List<BasketOrder> dispatchedList) {
        this.dispatchedList = dispatchedList;
        basketOrderStatistics = new ArrayList<>();
        mapClientStats = new HashMap<>();
        mapProducerStats = new HashMap<>();
        mapHubStats = new HashMap<>();
        data = App.getInstance().getSystemData();
    }

    /**
     * Methods that calculates all the statistics, iterating over the Dispatched List
     * It does not return anything, but it fills the lists containing the actual statistics
     */
    public void calculateStatistics() {

        // Iterate over all the basket orders
        for (BasketOrder order : dispatchedList) {
            // If an order is null, skit it
            if (order == null)
                continue;

            boolean isTotallySatisfied = order.isFullySatisfied();

            // BasketOrder
            BasketOrderStatistics basketOrderStats = new BasketOrderStatistics();

            // Client
            ClientStatistics clientStats = mapClientStats.get(order.getClient());
            // Determine whether the client is already on the map, if not put him there
            if (clientStats == null) {
                clientStats = new ClientStatistics(order.getClient());
                mapClientStats.put(order.getClient(), clientStats);
            }

            // Producer
            ProducerStatistics producerStats;
            /* This list exists for 2 reasons:
            • Number of Producers for both basketOrders and Clients
            • Count the number of basketOrders totally/partially satisfied for each producer
             */
            List<String> producersId = new ArrayList<>();

            // Hub
            HubStatistics hubStats = mapHubStats.get(order.getClient().getNearestHubId());
            // Determine whether the hub is already on the map, if not put it there
            if (hubStats == null) {
                hubStats = new HubStatistics(order.getClient().getNearestHubId());
                mapHubStats.put(order.getClient().getNearestHubId(), hubStats);
            }

            // Iterate over all the products
            for (Product product : order.getProducts()) {
                // If a product is null, skip it
                if (product == null)
                    continue;

                Producer currentProducer = product.getProducer();

                // Determine whether the producer is already on the map, if not put him there - Producer
                producerStats = mapProducerStats.get(currentProducer);
                if (producerStats == null) {
                    producerStats = new ProducerStatistics(currentProducer);
                    // If the product is not satisfied at all, the producer will be null, don't want to have the null producer on the map
                    if (currentProducer != null) {
                        // As the number of products sold out has already been calculated, we can set it here
                        producerStats.setNrProdsSoldOut(data.getNrProdsSoldOut(currentProducer));
                        mapProducerStats.put(currentProducer, producerStats);
                    }

                }

                // Checking if a producer has already appear on the current basket order, and it is not null
                if (currentProducer != null && !producerInBasketOrder(producersId,currentProducer)) {

                    if (isTotallySatisfied)
                        producerStats.setNrBasketOrdersTotallySatisfied(producerStats.getNrBasketOrdersTotallySatisfied() + 1);
                    else
                        producerStats.setNrBasketOrdersPartiallySatisfied(producerStats.getNrBasketOrdersPartiallySatisfied() + 1);

                    producerStats.addClient(order.getClient());
                    producerStats.addHub(hubStats.getHub());
                }

                // Basket Order - check is a product was totally/partially/not satisfied
                isProductTotallySatisfied(basketOrderStats, product);

                // Hub
                if (currentProducer != null)
                    hubStats.addProducer(currentProducer);

            }

            // Basket Order
            // Adding the number of producers that collaborated on the order
            basketOrderStats.setNrProducers(producersId.size());
            // Calculating the percentage of satisfaction
            basketOrderStats.calculatePercentageOfSatisfaction();
            basketOrderStatistics.add(basketOrderStats);


            // Client
            // Check if the order was totally/partially satisfied
            isTotallySatisfied(isTotallySatisfied, clientStats);
            clientStats.setNrProducers(producersId.size());

            // Hub
            hubStats.addClient(order.getClient());
        }
    }

    private boolean producerInBasketOrder(List<String> producersId, Producer producer) {

        for (String id : producersId)
            if (id.equals(producer.getProducerId()))
                return true;

        producersId.add(producer.getProducerId());
        return false;
    }

    /**
     * Method that checks if the product was totally/partially/not satisfied
     *
     * @param basketOrderStats - Basket Order Statistics Oject
     * @param product          - Current product
     */
    private void isProductTotallySatisfied(BasketOrderStatistics basketOrderStats, Product product) {
        // If the producer is null, the product was not satisfied
        if (product.getProducer() == null)
            basketOrderStats.setNrProdsNotSatisfied(basketOrderStats.getNrProdsNotSatisfied() + 1);

        else if (product.getQuantity() == 0)
            basketOrderStats.setNrProdsTotallySatisfied(basketOrderStats.getNrProdsTotallySatisfied() + 1);

        else if (product.getQuantity() > 0)
            basketOrderStats.setNrProdsPartiallySatisfied(basketOrderStats.getNrProdsPartiallySatisfied() + 1);

    }


    /**
     * Method that checks if the order was totally/partially/not satisfied
     *
     * @param isTotallySatisfied - Boolean that determines if the order was totally satisfied
     * @param clientStats        - Client Statistics Object
     */
    private void isTotallySatisfied(boolean isTotallySatisfied, ClientStatistics clientStats) {

        if (isTotallySatisfied)
            clientStats.setNrBasketOrdersTotallySatisfied(clientStats.getNrBasketOrdersTotallySatisfied() + 1);
        else
            clientStats.setNrBasketOrdersPartiallySatisfied(clientStats.getNrBasketOrdersPartiallySatisfied() + 1);

    }


    /**
     * Getter for the statistics of the Basket Order
     *
     * @return basketOrderStatistics
     */
    public List<BasketOrderStatistics> getBasketOrderStatistics() {
        return basketOrderStatistics;
    }

    /**
     * Getter for the statistics of the Client
     *
     * @return Values of mapClientStats
     */
    public Collection<ClientStatistics> getClientStatistics() {
        return mapClientStats.values();
    }

    /**
     * Getter for the statistics of the Producer
     *
     * @return Values of mapProducerStats
     */
    public Collection<ProducerStatistics> getProducerStatistics() {
        return mapProducerStats.values();
    }

    /**
     * Getter for the statistics of the Hub
     *
     * @return hubStatistics
     */
    public Collection<HubStatistics> getMapHubStats() {
        return mapHubStats.values();
    }
}
