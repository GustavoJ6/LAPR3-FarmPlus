package Controller;

import DTO.DijkstraObjectDTO;
import Domain.DistributionNetwork;
import Domain.Graph.Algorithms;
import Domain.Graph.DijkstraObject;
import Domain.Participants.Participant;
import Mapper.DijkstraObjectMapper;
import Miscellaneous.AuxiliaryAlgorithms;

import java.util.*;

public class MostDistantPairOfVerticesController {

    private final DistributionNetwork distributionNetwork = App.getInstance().getSystemData().getDistributionNetwork();

    private Map<Participant, Boolean> visited;
    private Map<Participant, DijkstraObject<Participant, Double>> dijkstraObjectMap;

    /**
     * Instantiates a new Most distant pair of vertices controller.
     */
    public MostDistantPairOfVerticesController() {
        visited = new HashMap<>();
        dijkstraObjectMap = new HashMap<>();
    }

    /**
     * Checks if the graph is connected.
     *
     * @return the boolean
     */
    public boolean isConnected() {
        return distributionNetwork.getDistributionNetwork().isConnected();
    }

    /**
     * Gets the longest path.
     *
     * @return the longest path
     */
    public DijkstraObjectDTO<Participant, Double> getLongestPath() {

        List<DijkstraObject<Participant, Double>> longestParticipants = new ArrayList<>();
        for (Participant p : distributionNetwork.getDistributionNetwork().vertices()) {
            dijkstraSetUp(p);
            AuxiliaryAlgorithms.shortestPathDijkstra(distributionNetwork.getDistributionNetwork(), p, visited, dijkstraObjectMap);

            longestParticipants.add(AuxiliaryAlgorithms.getVertexWithMostConnections(p, dijkstraObjectMap));
        }

        // Iterator over the longestParticipants list to find the longest path
        Iterator<DijkstraObject<Participant, Double>> iterator = longestParticipants.iterator();
        DijkstraObject<Participant, Double> longest = iterator.next();
        while (iterator.hasNext()) {
            DijkstraObject<Participant, Double> current = iterator.next();
            if (current.getDistance() > longest.getDistance())
                longest = current;
        }

        return DijkstraObjectMapper.toDTO(longest);
    }



    private void dijkstraSetUp(Participant vOrig) {
        // This method will be run twice, so it is necessary to reset the maps
        visited.clear();
        dijkstraObjectMap.clear();

        // Map containing the vertices and a boolean to check whether they have been visited
        visited = new HashMap<>();

        /* This map will keep track of the connections with the least cost, meaning all the path from the source to any destination
           It's a map because this way it's easier to get the corresponding object giving the vertex */
        dijkstraObjectMap = new HashMap<>();
        DijkstraObject<Participant, Double> first = new DijkstraObject<>(vOrig, 0.0, null);

        dijkstraObjectMap.put(vOrig, first);

        for (Participant vert : distributionNetwork.getDistributionNetwork().vertices()) {
            if (!vert.equals(vOrig))
                dijkstraObjectMap.put(vert, new DijkstraObject<>(vert, null, null));
            visited.put(vert, false);
        }
    }
}
