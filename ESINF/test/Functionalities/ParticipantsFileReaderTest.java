package Functionalities;

import Controller.App;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantsFileReaderTest {

    @BeforeEach
    void setUp() {
        App.getInstance().getSystemData().clearFullData();
    }

    @Test
    void readFromFile_FileWithCorrectInformation_ReturnsTrue() {

        // ARRANGE
        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        String path = "DataToLoad/Test/Participants(clientes-produtores_small).csv";

        // ACT
        boolean result = participantsFileReader.readFromFile(path);

        // ASSERT
        assertTrue(result);
    }

    @Test
    void readFromFile_FileDoesNotExist_ReturnsFalse() {

        // ARRANGE
        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        String path = "DataToLoad/Test/clientes-produtores_small_incorrect.csv";

        // ACT
        boolean result = participantsFileReader.readFromFile(path);

        // ASSERT
        assertFalse(result);
    }

    @Test
    void readFromFile_FileWithInvalidLines_ReturnsFalse() {

        // ARRANGE
        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        String path = "DataToLoad/Test/participantsInvalidLines.csv";

        // ACT
        boolean result = participantsFileReader.readFromFile(path);

        // ASSERT
        assertFalse(result);
    }

    @Test
    void readFromFile_FileWithInvalidParticipant_ReturnsFalse() {

        // ARRANGE
        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        String path = "DataToLoad/Test/participantsInvalidParticipant.csv";

        // ACT
        boolean result = participantsFileReader.readFromFile(path);

        // ASSERT
        assertFalse(result);
    }

    @Test
    void readFromFile_ValidFileWith17Participants_DistributionGraphHas17Participants() {

        // ARRANGE
        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        String path  = "DataToLoad/Test/Participants(clientes-produtores_small).csv";

        // ACT
        participantsFileReader.readFromFile(path);
        int numberOfParticipants = App.getInstance().getSystemData().getDistributionNetwork().getNumParticipants();

        int expectedNumberOfParticipants = 17;

        // ASSERT
        assertEquals(expectedNumberOfParticipants, numberOfParticipants);
    }

}