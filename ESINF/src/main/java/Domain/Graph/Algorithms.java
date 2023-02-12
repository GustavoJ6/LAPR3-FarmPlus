package Domain.Graph;


import Domain.Graph.map.MapGraph;

import java.util.*;
import java.util.function.BinaryOperator;

/**
 * The type Algorithms.
 *
 * @author DEI -ISEP
 */
public class Algorithms {


    /**
     * Performs breadth-first search of a Graph starting in a vertex
     *
     * @param <V>   the type parameter
     * @param <E>   the type parameter
     * @param graph Graph instance
     * @param vert  vertex that will be the source of the search
     * @return a LinkedList with the vertices of breadth-first search
     */
    public static <V, E> LinkedList<V> BreadthFirstSearch(Graph<V, E> graph, V vert) {

        // Check if the vert is valid (i.e., if it belongs to the graph)
        if (!graph.validVertex(vert))
            return null;

        // Create the queues and the list of visited vertices
        LinkedList<V> qSearch = new LinkedList<>();
        LinkedList<V> qHelper = new LinkedList<>();
        boolean[] visited = new boolean[graph.numVertices()];

        // Add the source vertex to the queues
        qSearch.add(vert);
        qHelper.add(vert);

        // Mark the source vertex as visited
        int vertKey = graph.key(vert);
        visited[vertKey] = true;

        // While the search queue is not empty
        while (!qHelper.isEmpty()) {

            // Get the first vertex in the queue and remove it from the helper queue
            vert = qHelper.remove();

            // For each vertex adjacent to vert
            for (V vertAdj : graph.adjVertices(vert)) {

                // Get the key of the adjacent vertex
                vertKey = graph.key(vertAdj);

                // If the adjacent vertex has not been visited
                if (!visited[vertKey]) {

                    // Add the adjacent vertex to the search queue and to the helper queue
                    qSearch.add(vertAdj);
                    qHelper.add(vertAdj);
                    visited[vertKey] = true;
                }
            }
        }
        return qSearch;
    }

    /**
     * Performs depth-first search starting in a vertex
     *
     * @param graph       Graph instance
     * @param vertOrigin   vertex of graph g that will be the source of the search
     * @param visited set of previously visited vertices
     * @param qSearch    return LinkedList with vertices of depth-first search
     */
    private static <V, E> void DepthFirstSearch(Graph<V, E> graph, V vertOrigin, boolean[] visited, LinkedList<V> qSearch) {

        // Get the key of the vertex
        int vKey = graph.key(vertOrigin);

        // If the vertex has been visited return the call
        if (visited[vKey]) return;

        // Add the vertex to the search queue
        qSearch.add(vertOrigin);
        visited[vKey] = true;

        for (V vAdj : graph.adjVertices(vertOrigin)) {
            DepthFirstSearch(graph, vAdj, visited, qSearch);
        }
    }

    /**
     * Performs depth-first search starting in a vertex
     *
     * @param graph    Graph instance
     * @param vert vertex of graph g that will be the source of the search
     * @return a LinkedList with the vertices of depth-first search
     */
    public static <V, E> LinkedList<V> DepthFirstSearch(Graph<V, E> graph, V vert) {

        // Check if the vert is valid (i.e., if it belongs to the graph)
        if (!graph.validVertex(vert))
            return null;

        // Create the queue and the list of visited vertices
        LinkedList<V> qSearch = new LinkedList<>();
        boolean[] visited = new boolean[graph.numVertices()];

        // Calls the recursive method to get all the vertices of the depth-first search
        DepthFirstSearch(graph, vert, visited, qSearch);

        return qSearch;
    }

    /** Returns all paths from vOrig to vDest
     *
     * @param graph       Graph instance
     * @param vOrig   Vertex that will be the source of the path
     * @param vDest   Vertex that will be the end of the path
     * @param visited set of discovered vertices
     * @param path    stack with vertices of the current path (the path is in reverse order)
     * @param paths   ArrayList with all the paths (in correct order)
     */
    private static <V, E> void allPaths(Graph<V, E> graph, V vOrig, V vDest, boolean[] visited,
                                        LinkedList<V> path, ArrayList<LinkedList<V>> paths) {

        int vKey = graph.key(vOrig);
        if (visited[vKey]) return;

        if (vOrig.equals(vDest)) {          //save clone of reverse path
            LinkedList<V> pathclone = new LinkedList<>(path);
            pathclone.addFirst(vDest);
            Collections.reverse(pathclone);
            paths.add(new LinkedList<>(pathclone));
            return;
        }

        path.push(vOrig);
        visited[vKey] = true;

        for (V vAdj : graph.adjVertices(vOrig)) {
            allPaths(graph, vAdj, vDest, visited, path, paths);
        }

        path.pop();
        visited[vKey] = false;
    }

    /** Returns all paths from vOrig to vDest
     *
     * @param graph     Graph instance
     * @param vOrig information of the Vertex origin
     * @param vDest information of the Vertex destination
     * @return paths ArrayList with all paths from vOrig to vDest
     */
    public static <V, E> ArrayList<LinkedList<V>> allPaths(Graph<V, E> graph, V vOrig, V vDest) {

        LinkedList<V> path = new LinkedList<>();
        ArrayList<LinkedList<V>> paths = new ArrayList<>();
        boolean[] visited = new boolean[graph.numVertices()];

        if (graph.validVertex(vOrig) && graph.validVertex(vDest))
            allPaths(graph, vOrig, vDest, visited, path, paths);

        return paths;
    }

    /**
     * Computes shortest-path distance from a source vertex to all reachable
     * vertices of a graph g with non-negative edge weights
     * This implementation uses Dijkstra's algorithm
     *
     * @param graph        Graph instance
     * @param vOrig    Vertex that will be the source of the path
     * @param visited  set of previously visited vertices
     * @param pathKeys minimum path vertices keys
     * @param dist     minimum distances
     */
    private static <V, E> void shortestPathDijkstra(Graph<V, E> graph, V vOrig,
                                                    Comparator<E> ce, BinaryOperator<E> sum, E zero,
                                                    boolean[] visited, V [] pathKeys, E [] dist) {
        int vkey = graph.key(vOrig);
        dist[vkey] = zero;
        pathKeys[vkey] = vOrig;
        while (vOrig != null) {
            vkey = graph.key(vOrig);
            visited[vkey] = true;
            for (Edge<V, E> edge : graph.outgoingEdges(vOrig)) {
                int vkeyAdj = graph.key(edge.getVDest());
                if (!visited[vkeyAdj]) {
                    E s = sum.apply(dist[vkey], edge.getWeight());
                    if (dist[vkeyAdj] == null || ce.compare(dist[vkeyAdj], s) > 0) {
                        dist[vkeyAdj] = s;
                        pathKeys[vkeyAdj] = vOrig;
                    }
                }
            }
            E minDist = null;  //next vertice, that has minimum dist
            vOrig = null;
            for (V vert : graph.vertices()) {
                int i = graph.key(vert);
                if (!visited[i] && (dist[i] != null) && ((minDist == null) || ce.compare(dist[i], minDist) < 0)) {
                    minDist = dist[i];
                    vOrig = vert;
                }
            }
        }
    }


    private static <V, E> void initializePathDist(int nVerts, V[] pathKeys, E[] dist) {
        for (int i = 0; i < nVerts; i++) {
            dist[i] = null;
            pathKeys[i] = null;
        }
    }

    /** Shortest-path between two vertices
     *
     * @param graph graph
     * @param vOrig origin vertex
     * @param vDest destination vertex
     * @param ce comparator between elements of type E
     * @param sum sum two elements of type E
     * @param zero neutral element of the sum in elements of type E
     * @param shortPath returns the vertices which make the shortest path
     * @return if vertices exist in the graph and are connected, true, false otherwise
     */
    public static <V, E> E shortestPath(Graph<V, E> graph, V vOrig, V vDest,
                                        Comparator<E> ce, BinaryOperator<E> sum, E zero,
                                        LinkedList<V> shortPath) {

        if (!graph.validVertex(vOrig) || !graph.validVertex(vDest))
            return null;

        shortPath.clear();
        int numVerts = graph.numVertices();
        boolean[] visited = new boolean[numVerts]; //default value: false
        @SuppressWarnings("unchecked")
        V[] pathKeys = (V[]) new Object [numVerts];
        @SuppressWarnings("unchecked")
        E[] dist = (E[]) new Object [numVerts];
        initializePathDist(numVerts, pathKeys, dist);

        shortestPathDijkstra(graph, vOrig, ce, sum, zero, visited, pathKeys, dist);

        E lengthPath = dist[graph.key(vDest)];

        if (lengthPath != null) {
            getPath(graph, vOrig, vDest, pathKeys, shortPath);
            return lengthPath;
        }
        return null;
    }

    /** Shortest-path between a vertex and all other vertices
     *
     * @param graph graph
     * @param vOrig start vertex
     * @param paths returns all the minimum paths
     * @param dists returns the corresponding minimum distances
     * @return if vOrig exists in the graph true, false otherwise
     */
    public static <V, E extends Number> boolean shortestPaths(Graph<V, E> graph, V vOrig,
                                                              Comparator<E> ce, BinaryOperator<E> sum, E zero,
                                                              ArrayList<LinkedList<V>> paths, ArrayList<E> dists){
        if (!graph.validVertex(vOrig)) return false;

        paths.clear(); dists.clear();
        int numVerts = graph.numVertices();
        boolean[] visited = new boolean[numVerts]; //default value: false
        @SuppressWarnings("unchecked")
        V[] pathKeys = (V[]) new Object [numVerts];
        @SuppressWarnings("unchecked")
        E[] dist = (E[]) new Object [numVerts];
        initializePathDist(numVerts, pathKeys, dist);

        shortestPathDijkstra(graph, vOrig, ce, sum, zero, visited, pathKeys, dist);

        dists.clear();
        paths.clear();
        for (int i = 0; i < numVerts; i++) {
            paths.add(null);
            dists.add(null);
        }
        for (V vDst : graph.vertices()) {
            int i = graph.key(vDst);
            if (dist[i] != null) {
                LinkedList<V> shortPath = new LinkedList<>();
                getPath(graph, vOrig, vDst, pathKeys, shortPath);
                paths.set(i, shortPath);
                dists.set(i, dist[i]);
            }
        }
        return true;
    }


    /**
     * Extracts from pathKeys the minimum path between voInf and vdInf
     * The path is constructed from the end to the beginning
     *
     * @param g        Graph instance
     * @param vOrig    information of the Vertex origin
     * @param vDest    information of the Vertex destination
     * @param pathKeys minimum path vertices keys
     * @param path     stack with the minimum path (correct order)
     */
    private static <V, E> void getPath(Graph<V, E> g, V vOrig, V vDest,
                                       V [] pathKeys, LinkedList<V> path) {

        if (vOrig.equals(vDest))
            path.push(vOrig);
        else {
            path.push(vDest);
            int vKey = g.key(vDest);
            vDest = pathKeys[vKey];
            getPath(g, vOrig, vDest, pathKeys, path);
        }
    }
    /** Calculates the minimum distance graph using Floyd-Warshall
     *
     * @param graph initial graph
     * @param ce comparator between elements of type E
     * @param sum sum two elements of type E
     * @return the minimum distance graph
     */

    public static <V,E> MapGraph<V,E> minDistGraph(Graph <V,E> graph, Comparator<E> ce, BinaryOperator<E> sum) {
        int numVerts = graph.numVertices();
        if (numVerts == 0) return null;

        @SuppressWarnings("unchecked")
        E[][] m = (E[][]) new Object [numVerts][numVerts];

        for (int i = 0 ; i < numVerts ; i++)
            for (int j = 0 ; j < numVerts ; j++) {
                Edge <V,E> e = graph.edge(i, j);
                if (e != null) m[i][j] = e.getWeight();
            }

        for(int k = 0 ; k < numVerts ; k++)
            for (int i = 0 ; i < numVerts ; i++)
                if (i != k && m[i][k] != null)
                    for (int j = 0 ; j < numVerts ; j++)
                        if (j != i && j != k && m[k][j] != null) {
                            E s = sum.apply(m[i][k], m[k][j]);
                            if ((m[i][j] == null) || ce.compare(m[i][j], s) > 0) m[i][j] = s;
                        }

        return new MapGraph<V, E>(graph.isDirected()) {
        };
    }

}