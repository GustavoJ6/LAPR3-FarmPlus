package Functionalities;

import Controller.App;
import Controller.DefineHubsController;
import Controller.ExpeditionListMinimizedPathController;
import Controller.FindNearestHubController;
import DTO.DijkstraObjectDTO;
import Domain.Participants.Client;
import Domain.Participants.Participant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpeditionListMinimizedPathTest {

    private final FindNearestHubController findNearestHubController = new FindNearestHubController();

    private final DefineHubsController defineHubsController = new DefineHubsController();

    private final ExpeditionListMinimizedPathController expeditionListMinimizedPathController = new ExpeditionListMinimizedPathController();

    private final DispatchListGenerator dispatchListGenerator = new DispatchListGenerator();
    private final ProductsFileReader productsFileReader = new ProductsFileReader();

    @BeforeEach
    void setUp() {
        App.getInstance().getSystemData().getDistributionNetwork().clear();
        App.getInstance().getSystemData().getSimpleDispatchLists().clear();
        App.getInstance().getSystemData().getDistributionNetwork().getHubs().clear();
        App.getInstance().getSystemData().getOrders().clear();
        App.getInstance().getSystemData().getProductsAvailableInTheNetwork().clear();
        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        participantsFileReader.readFromFile("DataToLoad/Test/Participants(clientes-produtores_small).csv");
        RoutesFileReader routesFileReader = new RoutesFileReader();
        routesFileReader.readFromFile("DataToLoad/Test/Routes(distancias_small).csv");
    }

    @Test
    void expeditionListMinimizedPath_ValidDayForExpeditionListMinimizedPath_NumberOhHubs() {
        // ARRANGE
        productsFileReader.readFromFile("DataToLoad/Test/Products(cabazes_small).csv");
        int day = 1;

        // ACT
        dispatchListGenerator.generateSimpleDispatchList(App.getInstance().getSystemData().getOrders(), day);

        expeditionListMinimizedPathController.isDispatchListRequiredValid(day, false);
        // Get the list with all the available starting points
        expeditionListMinimizedPathController.setProducersList(day, false);

        // Baskets dropped per hub (Output Requirement)
        Map<String, Integer> basketsDroppedPerHub = expeditionListMinimizedPathController.getBasketsDroppedPerHub();

        // Generate the expedition list
        Map<List<List<DijkstraObjectDTO<Participant, Double>>>, List<Double>> pathsAndDistances = expeditionListMinimizedPathController.returnMinimizedPath(expeditionListMinimizedPathController.getProducersFromExpeditionList().get(0));

        List<Integer> expectedBasketsDroppedPerHub = new ArrayList<>();
        expectedBasketsDroppedPerHub.add(8);

        List<Integer> actualBasketsDroppedPerHub = new ArrayList<>();
        actualBasketsDroppedPerHub.add(basketsDroppedPerHub.entrySet().iterator().next().getValue());

        // ASSERT
        assertEquals(expectedBasketsDroppedPerHub.get(0), actualBasketsDroppedPerHub.get(0));
    }

    @Test
    void expeditionListMinimizedPath_InvalidStartingPoint_ReturnNull() {
        // ARRANGE
        productsFileReader.readFromFile("DataToLoad/Test/Products(cabazes_small).csv");
        int day = 1;

        // ACT
        dispatchListGenerator.generateSimpleDispatchList(App.getInstance().getSystemData().getOrders(), day);

        expeditionListMinimizedPathController.isDispatchListRequiredValid(day, false);

        // Get the list with all the available starting points
        expeditionListMinimizedPathController.setProducersList(day, false);

        // Baskets dropped per hub (Output Requirement)
        Map<String, Integer> basketsDroppedPerHub = expeditionListMinimizedPathController.getBasketsDroppedPerHub();

        // Generate the expedition list
        Client testClient = new Client("CT");
        Map<List<List<DijkstraObjectDTO<Participant, Double>>>, List<Double>> pathsAndDistances = expeditionListMinimizedPathController.returnMinimizedPath(testClient.getClientId());

        // ASSERT
        assertEquals(null, pathsAndDistances);
    }

    @Test
    void expeditionListMinimizedPath_ValidStartingPointGeneratePath_ReturnValidPathAndTotalDistance() {
        // ARRANGE
        productsFileReader.readFromFile("DataToLoad/Test/Products(cabazes_small).csv");
        int day = 1;

        // ACT
        defineHubsController.getHubs(3);

        findNearestHubController.getNearestHub();

        dispatchListGenerator.generateSimpleDispatchList(App.getInstance().getSystemData().getOrders(), day);

        expeditionListMinimizedPathController.isDispatchListRequiredValid(day, false);
        // Get the list with all the available starting points
        expeditionListMinimizedPathController.setProducersList(day, false);

        // Baskets dropped per hub (Output Requirement)
        List<Integer> expectedHubsBasketsDropped = new ArrayList<>();
        expectedHubsBasketsDropped.add(3);expectedHubsBasketsDropped.add(1);expectedHubsBasketsDropped.add(4);
        Map<String, Integer> basketsDroppedPerHub = expeditionListMinimizedPathController.getBasketsDroppedPerHub();

        List<Integer> actualHubsBasketsDropped = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : basketsDroppedPerHub.entrySet()) {
            actualHubsBasketsDropped.add(entry.getValue());
        }

        // Generate the expedition list
        Map<List<List<DijkstraObjectDTO<Participant, Double>>>, List<Double>> pathsAndDistances = expeditionListMinimizedPathController.returnMinimizedPath(expeditionListMinimizedPathController.getProducersFromExpeditionList().get(0));
        List<Integer> expectedPathSize = new ArrayList<>();
        expectedPathSize.add(2);expectedPathSize.add(3);expectedPathSize.add(2);expectedPathSize.add(2);expectedPathSize.add(2);
        List<Double> expectedDistances = new ArrayList<>();
        expectedDistances.add(67584.0);expectedDistances.add(141412.0);expectedDistances.add(62879.0);expectedDistances.add(90186.0);expectedDistances.add(62655.0);

        List<Integer> actualPathSize = new ArrayList<>();
        List<Double> actualDistances = new ArrayList<>();
        for (Map.Entry<List<List<DijkstraObjectDTO<Participant, Double>>>, List<Double>> entry : pathsAndDistances.entrySet()) {
            for (List<DijkstraObjectDTO<Participant, Double>> path : entry.getKey()) {
                actualPathSize.add(path.size());
            }

            for (Double distance : entry.getValue()) {
                actualDistances.add(distance);
            }

        }

        // ASSERT
        assertEquals(expectedHubsBasketsDropped.get(0), actualHubsBasketsDropped.get(0));
        assertEquals(expectedHubsBasketsDropped.get(1), actualHubsBasketsDropped.get(1));
        assertEquals(expectedHubsBasketsDropped.get(2), actualHubsBasketsDropped.get(2));

        assertEquals(expectedPathSize.get(0), actualPathSize.get(0));
        assertEquals(expectedPathSize.get(1), actualPathSize.get(1));
        assertEquals(expectedPathSize.get(2), actualPathSize.get(2));
        assertEquals(expectedPathSize.get(3), actualPathSize.get(3));
        assertEquals(expectedPathSize.get(4), actualPathSize.get(4));

        assertEquals(expectedDistances.get(0), actualDistances.get(0));
        assertEquals(expectedDistances.get(1), actualDistances.get(1));
        assertEquals(expectedDistances.get(2), actualDistances.get(2));
        assertEquals(expectedDistances.get(3), actualDistances.get(3));
        assertEquals(expectedDistances.get(4), actualDistances.get(4));
    }
}