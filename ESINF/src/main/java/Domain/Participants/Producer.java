package Domain.Participants;

/**
 * A Producer in the system. It is a participant and it is the one that produces the products.
 */
public class Producer extends Participant {

    /**
     * Instantiates a new Producer.
     *
     * @param producerId the producer id
     * @param location   the location
     */
    public Producer(String producerId, Location location) {
        super(producerId, location);
    }

    /**
     * Instantiates a new Producer.
     *
     * @param producerId the producer id
     */
    public Producer(String producerId) {
        super(producerId);
    }

    /**
     * Gets producer id.
     *
     * @return the producer id
     */
    public String getProducerId() {
        return super.getParticipantId();
    }

}
