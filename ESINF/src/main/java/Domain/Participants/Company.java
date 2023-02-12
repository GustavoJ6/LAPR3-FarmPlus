package Domain.Participants;

/**
 * A Company in the system. It is a Client and can also be considered a Hub
 */
public class Company extends Client {

    private boolean isHub;

    /**
     * Instantiates a new Company.
     *
     * @param clientId the client id
     * @param location the location
     */
    public Company(String clientId, Location location) {
        super(clientId, location);
        this.isHub = false; // By default, a company is not a hub
    }

    /**
     * Is hub boolean.
     *
     * @return true if the company is a Hub, false otherwise
     */
    public boolean isHub() {
        return isHub;
    }

    /**
     * Mark as hub.
     */
    public void markAsHub() {
        this.isHub = true;
    }

}