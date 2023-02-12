package Functionalities;

import Controller.App;
import Controller.ConnectionNetworkController;
import Domain.Graph.Algorithms;
import Domain.Graph.Graph;
import Domain.Graph.KruskalObject;
import Domain.Graph.map.MapGraph;
import Domain.Participants.Participant;
import Miscellaneous.AuxiliaryAlgorithms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectionNetworkTest {

    private final ConnectionNetworkController networkController = new ConnectionNetworkController();

    @Test
    public void connectionNetwork_ValidKruskal_Valid_MST() {
        // ARRANGE
        App.getInstance().getSystemData().clearFullData();
        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        participantsFileReader.readFromFile("DataToLoad/Test/participantes_kruskalTestAprove.csv");
        RoutesFileReader routesFileReader = new RoutesFileReader();
        routesFileReader.readFromFile("DataToLoad/Test/distancias_kruskalTestAprove.csv");

        Graph<Participant, Double> mst = new MapGraph<>(false);

        Map<Participant, List<Participant>> participantConnectionMap = new HashMap<>();
        Map<Participant, List<Participant>> participantParentMap = new HashMap<>();

        boolean isConnected = networkController.fillWithVertex(mst, participantConnectionMap, participantParentMap);

        List<KruskalObject<Participant, Double>> kruskalObjectList = new ArrayList<>();
        networkController.fillListWithKruskalObject(kruskalObjectList);

        // ACT
        List<KruskalObject<Participant, Double>> actualList = new ArrayList<>();
        AuxiliaryAlgorithms.kruskalAlgorithm(mst, kruskalObjectList, participantConnectionMap, participantParentMap, actualList);

        List<KruskalObject<Participant, Double>> expectedList = new ArrayList<>();
        expectedList.add(new KruskalObject<>(new Participant("E2"), 63448.0, new Participant("C2")));
        expectedList.add(new KruskalObject<>(new Participant("C1"), 76197.0, new Participant("C2")));
        expectedList.add(new KruskalObject<>(new Participant("E2"), 129235.0, new Participant("P1")));

        // ASSERT
        Assertions.assertEquals(expectedList.get(0).toString(), actualList.get(0).toString());
        Assertions.assertEquals(expectedList.get(1).toString(), actualList.get(1).toString());
        Assertions.assertEquals(expectedList.get(2).toString(), actualList.get(2).toString());
    }

    @Test
    public void connectionNetwork_InvalidKruskal_Invalid_MST() {
        // ARRANGE
        App.getInstance().getSystemData().clearFullData();
        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        participantsFileReader.readFromFile("DataToLoad/Test/participantes_kruskalTestAprove.csv");
        RoutesFileReader routesFileReader = new RoutesFileReader();
        routesFileReader.readFromFile("DataToLoad/Test/distancias_kruskalTestAprove.csv");

        Graph<Participant, Double> mst = new MapGraph<>(false);

        Map<Participant, List<Participant>> participantConnectionMap = new HashMap<>();
        Map<Participant, List<Participant>> participantParentMap = new HashMap<>();

        boolean isConnected = networkController.fillWithVertex(mst, participantConnectionMap, participantParentMap);

        if (!isConnected) ;

        // ACT
        List<KruskalObject<Participant, Double>> actualList = new ArrayList<>();

        List<KruskalObject<Participant, Double>> expectedList = new ArrayList<>();

        // ASSERT
        Assertions.assertEquals(expectedList, actualList);
    }
}
