package Controller;

import Domain.DistributionNetwork;
import Domain.Graph.Edge;
import Domain.Graph.Graph;
import Domain.Graph.KruskalObject;
import Domain.Graph.map.MapGraph;
import Domain.Participants.Participant;
import Miscellaneous.AuxiliaryAlgorithms;
import Utils.Constants;

import java.util.*;

public class ConnectionNetworkController {
    private final DistributionNetwork distributionNetwork = App.getInstance().getSystemData().getDistributionNetwork();

    /**
     * Fill with vertex boolean.
     *
     * @param minimumSpanningTree      the minimumSpanningTree
     * @param participantConnectionMap the participant connection map
     * @param participantParentMap     the participant parent map
     * @return the boolean
     */
    public boolean fillWithVertex(Graph<Participant, Double> minimumSpanningTree, Map<Participant, List<Participant>> participantConnectionMap, Map<Participant, List<Participant>> participantParentMap) {
        // Check if the graph is connected
        if (distributionNetwork.getDistributionNetwork().isConnected()) {

            // Get the vertex of the graph
            List<Participant> participantList = distributionNetwork.getDistributionNetwork().vertices();

            // Fill the necessary maps with the vertex
            for (Participant participant : participantList) {
                minimumSpanningTree.addVertex(participant);

                List<Participant> vertexListConnectionsMap = new ArrayList<>();
                vertexListConnectionsMap.add(participant);
                participantConnectionMap.put(participant, vertexListConnectionsMap);

                List<Participant> vertexListParentMap = new ArrayList<>();
                vertexListParentMap.add(participant);
                participantParentMap.put(participant, vertexListParentMap);
            }
            return true;
        }
        return false;
    }

    /**
     * Fill list with kruskal object.
     *
     * @param kruskalObjectList the kruskal object list
     */
    public void fillListWithKruskalObject(List<KruskalObject<Participant, Double>> kruskalObjectList) {
        List<Edge<Participant, Double>> mainGraphEdges = distributionNetwork.getDistributionNetwork().edges().stream().toList();

        // Fill list with KruskalObject
        for (Edge<Participant, Double> edge : mainGraphEdges)
            if (!kruskalObjectList.contains(new KruskalObject<>(edge.getVDest(), edge.getWeight(), edge.getVOrig())))
                kruskalObjectList.add(new KruskalObject<>(edge.getVOrig(), edge.getWeight(), edge.getVDest()));
    }

    /**
     * Run kruskal algorithm.
     */
    public void runKruskalAlgorithm() {
        Graph<Participant, Double> minimumSpanningTree = new MapGraph<>(false);

        Map<Participant, List<Participant>> participantConnectionMap = new HashMap<>();
        Map<Participant, List<Participant>> participantParentMap = new HashMap<>();

        // Check if the graph is connected
        boolean isConnected = fillWithVertex(minimumSpanningTree, participantConnectionMap, participantParentMap);

        if (isConnected) {

            // If it is connected then we can add all the edges to the minimum spanning tree
            List<KruskalObject<Participant, Double>> kruskalObjectList = new ArrayList<>();
            fillListWithKruskalObject(kruskalObjectList);

            List<KruskalObject<Participant, Double>> listToPrint = new ArrayList<>();

            // Call the kruskal algorithm
            AuxiliaryAlgorithms.kruskalAlgorithm(minimumSpanningTree, kruskalObjectList, participantConnectionMap, participantParentMap, listToPrint);

            print(listToPrint);
        }

        else
            System.out.println("The graph is not connected, please insert the necessary vertices and edges.");
    }
    
    private void print(List<KruskalObject<Participant, Double>> kruskalObjectList) {
        // Variables to calculate the total cost and the total number of connections
        int iteration = 1;
        double total = 0;
        boolean flag = true;

        // Print the minimum spanning tree title
        System.out.printf("-----------------------\n|Minimum Spanning Tree|\n-----------------------%n%n");

        //For loop to print the edges and the total cost
        for (KruskalObject<Participant, Double> participantDoubleKruskalObject : kruskalObjectList) {
            if (flag) System.out.printf(iteration + "  - " + "(" + Constants.BLUE + participantDoubleKruskalObject.getvOrig() + Constants.RESET + ", " + Constants.RED + participantDoubleKruskalObject.getvDest() + Constants.RESET + ") : " + Constants.PURPLE + participantDoubleKruskalObject.getWeight() + "m\n" + Constants.RESET);
            else System.out.printf(iteration + "  - " + "(" + Constants.BLUE + participantDoubleKruskalObject.getvOrig() + Constants.RESET + ", " + Constants.RED + participantDoubleKruskalObject.getvDest() + Constants.RESET + ") : " + Constants.CYAN + participantDoubleKruskalObject.getWeight() + "m\n" + Constants.RESET);
            total += participantDoubleKruskalObject.getWeight();
            flag = !flag;
            iteration++;
        }

        // Print the total cost
        System.out.printf("\n" + Constants.GREEN + "Minimum Spanning Tree " + Constants.RESET + "Cost: " + Constants.PURPLE + "%.1fm\n\n" + Constants.RESET, total);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Run kruskal algorithm.
     */
    public List<KruskalObject<Participant, Double>> runKruskalAlgorithmGUI() {
        Graph<Participant, Double> minimumSpanningTree = new MapGraph<>(false);

        Map<Participant, List<Participant>> participantConnectionMap = new HashMap<>();
        Map<Participant, List<Participant>> participantParentMap = new HashMap<>();

        // Check if the graph is connected
        boolean isConnected = fillWithVertex(minimumSpanningTree, participantConnectionMap, participantParentMap);

        if (isConnected) {

            // If it is connected then we can add all the edges to the minimum spanning tree
            List<KruskalObject<Participant, Double>> kruskalObjectList = new ArrayList<>();
            fillListWithKruskalObject(kruskalObjectList);

            List<KruskalObject<Participant, Double>> listToPrint = new ArrayList<>();

            // Call the kruskal algorithm
            AuxiliaryAlgorithms.kruskalAlgorithm(minimumSpanningTree, kruskalObjectList, participantConnectionMap, participantParentMap, listToPrint);
            return listToPrint;
        }
        return null;
    }
}