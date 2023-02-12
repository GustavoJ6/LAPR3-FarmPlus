package GUI.Components;

import javafx.beans.property.*;

public class HubHelper {

    private final String hubId;
    private final SimpleStringProperty nrClients;
    private final SimpleStringProperty nrProducers;

    public HubHelper(String hubId, int nrClients, int nrProducers) {
        this.hubId = hubId;
        this.nrClients = new SimpleStringProperty(String.valueOf(nrClients));
        this.nrProducers = new SimpleStringProperty(String.valueOf(nrProducers));
    }


    public String getNrClients() {
        return nrClients.get();
    }

    public SimpleStringProperty nrClientsProperty() {
        return nrClients;
    }

    public void setNrClients(String nrClients) {
        this.nrClients.set(nrClients);
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
        return hubId;
    }
}
