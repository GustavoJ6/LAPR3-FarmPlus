package GUI.Components;

import javafx.beans.property.SimpleStringProperty;

public class DefineHubsHelper {

    private final SimpleStringProperty Number;

    private final SimpleStringProperty Hub;

    public DefineHubsHelper(int number, String hub) {
        this.Number = new SimpleStringProperty(String.valueOf(number));
        this.Hub = new SimpleStringProperty(hub);
    }

    public String getNumber() {
        return Number.get();
    }

    public String getHub() {
        return Hub.get();
    }
}
