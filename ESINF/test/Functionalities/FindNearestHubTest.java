package Functionalities;

import Controller.App;
import Controller.DefineHubsController;
import Controller.FindNearestHubController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindNearestHubTest {

    private final FindNearestHubController findNearestHubController = new FindNearestHubController();
    private final DefineHubsController controller = new DefineHubsController();

    @Test
    void findNearestHub_NoHubs_ReturnEmptyLists() {
        // ARRANGE
        App.getInstance().getSystemData().clearFullData();
        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        participantsFileReader.readFromFile("DataToLoad/Test/Participants(clientes-produtores_small).csv");
        RoutesFileReader routesFileReader = new RoutesFileReader();
        routesFileReader.readFromFile("DataToLoad/Small/Routes(distancias_small).csv");

        findNearestHubController.hubExist();
        // ACT
        List<String> expectedList = new ArrayList<>();
        List<String> actualList = new ArrayList<>();
        // ASSERT
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    void findNearestHub_ValidHubs_ReturnClosestHub() {
        // ARRANGE
        App.getInstance().getSystemData().clearFullData();
        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        participantsFileReader.readFromFile("DataToLoad/Test/Participants(clientes-produtores_small).csv");
        RoutesFileReader routesFileReader = new RoutesFileReader();
        routesFileReader.readFromFile("DataToLoad/Test/Routes(distancias_small).csv");

        controller.getHubs(3);
        findNearestHubController.hubExist();
        Map<String, String> stringStringMap = findNearestHubController.getNearestHub();

        // ACT
        List<String> actualList = new ArrayList<>();
        for (Map.Entry<String, String> entry : stringStringMap.entrySet()) actualList.add(entry.getValue());

        List<String> expectedList = new ArrayList<>();
        expectedList.add("E2");expectedList.add("E3");expectedList.add("E4");
        expectedList.add("E2");expectedList.add("E2");expectedList.add("E3");
        expectedList.add("E4");expectedList.add("E4");expectedList.add("E4");
        expectedList.add("E4");expectedList.add("E4");expectedList.add("E2");
        expectedList.add("E2");expectedList.add("E2");

        // ASSERT
        Assertions.assertEquals(expectedList, actualList);
    }
}
