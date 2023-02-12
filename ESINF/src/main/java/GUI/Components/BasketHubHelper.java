package GUI.Components;

import javafx.beans.property.*;

public class BasketHubHelper {

    private final SimpleStringProperty hub;
    private final SimpleStringProperty nrDroppedBaskets;

    public BasketHubHelper(String hub, int nrDroppedBaskets) {
        this.hub = new SimpleStringProperty(String.valueOf(hub));
        this.nrDroppedBaskets = new SimpleStringProperty(String.valueOf(nrDroppedBaskets));
    }


    public String getHub() {
        return hub.get();
    }

    public SimpleStringProperty hubProperty() {
        return hub;
    }

    public void setHub(String hub) {
        this.hub.set(hub);
    }


    public String getNrDroppedBaskets() {
        return nrDroppedBaskets.get();
    }

    public SimpleStringProperty nrDroppedBasketsProperty() {
        return nrDroppedBaskets;
    }

    public void setNrDroppedBaskets(String totalSatisfied) { this.nrDroppedBaskets.set(totalSatisfied); }

}
