package Miscellaneous;

import Utils.Constants;

import java.util.*;

public class BasketOrderStatistics {

    private int nrProdsTotallySatisfied;
    private int nrProdsPartiallySatisfied;
    private int nrProdsNotSatisfied;
    private double percentageOfSatisfaction;
    private int nrProducers;

    /**
     * Construtor of the class BasketOrderStatistics
     *
     * @param nrProdsTotallySatisfied - number of products that were totally satisfied
     * @param nrProdsPartiallySatisfied - number of products that were parcially satisfied
     * @param nrProdsNotSatisfied - number of products that were not satisfied
     * @param nrProducers - number of different products that colaborate to fill the order
     */
    public BasketOrderStatistics(int nrProdsTotallySatisfied, int nrProdsPartiallySatisfied, int nrProdsNotSatisfied, int nrProducers) {
        this.nrProdsTotallySatisfied = nrProdsTotallySatisfied;
        this.nrProdsPartiallySatisfied = nrProdsPartiallySatisfied;
        this.nrProdsNotSatisfied = nrProdsNotSatisfied;
        calculatePercentageOfSatisfaction();
        this.nrProducers = nrProducers;
    }

    /**
     * Empty Constructor
     */
    public BasketOrderStatistics() {
    }

    public void calculatePercentageOfSatisfaction() {
        percentageOfSatisfaction = Math.round((double) nrProdsTotallySatisfied / (nrProdsTotallySatisfied + nrProdsPartiallySatisfied + nrProdsNotSatisfied) * 100);
    }

    /**
     * Getter of the number that were totally satisfied
     *
     * @return nrProdsTotallySatisfied
     */
    public int getNrProdsTotallySatisfied() {
        return nrProdsTotallySatisfied;
    }

    /**
     * Getter of the number that were parcially satisfied
     *
     * @return nrProdsParciallySatisfied
     */
    public int getNrProdsPartiallySatisfied() {
        return nrProdsPartiallySatisfied;
    }

    /**
     * Getter of the number that were not satisfied
     *
     * @return nrProdsNotSatisfied
     */
    public int getNrProdsNotSatisfied() {
        return nrProdsNotSatisfied;
    }

    /**
     * Getter of the percentange of statisfaction
     *
     * @return percentageOfSatisfaction
     */
    public double getPercentageOfSatisfaction() {
        return percentageOfSatisfaction;
    }

    /**
     * Getter of the number of different products that colaborate to fill the order
     *
     * @return nrProducers
     */
    public int getNrProducers() {
        return nrProducers;
    }

    public void setNrProdsTotallySatisfied(int nrProdsTotallySatisfied) {
        this.nrProdsTotallySatisfied = nrProdsTotallySatisfied;
    }

    public void setNrProdsPartiallySatisfied(int nrProdsParciallySatisfied) {
        this.nrProdsPartiallySatisfied = nrProdsParciallySatisfied;
    }

    public void setNrProdsNotSatisfied(int nrProdsNotSatisfied) {
        this.nrProdsNotSatisfied = nrProdsNotSatisfied;
    }

    public void setNrProducers(int nrProducers) {
        this.nrProducers = nrProducers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketOrderStatistics stats = (BasketOrderStatistics) o;
        return  Objects.equals(nrProdsTotallySatisfied, stats.nrProdsTotallySatisfied) &&
                Objects.equals(nrProdsPartiallySatisfied, stats.nrProdsPartiallySatisfied) &&
                Objects.equals(nrProdsNotSatisfied, stats.nrProdsNotSatisfied) &&
                Objects.equals(percentageOfSatisfaction, stats.percentageOfSatisfaction) &&
                Objects.equals(nrProducers, stats.nrProducers);
    }

    /**
     * Gets a string with an object's information
     *
     * @return String
     */
    @Override
    public String toString() {
        return  "%s%5d%5d%7.1f%4d".formatted(nrProdsTotallySatisfied,  nrProdsPartiallySatisfied, nrProdsNotSatisfied, percentageOfSatisfaction, nrProducers);
    }
}
