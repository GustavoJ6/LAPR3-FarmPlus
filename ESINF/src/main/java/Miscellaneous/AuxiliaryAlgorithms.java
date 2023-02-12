package Miscellaneous;

import Domain.Graph.DijkstraObject;
import Domain.Graph.Edge;
import Domain.Graph.Graph;
import Domain.Graph.KruskalObject;

import java.util.*;

public class AuxiliaryAlgorithms {

    /**
     * Returns the vertex with the least distance
     *
     * @param dijkstraObjectMap Map with the vertices and their respective DijkstraObject (object the gives the distance and predecessor)
     * @param visited           Map with the vertices and their respective visited status
     * @return the vertex with the least distance
     */
    public static <V, E extends Number> V getVertexWithLeastDistance(Map<V, DijkstraObject<V, E>> dijkstraObjectMap, Map<V, Boolean> visited) {
        V vertex = null;
        Double minDistance = null;

        for (V vert : dijkstraObjectMap.keySet()) {
            if (dijkstraObjectMap.get(vert).getDistance() != null && !visited.get(vert)) {
                if (minDistance == null || Double.compare(minDistance, dijkstraObjectMap.get(vert).getDistance().doubleValue()) > 0) {
                    minDistance = dijkstraObjectMap.get(vert).getDistance().doubleValue();
                    vertex = vert;
                }
            }
        }

        return vertex;
    }

    // Given a Map with DijkstraObjects, the longest path starting at a source
    public static <V, E extends Number> V getVertexWithMostWeight(Map<V, DijkstraObject<V, E>> dijkstraObjectMap) {
        V vertex = null;
        // iterate over a map with entry
        double maxWeight = 0;
        for (Map.Entry<V, DijkstraObject<V, E>> entry : dijkstraObjectMap.entrySet()) {
            if (Double.compare(entry.getValue().getDistance().doubleValue(), maxWeight) > 0) {
                maxWeight = entry.getValue().getDistance().doubleValue();
                vertex = entry.getKey();
            }
        }

        return vertex;
    }

    /**
     * Given a Map<V, DijkstraObject<V, E>>, this method returns the longest path starting at a source
     *
     * @param dijkstraObjectMap Map with the vertices and their respective DijkstraObject (object the gives the distance and predecessor)
     * @param vOrig  Source vertex
     * @return the longest path starting at a source
     */
    public static <V, E extends Number> DijkstraObject<V, E> getVertexWithMostConnections(V vOrig, Map<V, DijkstraObject<V, E>> dijkstraObjectMap) {
        V predecessor = null;
        double maxConnections = 0;
        double connections;

        // iterator over the map with entry
        for (Map.Entry<V, DijkstraObject<V, E>> entry : dijkstraObjectMap.entrySet()) {
            connections = 0;
            V vertex = entry.getValue().getPredecessor();
            V currentVertex =  entry.getKey();

            while (vertex != null) {
                vertex = dijkstraObjectMap.get(vertex).getPredecessor();
                connections++;
            }

            if (connections > maxConnections) {
                maxConnections = connections;
                predecessor = currentVertex;
            }

        }

        return new DijkstraObject<>(vOrig, (E) new Double(maxConnections), predecessor);
    }

    /**
     * Builds the path from the source to the destination
     *
     * @param path      List that will contain the path
     * @param dijkstraObjectMap Map with the vertices and their respective DijkstraObject (object the gives the distance and predecessor)
     * @param vOrig             Source vertex
     * @param vDest             Destination vertex
     */
    public static <V, E extends Number> void buildPath(List<DijkstraObject<V, E>> path, Map<V, DijkstraObject<V,E>> dijkstraObjectMap, V vOrig, V vDest) {

        DijkstraObject<V, E> current = dijkstraObjectMap.get(vDest);
        path.add(current);
        while (!current.getKey().equals(vOrig)) {
            current = dijkstraObjectMap.get(current.getPredecessor());
            if (current == null)
                return;
            path.add(current);
        }

        Collections.reverse(path);
    }

    /**
     * Descending sort edges.
     *
     * @param <V>               the type parameter
     * @param <E>               the type parameter
     * @param kruskalObjectList the kruskal object list
     */
    public static <V, E extends Number> void ascendingSortEdges(List<KruskalObject<V, E>> kruskalObjectList) {
        // Sort the edges in ascending order
        kruskalObjectList.sort((o1, o2) -> {
            if ((Double) o1.getWeight() - (Double) o2.getWeight() > 0) return 1;
            if ((Double) o1.getWeight() - (Double) o2.getWeight() < 0) return -1;
            return 0;
        });
    }

    /**
     * Kruskal algorithm boolean.
     *
     * @param <V>               the type parameter
     * @param <E>               the type parameter
     * @param mst               the mst
     * @param kruskalObjectList the kruskal object list
     * @param vConnectionMap    the v connection map
     * @param vParentMap        the v parent map
     */
    public static <V, E extends Number> void kruskalAlgorithm(Graph<V, E> mst, List<KruskalObject<V, E>> kruskalObjectList, Map<V, List<V>> vConnectionMap, Map<V, List<V>> vParentMap, List<KruskalObject<V, E>> listToPrint) {

        // While there are edges to be added according to the number of vertices
        int vertexMinusOneCounter = 0;

        // Order all the edges in ascending order
        ascendingSortEdges(kruskalObjectList);

        // For each edge, check if it creates a cycle
        for (KruskalObject<V, E> kruskalObject : kruskalObjectList) {
            V originParent = vParentMap.get(kruskalObject.getvOrig()).get(vParentMap.get(kruskalObject.getvOrig()).size() - 1);
            V destinationParent = vParentMap.get(kruskalObject.getvDest()).get(vParentMap.get(kruskalObject.getvDest()).size() - 1);

            // In case the edge doesn't create a cycle, add it to the MST
            if (originParent != destinationParent) {
                if (vertexMinusOneCounter == mst.numVertices() - 1) break;
                vertexMinusOneCounter++;
                // Add the edge to the MST
                vConnectionMap.get(originParent).addAll(vConnectionMap.get(destinationParent));
                mst.addEdge(kruskalObject.getvOrig(), kruskalObject.getvDest(), kruskalObject.getWeight());
                listToPrint.add(kruskalObject);

                for (int position = 0; position < vConnectionMap.get(destinationParent).size(); position++)
                    // Update the parent of the vertices connected to the destination vertex
                    vParentMap.get(vConnectionMap.get(destinationParent).get(position)).add(originParent);
            }
        }
    }

    /**
     * Computes shortest-path distance from a source vertex to all reachable
     * vertices of a graph g with non-negative edge weights
     * This implementation uses Dijkstra's algorithm
     *
     * @param graph        Graph instance
     * @param vOrig    Vertex that will be the source of the path
     */
    public static <V, E extends Number> void shortestPathDijkstra(Graph<V, E> graph, V vOrig, Map<V, Boolean> visited, Map<V, DijkstraObject<V, E>> dijkstraObjectMap) {

        if (!graph.validVertex(vOrig))
            return;

        int vertCounter = 0;
        while (vertCounter < graph.numVertices()) {

            if (vOrig == null)
                return;

            for (Edge<V, E> edge: graph.outgoingEdges(vOrig)) {

                if (!visited.get(edge.getVDest())) {
                    Double sum = dijkstraObjectMap.get(vOrig).getDistance().doubleValue() + edge.getWeight().doubleValue();
                    E current = dijkstraObjectMap.get(edge.getVDest()).getDistance();

                    if (current == null || Double.compare(sum, current.doubleValue()) < 0) {
                        dijkstraObjectMap.get(edge.getVDest()).setDistance((E) sum);
                        dijkstraObjectMap.get(edge.getVDest()).setPredecessor(vOrig); } }}

            visited.put(vOrig, true);
            vertCounter++;
            vOrig = getVertexWithLeastDistance(dijkstraObjectMap, visited);
        }
    }

    /** Shortest-path between two vertices
     *
     * @param graph graph
     * @param vOrig origin vertex
     * @param vDest destination vertex
     * @param zero neutral element of the sum in elements of type E
     * @return List - the shortest path from vOrig to vDest
     */
    public static <V, E extends Number> List<DijkstraObject<V, E>> shortestPath(Graph<V, E> graph, V vOrig, V vDest, E zero) {

        if (!graph.validVertex(vOrig) || !graph.validVertex(vDest))
            return null;


        // Prepare the data structure
        List<DijkstraObject<V, E>> dijkstraPath = new ArrayList<>();

        // Map containing the vertices and a boolean to check whether they have been visited
        Map<V, Boolean> visited = new HashMap<>();

        /* This map will keep track of the connections with the least cost, meaning all the path from the source to any destination
           It's a map because this way it's easier to get the corresponding object giving the vertex */
        Map<V, DijkstraObject<V, E>> dijkstraObjectMap = new HashMap<>();
        DijkstraObject<V, E> first = new DijkstraObject<>(vOrig, zero, null);
        DijkstraObject<V, E> last = new DijkstraObject<>(vDest, null, null);

        if (vOrig.equals(vDest)) {
            dijkstraObjectMap.put(vOrig, first);
        } else {
            dijkstraObjectMap.put(vOrig, first);
            dijkstraObjectMap.put(vDest, last);
        }

        // When starting the algorithm, all the distance are considered infinite and all the vertices are unvisited
        for (V vert :  graph.vertices()) {
            if (!vert.equals(vOrig) && !vert.equals(vDest))
                dijkstraObjectMap.put(vert, new DijkstraObject<>(vert, null, null));
            visited.put(vert, false);
        }


        shortestPathDijkstra(graph, vOrig, visited, dijkstraObjectMap);

        buildPath(dijkstraPath, dijkstraObjectMap, vOrig, vDest);

        return dijkstraPath;
    }
}
