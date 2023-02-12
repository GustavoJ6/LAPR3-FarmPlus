package Domain.Participants;

/**
 * A Particular client in the system. It is considered as a normal client, like a customer.
 */
public class Particular extends Client {

    /**
     * Instantiates a new Particular.
     *
     * @param clientId the client id
     * @param location the location
     */
    public Particular(String clientId, Location location) {
        super(clientId, location);
    }

}