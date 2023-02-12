package Stores;

import Controller.App;
import Domain.Parcel;
import Functionalities.WateringPlanReader;
import Miscellaneous.WateringParcel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WateringPlanStoreTest {

    @BeforeEach
    void setUp() {
        App.getInstance().getWateringStore().getWateringPlan().clear();

        WateringPlanReader wateringPlanReader = new WateringPlanReader();
        String path = "ESINF/DataToLoad/Test/WateringPlan/wateringPlanTestSmall.txt";
        wateringPlanReader.readFromFile(path);
    }

    @Test
    void getWateringPlan_ReturnTrue() {
        // ARRANGE
        WateringPlanStore wateringPlanStore = App.getInstance().getWateringStore();
        List<WateringParcel> parcelList = new ArrayList<>();
        parcelList.add(new WateringParcel(new Parcel("a"), 10, "t"));
        parcelList.add(new WateringParcel(new Parcel("b"), 20, "p"));

        // ACT
        Map<LocalTime, List<WateringParcel>> actualMap = wateringPlanStore.getWateringPlan();
        Map<LocalTime, List<WateringParcel>> expectedMap = new HashMap<>();
        expectedMap.put(LocalTime.parse("13:52"), parcelList);

        // ASSERT
        assertEquals(expectedMap, actualMap);
    }

    @Test
    void watering_CorrectInformation_ReturnTrue() {
        // DISCLAIMER
        // This test works with current time (Time.now()), so in order to work, the file being used needs to be changed
        // Go to file and subtract 4 minutes from the time of the first line

        // ARRANGE
        WateringPlanStore wateringPlanStore = App.getInstance().getWateringStore();

        // ACT
        Map<String, Integer> actualMap = wateringPlanStore.beingWatered();
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("a", 5);
        expectedMap.put("b", 15);

        // ASSERT
        assertEquals(expectedMap, actualMap);
    }

    @Test
    void watering_NoParcelsBeingWatered_ReturnTrue() {
        // DISCLAIMER
        // This test works with current time (Time.now()), so in order to work, the file being used needs to be changed
        // Go to file and subtract 4 minutes from the time of the first line

        // ARRANGE
        WateringPlanStore wateringPlanStore = App.getInstance().getWateringStore();

        // ACT
        Map<String, Integer> actualMap = wateringPlanStore.beingWatered();
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("a", 5);
        expectedMap.put("b", 15);

        // ASSERT
        assertNotEquals(expectedMap, actualMap);
    }
}