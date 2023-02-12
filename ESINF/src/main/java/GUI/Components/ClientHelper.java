package GUI.Components;

import javafx.beans.property.*;

public class ClientHelper {

    private final String clientId;
    private final SimpleStringProperty totalSatisfied;
    private final SimpleStringProperty partiallySatisfied;
    private final SimpleStringProperty nrProducers;

    public ClientHelper(String clientId, int totalSatisfied, int partiallySatisfied, int nrProducers) {
        this.clientId = clientId;
        this.totalSatisfied = new SimpleStringProperty(String.valueOf(totalSatisfied));
        this.partiallySatisfied = new SimpleStringProperty(String.valueOf(partiallySatisfied));
        this.nrProducers = new SimpleStringProperty(String.valueOf(nrProducers));
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


    public String getNrProducers() {
        return nrProducers.get();
    }

    public SimpleStringProperty nrProducersProperty() {
        return nrProducers;
    }

    public void setNrProducers(String totalSatisfied) { this.nrProducers.set(totalSatisfied); }

    @Override
    public String toString() {
        return clientId;
    }
}
