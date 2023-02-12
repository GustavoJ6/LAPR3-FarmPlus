package GUI.Components;

import javafx.beans.property.*;

public class GenerateDispatchListHelper {

    private final SimpleStringProperty product;

    private final SimpleStringProperty qtOrdered;

    private final SimpleStringProperty qtDispatched;

    private final SimpleStringProperty producer;

    public GenerateDispatchListHelper(String product, double qtOrdered, double qtDispatched, String producer) {
        this.product = new SimpleStringProperty(product);
        this.qtOrdered = new SimpleStringProperty(String.valueOf(qtOrdered));
        this.qtDispatched = new SimpleStringProperty(String.valueOf(qtDispatched));
        this.producer = new SimpleStringProperty(producer);
    }

    public GenerateDispatchListHelper(String product, double qtOrdered) {
        this.product = new SimpleStringProperty(product);
        this.qtOrdered = new SimpleStringProperty(String.valueOf(qtOrdered));
        this.qtDispatched = new SimpleStringProperty("N/A");
        this.producer = new SimpleStringProperty("N/A");
    }

    public String getProduct() {
        return product.get();
    }

    public SimpleStringProperty parcelProperty() {
        return product;
    }

    public void setParcel(String parcel) {
        this.product.set(parcel);
    }

    public String getQtOrdered() {
        return qtOrdered.get();
    }

    public SimpleStringProperty qtOrderedProperty() {
        return qtOrdered;
    }

    public void setQtOrdered(String qtOrdered) {
        this.qtOrdered.set(qtOrdered);
    }

    public String getQtDispatched() {
        return qtDispatched.get();
    }

    public SimpleStringProperty qtDispatchedProperty() {
        return qtDispatched;
    }

    public void setQtDispatched(String qtDispatched) {
        this.qtDispatched.set(qtDispatched);
    }

    public String getProducer() {
        return producer.get();
    }

    public SimpleStringProperty producerProperty() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer.set(producer);
    }
}
