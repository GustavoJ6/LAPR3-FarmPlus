package Miscellaneous;

import Domain.Participants.Client;
import Utils.Constants;

import java.util.*;

public class ClientStatistics {

    private Client client;
    private int nrBasketOrdersTotallySatisfied;
    private int nrBasketOrdersPartiallySatisfied;
    private int nrProducers;

    /**
     * Construtor of the class BasketOrderStatistics
     *
     * @param nrBasketOrdersTotallySatisfied - number of basket orders that were totally satisfied
     * @param nrBasketOrdersPartiallySatisfied - number of basket orders that were parcially satisfied
     * @param nrProducers - number of different products that colaborate to fill the order
     */
    public ClientStatistics(int nrBasketOrdersTotallySatisfied, int nrBasketOrdersPartiallySatisfied, int nrProducers) {
        this.nrBasketOrdersTotallySatisfied = nrBasketOrdersTotallySatisfied;
        this.nrBasketOrdersPartiallySatisfied = nrBasketOrdersPartiallySatisfied;
        this.nrProducers = nrProducers;
    }

    /**
     * Empty Constructor
     */
    public ClientStatistics(Client client) {
        this.client = client;
    }


    /**
     * Getter of the client
     *
     * @return client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Getter of the number that were totally satisfied
     *
     * @return nrProdsTotallySatisfied
     */
    public int getNrBasketOrdersTotallySatisfied() {
        return nrBasketOrdersTotallySatisfied;
    }

    /**
     * Getter of the number that were parcially satisfied
     *
     * @return nrProdsParciallySatisfied
     */
    public int getNrBasketOrdersPartiallySatisfied() {
        return nrBasketOrdersPartiallySatisfied;
    }

    /**
     * Getter of the number of different products that colaborate to fill the order
     *
     * @return nrProducers
     */
    public int getNrProducers() {
        return nrProducers;
    }

    public void setNrBasketOrdersTotallySatisfied(int nrBasketOrdersTotallySatisfied) {
        this.nrBasketOrdersTotallySatisfied = nrBasketOrdersTotallySatisfied;
    }

    public void setNrBasketOrdersPartiallySatisfied(int nrBasketOrdersParciallySatisfied) {
        this.nrBasketOrdersPartiallySatisfied = nrBasketOrdersParciallySatisfied;
    }

    public void setNrProducers(int nrProducers) {
        this.nrProducers = nrProducers;
    }

    /**
     * Equals method
     *
     * @return nrBasketOrdersTotallySatisfied
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientStatistics stats = (ClientStatistics) o;
        return Objects.equals(nrBasketOrdersTotallySatisfied, stats.nrBasketOrdersTotallySatisfied) &&
                Objects.equals(nrBasketOrdersPartiallySatisfied, stats.nrBasketOrdersPartiallySatisfied) &&
                Objects.equals(nrProducers, stats.nrProducers);
    }

    /**
     * Gets a string with an object's information
     *
     * @return String
     */
    @Override
    public String toString() {
        return  "%2s%4d%5d%5d".formatted(client.getClientId(), nrBasketOrdersTotallySatisfied, nrBasketOrdersPartiallySatisfied, nrProducers);
    }
}
