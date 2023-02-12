package Domain.Participants;

import java.util.Objects;

/**
 * A Participant is any participant in the system. It can be a producer or a client ( Particular or Company )
 */
public class Participant {

    public static final String PARTICULAR = "C" ;
    public static final String COMPANY = "E" ;
    public static final String PRODUCER = "P" ;

    private final String participantId;

    private Location location;

    /**
     * Instantiates a new Participant.
     *
     * @param participantId the participant id
     */
    public Participant(String participantId, Location location) {
        this.participantId = participantId;
        this.location = location;
    }

    public Participant(String participantId) {
        this.participantId = participantId;
    }

    /**
     * Gets participant id.
     *
     * @return the participant id
     */
    public String getParticipantId() {
        return participantId;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(participantId, that.participantId) ;
    }
    @Override
    public int hashCode() {
        return Objects.hash(participantId, location);
    }

    @Override
    public String toString(){
        return participantId;
    }
}