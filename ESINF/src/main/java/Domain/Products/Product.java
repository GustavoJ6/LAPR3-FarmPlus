package Domain.Products;

import Domain.Participants.Producer;
import Utils.Constants;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * The Product.
 */
public class Product {
    private static final long PRODUCT_EXPIRATION_DAYS = 2;
    private final String name;
    private double orderedQuantity;
    private double quantity;
    private LocalDate madeAvailableDate;
    private Producer producer;


    /**
     * Instantiates a new Product ordered by a client.
     *
     * @param name     the name
     * @param quantity the quantity
     */
    public Product(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
        this.orderedQuantity = quantity;
    }

    /**
     * Instantiates a new Product that was made available by a producer.
     *
     * @param name     the name
     * @param quantity the quantity
     * @param day      the day
     * @param producer the producer
     */
    public Product(String name, double quantity, int day, Producer producer) {
        this.name = name;
        this.quantity = quantity;
        this.producer = producer;

        Month month = LocalDateTime.now().getMonth();
        int year = LocalDateTime.now().getYear();

        madeAvailableDate = LocalDate.of(year, month, day);
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the quantity.
     *
     * @return the quantity
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Gets the ordered quantity.
     *
     * @return the ordered quantity
     */
    public double getOrderedQuantity() {
        return orderedQuantity;
    }

    /**
     * Gets dispatched quantity.
     *
     * @return the dispatched quantity
     */
    public double getDispatchedQuantity() {
        return orderedQuantity - quantity;
    }

    /**
     * Dispatch a certain number of products.
     *
     * @param numberDispatched the number dispatched
     */
    public void dispatch(double numberDispatched) {
        if (this.producer == null) {
            throw new IllegalCallerException("It is only possible to dispatch a produced product!");
        }
        this.quantity -= numberDispatched;
    }

    /**
     * Verifies if a product is expired or not.
     * Each product has a 2 days expiration date.
     *
     * @param day the day
     * @return the boolean
     */
    public boolean isTimelyAvailable(int day) {

        LocalDate dateOfExpedition = LocalDate.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), day);

        if (ChronoUnit.DAYS.between(madeAvailableDate, dateOfExpedition) > PRODUCT_EXPIRATION_DAYS) {
            return false;
        }

        return !madeAvailableDate.isAfter(dateOfExpedition);

    }

    /**
     * Gets the producer id.
     *
     * @return the producer id
     */
    public Producer getProducer() {
        return producer;
    }

    /**
     * Fill the product.
     *
     * @param productFromProducer the product
     * @return true if the producer product is fully consumed
     */
    public boolean fillProduct(Product productFromProducer) {

        // Check if the filler is actually a produced product
        if (productFromProducer.getProducer() == null) {
            throw new IllegalCallerException("It is only possible to fill a product with a produced product");
        }

        // Add a producer to the product being filled
        this.producer = productFromProducer.getProducer();

        // Fills the product fully if there is enough quantity and partially if not
        double availableQuantity = productFromProducer.getQuantity();
        double neededQuantity = this.quantity;
        if (availableQuantity > neededQuantity) {
            this.quantity = 0;
            productFromProducer.dispatch(neededQuantity);
        } else {
            this.quantity -= availableQuantity;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(producer, product.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, madeAvailableDate, producer);
    }

    @Override
    public String toString() {
        if (this.producer == null) {
            return Constants.CYAN + "Product: " + name + Constants.RESET + " |" +
                    Constants.RED + " Quantity Ordered: " + orderedQuantity + " |" + Constants.RESET;
        } else {
            return Constants.CYAN + "Product: " + name + Constants.RESET + " |" +
                    Constants.RED + " Quantity Ordered: " + orderedQuantity + " |" +
                    Constants.GREEN + " Quantity dispatched: " + (orderedQuantity - quantity) + " |" +
                    Constants.RESET + " By Producer: " + producer.getProducerId();
        }
    }
}