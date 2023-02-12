package Domain.Products;

import Domain.Participants.Client;

import java.util.List;

/**
 * A Basket order.
 * Used to represent the order of a certain client
 */
public class BasketOrder {

    private final List<Product> products;
    private final Client client;
    private final int day;
    private boolean isFulfilled;

    /**
     * Instantiates a new Basket order.
     *
     * @param products the products
     * @param client   the client
     */
    public BasketOrder(List<Product> products, Client client, int day) {
        this.products = products;
        this.client = client;
        this.day = day;
        isFulfilled = true;
    }

    /**
     * Gets all the products of the order.
     *
     * @return the products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Gets the client associated with the order.
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Checks if the order is fully fulfilled.
     *
     * @return true if all the products of the order are fulfilled
     */
    public boolean isFullySatisfied() {
        for (Product product : products) {
            if (product == null)
                continue;
            else if (product.getQuantity() > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the order is at least partially fulfilled.
     *
     * @return true if all the products of the order are fulfilled
     */
    public boolean isFulfilled() {
        for (Product product : products) {
            if (product.getProducer() != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Client: " + client + " ; " + "Order size: " + products.size();
    }

    public int getDay() {
        return day;
    }

    public void setIsFulfilled(boolean isFulfilled) {
        this.isFulfilled = isFulfilled;
    }
}