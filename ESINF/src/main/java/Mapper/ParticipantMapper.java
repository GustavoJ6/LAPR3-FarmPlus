package Mapper;

import DTO.ParticipantDTO;
import Domain.Participants.Participant;

public class ParticipantMapper {

    public static ParticipantDTO toDTO(Participant participant) {
        if (participant == null) {
            return null;
        }

        return new ParticipantDTO(participant.getParticipantId(), participant.getLocation());
    }

    public static Participant toDomain(ParticipantDTO participantDTO) {
        if (participantDTO == null) {
            return null;
        }

        return new Participant(participantDTO.getParticipantId(), participantDTO.getLocation());
    }

}
