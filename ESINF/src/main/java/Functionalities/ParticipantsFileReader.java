package Functionalities;

import Controller.App;
import Domain.Participants.*;
import Domain.DistributionNetworkData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParticipantsFileReader implements IReaderFromFile {

    // App's distribution network data
    private final DistributionNetworkData distributionNetworkData = App.getInstance().getSystemData();

    @Override
    public boolean readFromFile(String path) {
        distributionNetworkData.clearNetworkData();
        // Instantiate the reader
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));

            String line;
            line = reader.readLine(); // Skip the header

            // Read the file line by line
            while ((line = reader.readLine()) != null) {

                // Split the line by the delimiter
                String[] participantInfo = line.split(",");

                // Check if the line is valid
                if (participantInfo.length != 4) {
                    System.out.println("Invalid line: " + line);
                    return false;
                }

                // Instantiate the coordinates
                Coordinates coordinates = new Coordinates(Double.parseDouble(participantInfo[1]), Double.parseDouble(participantInfo[2]));

                // Instantiate the location
                Location location = new Location(participantInfo[0], coordinates);

                String participantType = participantInfo[3].substring(0,1);

                // Instantiate the participant
                Participant participant = switch (participantType) {
                    case Participant.PARTICULAR -> new Particular(participantInfo[3], location);
                    case Participant.COMPANY -> new Company(participantInfo[3], location);
                    case Participant.PRODUCER -> new Producer(participantInfo[3], location);
                    default -> null;
                };

                // Assure that the participant was instantiated
                if (participant == null) {
                    return false;
                }

                // Add the participant to the system
                if (!distributionNetworkData.getDistributionNetwork().containsParticipant(participant)){
                    distributionNetworkData.getDistributionNetwork().addParticipant(participant);
                }
            }

        } catch (IOException e) {
            return false;
        }
        return true;
    }

}

