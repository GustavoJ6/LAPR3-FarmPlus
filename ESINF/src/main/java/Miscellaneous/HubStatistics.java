package Miscellaneous;

import Domain.Participants.*;
import Utils.*;

import java.util.*;

public class HubStatistics {

    private String hub;
    private final Set<Client> clientSet = new HashSet<>();;
    private final Set<Producer> producerSet = new HashSet<>();;


    /**
     * Constructor of the class HubStatistics
     */
    public HubStatistics(String hub) {
        this.hub = hub;
    }


    /**
     * Getter of the hub
     *
     * @return client
     */
    public String getHub() {
        return hub;
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
     * Getter of the number of different products that colaborate to fill the order
     *
     * @return nrProducers
     */
    public int getNrProducers() {
        return producerSet.size();
    }

    /**
     * Getter of the sets of clients
     *
     * @return clientSet
     */
    public Set<Client> getClientSet() {
        return clientSet;
    }

    /**
     * Update the set of producers adding a new producer
     */
    public void addProducer(Producer producer) {
        producerSet.add(producer);
    }

    /**
     * Update the set of clients adding a new client
     */
    public void addClient(Client client) {
        clientSet.add(client);
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
        HubStatistics stats = (HubStatistics) o;
        return  Objects.equals(getNrClients(), stats.getNrClients()) &&
                Objects.equals(getNrProducers(), stats.getNrProducers());

    }

    /**
     * Gets a string with an object's information
     *
     * @return String
     */
    @Override
    public String toString() {
        return  "%2s%4d%5d".formatted(hub, clientSet.size(),  producerSet.size());
    }
}
