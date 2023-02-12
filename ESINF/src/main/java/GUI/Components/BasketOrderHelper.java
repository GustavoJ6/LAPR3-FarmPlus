package GUI.Components;

import javafx.beans.property.*;

public class BasketOrderHelper {

    private final String id;
    private final SimpleStringProperty totalSatisfied;
    private final SimpleStringProperty partiallySatisfied;
    private final SimpleStringProperty notSatisfied;
    private final SimpleStringProperty percentageSatisfaction;
    private final SimpleStringProperty nrProducers;

    public BasketOrderHelper(int id, int totalSatisfied, int partiallySatisfied, int notSatisfied, double percentageSatisfaction, int nrProducers) {
        this.id = String.valueOf(id);
        this.totalSatisfied = new SimpleStringProperty(String.valueOf(totalSatisfied));
        this.partiallySatisfied = new SimpleStringProperty(String.valueOf(partiallySatisfied));
        this.notSatisfied = new SimpleStringProperty(String.valueOf(notSatisfied));
        this.percentageSatisfaction = new SimpleStringProperty(String.valueOf(percentageSatisfaction));
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


    public String getNotSatisfied() {
        return notSatisfied.get();
    }

    public SimpleStringProperty notSatisfiedProperty() {
        return notSatisfied;
    }

    public void setNotSatisfied(String totalSatisfied) {
        this.notSatisfied.set(totalSatisfied);
    }


    public String getPercentageSatisfaction() {
        return percentageSatisfaction.get();
    }

    public SimpleStringProperty percentageSatisfactionProperty() {
        return percentageSatisfaction;
    }

    public void setPercentageSatisfaction(String totalSatisfied) {
        this.percentageSatisfaction.set(totalSatisfied);
    }


    public String getNrProducers() {
        return nrProducers.get();
    }

    public SimpleStringProperty nrProducersProperty() {
        return nrProducers;
    }

    public void setNrProducers(String totalSatisfied) { this.nrProducers.set(totalSatisfied); }

    @Override
    public String toString() { return id; }
}
