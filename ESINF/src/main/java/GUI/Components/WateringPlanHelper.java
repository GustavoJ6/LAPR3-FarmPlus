package GUI.Components;

import javafx.beans.property.*;

public class WateringPlanHelper {

    private final SimpleStringProperty parcel;

    private final SimpleStringProperty timeLeft;

    public WateringPlanHelper(String date, String totalVaccinated) {
        this.parcel = new SimpleStringProperty(date);
        this.timeLeft = new SimpleStringProperty(totalVaccinated);
    }

    public String getParcel() {
        return parcel.get();
    }

    public SimpleStringProperty parcelProperty() {
        return parcel;
    }

    public void setParcel(String parcel) {
        this.parcel.set(parcel);
    }

    public String getTimeLeft() {
        return timeLeft.get();
    }

    public SimpleStringProperty timeLeftProperty() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft.set(timeLeft);
    }
}
