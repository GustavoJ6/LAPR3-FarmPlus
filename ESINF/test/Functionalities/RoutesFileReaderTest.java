package Functionalities;


import Controller.App;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoutesFileReaderTest {

    @BeforeEach
    void setUp() {
        App.getInstance().getSystemData().clearFullData();
        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        participantsFileReader.readFromFile("DataToLoad/Test/Participants(clientes-produtores_small).csv");
    }

    @Test
    void readFromFile_FileWithCorrectInformation_ReturnsTrue() {

        // ARRANGE
        RoutesFileReader routesFileReader = new RoutesFileReader();
        String path = "DataToLoad/Test/Routes(distancias_small).csv";

        // ACT
        boolean result = routesFileReader.readFromFile(path);

        // ASSERT
        assertTrue(result);
    }

    @Test
    void readFromFile_FileDoesNotExist_ReturnsFalse() {

        // ARRANGE
        RoutesFileReader routesFileReader = new RoutesFileReader();
        String path = "DataToLoad/Test/distancias_small_not_exists.csv";

        // ACT
        boolean result = routesFileReader.readFromFile(path);

        // ASSERT
        assertFalse(result);
    }

    @Test
    void readFromFile_FileWithInvalidLines_ReturnsFalse() {

        // ARRANGE
        RoutesFileReader routesFileReader = new RoutesFileReader();
        String path = "DataToLoad/Test/routesInvalidLines.csv";

        // ACT
        boolean result = routesFileReader.readFromFile(path);

        // ASSERT
        assertFalse(result);
    }


    @Test
    void readFromFile_FileWithNonExistingParticipants_ReturnsFalse() {

        // ARRANGE
        RoutesFileReader routesFileReader = new RoutesFileReader();
        String path = "DataToLoad/Test/routesForNonExistingParticipants.csv";

        // ACT
        boolean result = routesFileReader.readFromFile(path);

        // ASSERT
        assertFalse(result);
    }
}