package Domain.Graph;


import Controller.App;
import Domain.Participants.Participant;
import Functionalities.ParticipantsFileReader;
import Functionalities.RoutesFileReader;
import Miscellaneous.AuxiliaryAlgorithms;
import org.junit.jupiter.api.*;

import java.util.*;

class AlgorithmsTest {

    private static Graph<Participant, Double> graph;

    @BeforeEach
    void setUp() {
        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        participantsFileReader.readFromFile("DataToLoad/Test/clientes-produtores_test.csv");
        RoutesFileReader routesFileReader = new RoutesFileReader();
        routesFileReader.readFromFile("DataToLoad/Test/distancias_test.csv");
        graph = App.getInstance().getSystemData().getDistributionNetwork().getDistributionNetwork();
    }

    @Test
    void shortestPath_C1ToP2_ReturnTrue() {
        // Arrange
        Participant vOrig = graph.vertices().get(0);
        Participant vDest = graph.vertices().get(6);
        double zero = 0.0;

        // Act
        List<DijkstraObject<Participant, Double>> expectedList = AuxiliaryAlgorithms.shortestPath(graph, vOrig, vDest, zero);

        List<DijkstraObject<Participant, Double>> actualList = new ArrayList<>();
        actualList.add(new DijkstraObject<>(vOrig, zero, null));
        actualList.add(new DijkstraObject<>(graph.vertices().get(5), 2.0, vOrig));
        actualList.add(new DijkstraObject<>(graph.vertices().get(6), 4.0, graph.vertices().get(5)));

        // Assert
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    void shortestPath_C5ToP2_ReturnTrue() {
        // Arrange
        Participant vOrig = graph.vertices().get(4);
        Participant vDest = graph.vertices().get(6);
        double zero = 0.0;

        // Act
        List<DijkstraObject<Participant, Double>> expectedList = AuxiliaryAlgorithms.shortestPath(graph, vOrig, vDest, zero);

        List<DijkstraObject<Participant, Double>> actualList = new ArrayList<>();
        actualList.add(new DijkstraObject<>(vOrig, zero, null));
        actualList.add(new DijkstraObject<>(graph.vertices().get(1), 2.0, vOrig));
        actualList.add(new DijkstraObject<>(graph.vertices().get(6), 3.0, graph.vertices().get(1)));

        // Assert
        Assertions.assertEquals(expectedList, actualList);
    }


    @Test
    void shortestPath_C5ToP1_ReturnTrue() {
        // Arrange
        Participant vOrig = graph.vertices().get(4);
        Participant vDest = graph.vertices().get(5);
        double zero = 0.0;

        // Act
        List<DijkstraObject<Participant, Double>> expectedList = AuxiliaryAlgorithms.shortestPath(graph, vOrig, vDest, zero);

        List<DijkstraObject<Participant, Double>> actualList = new ArrayList<>();
        actualList.add(new DijkstraObject<>(vOrig, zero, null));
        actualList.add(new DijkstraObject<>(graph.vertices().get(3), 1.0, vOrig));
        actualList.add(new DijkstraObject<>(graph.vertices().get(0), 2.0, graph.vertices().get(3)));
        actualList.add(new DijkstraObject<>(graph.vertices().get(5), 4.0, graph.vertices().get(0)));

        // Assert
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    void shortestPath_C2ToP2_ReturnTrue() {
        // Arrange
        Participant vOrig = graph.vertices().get(1);
        Participant vDest = graph.vertices().get(6);
        double zero = 0.0;

        // Act
        List<DijkstraObject<Participant, Double>> expectedList = AuxiliaryAlgorithms.shortestPath(graph, vOrig, vDest, zero);

        List<DijkstraObject<Participant, Double>> actualList = new ArrayList<>();
        actualList.add(new DijkstraObject<>(vOrig, zero, null));
        actualList.add(new DijkstraObject<>(graph.vertices().get(6), 1.0, vOrig));

        // Assert
        Assertions.assertEquals(expectedList, actualList);
    }

}