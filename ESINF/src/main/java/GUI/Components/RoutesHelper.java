package GUI.Components;

import javafx.beans.property.*;

public class RoutesHelper {

    private final SimpleStringProperty vOrigin;
    private final SimpleStringProperty vDestination;
    private final SimpleStringProperty distanceRoute;

    public RoutesHelper(String vOrigin, String vDestination, String distanceRoute) {
        this.vOrigin = new SimpleStringProperty(vOrigin);
        this.vDestination = new SimpleStringProperty(vDestination);
        this.distanceRoute = new SimpleStringProperty(distanceRoute);
    }


    public String getVOrigin() {
        return vOrigin.get();
    }

    public SimpleStringProperty vOrigin() {
        return vOrigin;
    }

    public void setvOrigin(String nrClients) {
        this.vOrigin.set(nrClients);
    }


    public String getVDestination() {
        return vDestination.get();
    }

    public SimpleStringProperty vDestination() {
        return vDestination;
    }

    public void setVDestination(String totalSatisfied) { this.vDestination.set(totalSatisfied); }

    public String getDistanceRoute() {
        return distanceRoute.get();
    }

    public SimpleStringProperty distanceRoute() {
        return distanceRoute;
    }

    public void setDistanceRoute(String totalSatisfied) { this.distanceRoute.set(totalSatisfied); }

}
