package GUI.Components;

import javafx.beans.property.SimpleStringProperty;

public class ExpeditionListMinimizedPathHelper {

    private final SimpleStringProperty Number;

    private final SimpleStringProperty Edge;

    private final SimpleStringProperty Weight;

    public ExpeditionListMinimizedPathHelper(String test, String test1, String test2) {
        this.Number = new SimpleStringProperty(test);
        this.Edge = new SimpleStringProperty(test1);
        this.Weight = new SimpleStringProperty(test2);
    }

    public String getNumber() {
        return Number.get();
    }

    public SimpleStringProperty numberProperty() {
        return Number;
    }

    public void setNumber(String number) {
        this.Number.set(number);
    }

    public String getEdge() {
        return Edge.get();
    }

    public SimpleStringProperty edgeProperty() {
        return Edge;
    }

    public void setEdge(String edge) {
        this.Edge.set(edge);
    }

    public String getWeight() {
        return Weight.get();
    }

    public SimpleStringProperty weightProperty() {
        return Weight;
    }

    public void setWeight(String weight) {
        this.Weight.set(weight);
    }
}
