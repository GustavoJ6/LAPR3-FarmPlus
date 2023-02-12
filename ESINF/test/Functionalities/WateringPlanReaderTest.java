package Functionalities;

import Controller.App;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WateringPlanReaderTest {

    @BeforeEach
    void setUp() {
        App.getInstance().getWateringStore().getWateringPlan().clear();
    }

    /*
     * Test that reads a file with correct information and returns true
     */
    @Test
    void readFromFile_FileWithCorrectInformation_ReturnsTrue() {

        // ARRANGE
        WateringPlanReader wateringPlanReader = new WateringPlanReader();
        String path = "DataToLoad/Test/WateringPlan/wateringPlanTest.txt";

        // ACT
        boolean result = wateringPlanReader.readFromFile(path);

        // ASSERT
        assertTrue(result);
    }

    /*
     * Test with a file that does not exist
     */
    @Test
    void readFromFile_FileDoesNotExist_ReturnsFalse() {

        // ARRANGE
        WateringPlanReader wateringPlanReader = new WateringPlanReader();
        String path = "DataToLoad/Test/WateringPlan/wateringPlanThatDoesNotExists.txt";

        // ACT
        boolean result = wateringPlanReader.readFromFile(path);

        // ASSERT
        assertFalse(result);
    }


    /*
     * Test with a file that contains hours with letters
     */
    @Test
    void readFromFile_FileWithInvalidHour01_ReturnsFalse() {

        // ARRANGE
        WateringPlanReader wateringPlanReader = new WateringPlanReader();
        String path = "DataToLoad/Test/WateringPlan/wateringPlanInvalidHour01.txt";

        // ACT
        boolean result = wateringPlanReader.readFromFile(path);

        // ASSERT
        assertFalse(result);
    }

    /*
     * Test with file that contains hours that does not exist, e.g. 25:00
     */
    @Test
    void readFromFile_FileWithInvalidHour02_ReturnsFalse() {

        // ARRANGE
        WateringPlanReader wateringPlanReader = new WateringPlanReader();
        String path = "DataToLoad/Test/WateringPlan/wateringPlanInvalidHour01.txt";

        // ACT
        boolean result = wateringPlanReader.readFromFile(path);

        // ASSERT
        assertFalse(result);
    }

    /*
     * Test with file that contains parcels lines that does not make sense
     */
    @Test
    void readFromFile_FileWithInvalidParcelLine_ReturnFalse() {

        // ARRANGE
        WateringPlanReader wateringPlanReader = new WateringPlanReader();
        String path  = "DataToLoad/Test/WateringPlan/wateringPlanInvalidParcelLine.csv";

        // ACT
        boolean result = wateringPlanReader.readFromFile(path);

        // ASSERT
        assertFalse(result);
    }

}