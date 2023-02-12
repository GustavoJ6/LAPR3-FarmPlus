package GUI.Components;

import javafx.beans.property.*;

public class NearestHubHelper {


    private final SimpleStringProperty clientID;

    private final SimpleStringProperty hubID;

    public NearestHubHelper(String test, String test1) {
        this.clientID = new SimpleStringProperty(test);
        this.hubID = new SimpleStringProperty(test1);
    }

    public String getClientID() {
        return clientID.get();
    }

    public SimpleStringProperty clientIDProperty() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID.set(clientID);
    }

    public String getHubID() {
        return hubID.get();
    }

    public SimpleStringProperty hubIDProperty() {
        return hubID;
    }

    public void setHubID(String hubID) {
        this.hubID.set(hubID);
    }
}