package Domain;

import Controller.App;
import Functionalities.ParticipantsFileReader;
import Functionalities.RoutesFileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistributionNetworkTest {

    @BeforeEach
    void setUp() {
        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        participantsFileReader.readFromFile("DataToLoad/Test/findHubsTestParticipants.csv");
        RoutesFileReader routesFileReader = new RoutesFileReader();
        routesFileReader.readFromFile("DataToLoad/Test/findHubsTestDistancias.csv");
    }

    @Test
    void determineHubs_ValidNumberOfHubs_ReturnsCorrectCompanies() {
        // ARRANGE
        DistributionNetwork distributionNetwork = App.getInstance().getSystemData().getDistributionNetwork();
        int numberOfHubs = 1;

        // ACT
        List<String> result = distributionNetwork.determineHubs(numberOfHubs);
        List<String> expected = List.of("E1");

        // ASSERT
        assertEquals(expected, result);
    }

    @Test
    void determineHubs_InvalidNumberOfHubs_ReturnsEmptyList() {
        // ARRANGE
        DistributionNetwork distributionNetwork = App.getInstance().getSystemData().getDistributionNetwork();
        int numberOfHubs = 0;

        // ACT
        List<String> result = distributionNetwork.determineHubs(numberOfHubs);
        List<String> expected = List.of();

        // ASSERT
        assertEquals(expected, result);
    }





}