package Functionalities;

import Controller.App;
import Domain.Participants.Participant;
import Domain.DistributionNetworkData;

import java.io.BufferedReader;
import java.io.FileReader;

public class RoutesFileReader implements IReaderFromFile{

    // App's distribution network data
    private final DistributionNetworkData distributionNetworkData = App.getInstance().getSystemData();
    @Override
    public boolean readFromFile(String path) {
        // Instantiate the reader
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));

            String line;
            line = reader.readLine(); // Skip the header

            // Read the file line by line
            while ((line = reader.readLine()) != null) {

                // Split the line by the delimiter
                String[] lineData = line.split(",");

                // Check if the line is valid
                if (lineData.length != 3) {
                    System.out.println("Invalid line: " + line);
                    return false;
                }

                // Get the data from the line
                String origin = lineData[0];
                String destination = lineData[1];
                double distance = Double.parseDouble(lineData[2]);

                // Get the participants related to both locations
                Participant originParticipant = distributionNetworkData.getDistributionNetwork().participantByLocationId(origin);
                Participant destinationParticipant = distributionNetworkData.getDistributionNetwork().participantByLocationId(destination);

                // Assure that both participants exist
                if (originParticipant == null || destinationParticipant == null) {
                    System.out.println("You can't add a route between two participants, if one don't exist in the network");
                    return false;
                }

                // Add the route between the participants to the distribution network
                distributionNetworkData.getDistributionNetwork().addRoute(originParticipant, destinationParticipant, distance);
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
