package DTO;

import Domain.Participants.Location;

public class ParticipantDTO {

    private final String participantId;

    private Location location;

    public ParticipantDTO(String participantId, Location location) {
        this.participantId = participantId;
        this.location = location;
    }

    public String getParticipantId() {
        return participantId;
    }

    public Location getLocation() {
        return location;
    }

    public String toString() {
        return participantId;
    }

}
