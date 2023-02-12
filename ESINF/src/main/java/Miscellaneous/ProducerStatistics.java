package Miscellaneous;

import Domain.Participants.*;
import Utils.Constants;

import java.util.*;

public class ProducerStatistics {

    private Producer producer;
    private int nrBasketOrdersTotallySatisfied;
    private int nrBasketOrdersPartiallySatisfied;
    private final Set<Client> clientSet = new HashSet<>();;
    private int nrProdsSoldOut;
    private final Set<String> hubsSet = new HashSet<>();

    /**
     * Construtor of the class BasketOrderStatistics
     *
     * @param nrBasketOrdersTotallySatisfied - number of basket orders that were totally satisfied
     * @param nrBasketOrdersPartiallySatisfied - number of basket orders that were parcially satisfied
     */
    public ProducerStatistics(Producer producer, int nrBasketOrdersTotallySatisfied, int nrBasketOrdersPartiallySatisfied, int nrProdsSoldOut) {
        this.producer = producer;
        this.nrBasketOrdersTotallySatisfied = nrBasketOrdersTotallySatisfied;
        this.nrBasketOrdersPartiallySatisfied = nrBasketOrdersPartiallySatisfied;
        this.nrProdsSoldOut = nrProdsSoldOut;
    }

    /**
     * Empty Constructor
     */
    public ProducerStatistics(Producer producer) {
        this.producer = producer;
    }


    /**
     * Getter of the client
     *
     * @return client
     */
    public Producer getProducer() {
        return producer;
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
     * @return nrClients
     */
    public int getNrClients() {
        return clientSet.size();
    }

    /**
     * Getter of the number of hubs where the orders which the producer colaborated had gone
     *
     * @return nrHubs
     */
    public int getNrSuppliedHubs() { return hubsSet.size(); }

    public void setNrBasketOrdersTotallySatisfied(int nrBasketOrdersTotallySatisfied) {
        this.nrBasketOrdersTotallySatisfied = nrBasketOrdersTotallySatisfied;
    }

    public void setNrBasketOrdersPartiallySatisfied(int nrBasketOrdersParciallySatisfied) {
        this.nrBasketOrdersPartiallySatisfied = nrBasketOrdersParciallySatisfied;
    }

    public int getNrProdsSoldOut() {
        return nrProdsSoldOut;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public void setNrProdsSoldOut(int nrProdsSoldOut) {
        this.nrProdsSoldOut = nrProdsSoldOut;
    }

    /**
     * Getter of the set of Clients
     *
     * @return clientSet
     */
    public Set<Client> getClientSet() {
        return clientSet;
    }

    /**
     * Getter of the set of Hubs
     *
     * @return String
     */
    public Set<String> getHubsSet() { return hubsSet; }

    /**
     * Add a client to the set of clients, no duplicates
     * Atualizes the number of clients
     *
     * @param client - client to add
     */
    public void addClient(Client client) {
        clientSet.add(client);
    }

    /**
     * Add a hub to the set of hubs, no duplicates
     * Atualizes the number of hubs
     *
     * @param hub - hub to add
     */
    public void addHub(String hub) {
        hubsSet.add(hub);
    }

    /**
     * Equals method
     *
     * @param o - Object to compare
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProducerStatistics stats = (ProducerStatistics) o;
        return  Objects.equals(nrBasketOrdersTotallySatisfied, stats.nrBasketOrdersTotallySatisfied) &&
                Objects.equals(nrBasketOrdersPartiallySatisfied, stats.nrBasketOrdersPartiallySatisfied) &&
                Objects.equals(getNrClients(), stats.getNrClients()) &&
                Objects.equals(nrProdsSoldOut, stats.nrProdsSoldOut) &&
                Objects.equals(getNrSuppliedHubs(), stats.getNrSuppliedHubs());

    }

    /**
     * Gets a string with an object's information
     *
     * @return String
     */
    @Override
    public String toString() {
        return  "%2s%5d%5d%5d%5d%5d".formatted(producer.getProducerId(), nrBasketOrdersTotallySatisfied,  nrBasketOrdersPartiallySatisfied, getNrClients(), nrProdsSoldOut, getNrSuppliedHubs());
    }

}
