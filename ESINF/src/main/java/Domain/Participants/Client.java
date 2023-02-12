package Domain.Participants;

/**
 * A Client in the system. It can be a Particular or a Company
 */
public class Client extends Participant {

    private String nearestHubId;

    /**
     * Instantiates a new Client.
     *
     * @param clientId the client id
     */
    public Client(String clientId, Location location) {
        super(clientId, location);
    }

    public Client (String clientId){super(clientId);}

    /**
     * Gets the client id.
     *
     * @return the client id
     */
    public String getClientId() {
        return super.getParticipantId();
    }

    /**
     * Gets client's location.
     *
     * @return the client's location
     */
    public Location getClientLocation() {
        return super.getLocation();
    }

    public void setNearestHub(String nearestHubId) {
        this.nearestHubId = nearestHubId;
    }

    public String getNearestHubId() {
        return nearestHubId;
    }

}