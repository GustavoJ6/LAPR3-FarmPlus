package GUI.Components;

import javafx.beans.property.*;

public class ProducerHelper {

    private final String producerId;
    private final SimpleStringProperty totalSatisfied;
    private final SimpleStringProperty partiallySatisfied;
    private final SimpleStringProperty nrClients;
    private final SimpleStringProperty nrProdsSoldOut;
    private final SimpleStringProperty nrSuppliedHubs;

    public ProducerHelper(String producerId, int totalSatisfied, int partiallySatisfied, int nrClients, int nrProdsSoldOut, int nrSuppliedHubs) {
        this.producerId = producerId;
        this.totalSatisfied = new SimpleStringProperty(String.valueOf(totalSatisfied));
        this.partiallySatisfied = new SimpleStringProperty(String.valueOf(partiallySatisfied));
        this.nrClients = new SimpleStringProperty(String.valueOf(nrClients));
        this.nrProdsSoldOut = new SimpleStringProperty(String.valueOf(nrProdsSoldOut));
        this.nrSuppliedHubs = new SimpleStringProperty(String.valueOf(nrSuppliedHubs));
    }

    public String getTotalSatisfied() {
        return totalSatisfied.get();
    }

    public SimpleStringProperty totalSatisfiedProperty() {
        return totalSatisfied;
    }

    public void setTotalSatisfied(String totalSatisfied) {
        this.totalSatisfied.set(totalSatisfied);
    }


    public String getPartiallySatisfied() {
        return partiallySatisfied.get();
    }

    public SimpleStringProperty partiallySatisfiedProperty() {
        return partiallySatisfied;
    }

    public void setPartiallySatisfied(String partiallySatisfied) {
        this.partiallySatisfied.set(partiallySatisfied);
    }


    public String getNrClients() {
        return nrClients.get();
    }

    public SimpleStringProperty nrClientsProperty() {
        return nrClients;
    }

    public void setNrClients(String totalSatisfied) { this.nrClients.set(totalSatisfied); }


    public String getNrProdsSoldOut() { return nrProdsSoldOut.get(); }

    public SimpleStringProperty nrProdsSoldOut() {
        return nrProdsSoldOut;
    }

    public void setNrProdsSoldOut(String totalSatisfied) { this.nrProdsSoldOut.set(totalSatisfied); }


    public String getNrSuppliedHubs() { return nrSuppliedHubs.get(); }

    public SimpleStringProperty nrSuppliedHubs() {
        return nrSuppliedHubs;
    }

    public void setNrSuppliedHubs(String totalSatisfied) { this.nrSuppliedHubs.set(totalSatisfied); }

    @Override
    public String toString() {
        return producerId;
    }
}
