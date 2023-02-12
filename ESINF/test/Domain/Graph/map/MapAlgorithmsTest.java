package Domain.Graph.map;

import Domain.Graph.Algorithms;
import Domain.Graph.DijkstraObject;
import Domain.Graph.Graph;
import Miscellaneous.AuxiliaryAlgorithms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MapAlgorithmsTest {

    final Graph<String, Double> completeMap = new MapGraph<>(false);
    Graph<String, Double> incompleteMap = new MapGraph<>(false);

    public MapAlgorithmsTest() {
    }

    @BeforeEach
    public void setUp() {

        completeMap.addVertex("Porto");
        completeMap.addVertex("Braga");
        completeMap.addVertex("Vila Real");
        completeMap.addVertex("Aveiro");
        completeMap.addVertex("Coimbra");
        completeMap.addVertex("Leiria");

        completeMap.addVertex("Viseu");
        completeMap.addVertex("Guarda");
        completeMap.addVertex("Castelo Branco");
        completeMap.addVertex("Lisboa");
        completeMap.addVertex("Faro");

        completeMap.addEdge("Porto", "Aveiro", 75.0);
        completeMap.addEdge("Porto", "Braga", 60.0);
        completeMap.addEdge("Porto", "Vila Real", 100.0);
        completeMap.addEdge("Viseu", "Guarda", 75.0);
        completeMap.addEdge("Guarda", "Castelo Branco", 100.0);
        completeMap.addEdge("Aveiro", "Coimbra", 60.0);
        completeMap.addEdge("Coimbra", "Lisboa", 200.0);
        completeMap.addEdge("Coimbra", "Leiria", 80.0);
        completeMap.addEdge("Aveiro", "Leiria", 120.0);
        completeMap.addEdge("Leiria", "Lisboa", 150.0);

        incompleteMap = completeMap.clone();

        completeMap.addEdge("Aveiro", "Viseu", 85.0);
        completeMap.addEdge("Leiria", "Castelo Branco", 170.0);
        completeMap.addEdge("Lisboa", "Faro", 28.00);
    }

    private void checkContentEquals(List<String> l1, List<String> l2, String msg) {
        Collections.sort(l1);
        Collections.sort(l2);
        assertEquals(l1, l2, msg);
    }

    /**
     * Test of BreadthFirstSearch method, of class Algorithms.
     */
    @Test
    public void testBreadthFirstSearch() {
        System.out.println("Test BreadthFirstSearch");

        Assertions.assertNull(Algorithms.BreadthFirstSearch(completeMap, "LX"), "Should be null if vertex does not exist");

        LinkedList<String> path = Algorithms.BreadthFirstSearch(incompleteMap, "Faro");

        assertEquals(1, path.size(), "Should be just one");

        assertEquals("Faro", path.peekFirst());

        path = Algorithms.BreadthFirstSearch(incompleteMap, "Porto");
        assertEquals(7, path.size(), "Should give seven vertices");

        assertEquals("Porto", path.removeFirst(), "BreathFirst Porto");

        LinkedList<String> expected = new LinkedList<>(Arrays.asList("Aveiro", "Braga", "Vila Real"));
        checkContentEquals(expected, path.subList(0, 3), "BreathFirst Porto");

        expected = new LinkedList<>(Arrays.asList("Coimbra", "Leiria"));
        checkContentEquals(expected, path.subList(3, 5), "BreathFirst Porto");

        expected = new LinkedList<>(Arrays.asList("Lisboa"));
        checkContentEquals(expected, path.subList(5, 6), "BreathFirst Porto");

        path = Algorithms.BreadthFirstSearch(incompleteMap, "Viseu");
        expected = new LinkedList<>(Arrays.asList("Viseu", "Guarda", "Castelo Branco"));
        assertEquals(expected, path, "BreathFirst Viseu");
    }

    /**
     * Test of DepthFirstSearch method, of class Algorithms.
     */
    @Test
    public void testDepthFirstSearch() {
        System.out.println("Test of DepthFirstSearch");

        assertNull(Algorithms.DepthFirstSearch(completeMap, "LX"), "Should be null if vertex does not exist");

        LinkedList<String> path = Algorithms.DepthFirstSearch(incompleteMap, "Faro");
        assertEquals(1, path.size(), "Should be just one");

        assertEquals("Faro", path.peekFirst());

        path = Algorithms.BreadthFirstSearch(incompleteMap, "Porto");
        assertEquals(7, path.size(), "Should give seven vertices");

        assertEquals("Porto", path.removeFirst(), "DepthFirst Porto");
        assertTrue(new LinkedList<>(Arrays.asList("Aveiro", "Braga", "Vila Real")).contains(path.removeFirst()), "DepthFirst Porto");

        path = Algorithms.BreadthFirstSearch(incompleteMap, "Viseu");
        List<String> expected = new LinkedList<>(Arrays.asList("Viseu", "Guarda", "Castelo Branco"));
        assertEquals(expected, path, "DepthFirst Viseu");
    }

    /**
     * Test of shortestPath method, of class Algorithms.
     */
    @Test
    public void testShortestPath() {
        System.out.println("Test of shortest path");

        // Test with invalid vertex
        List<DijkstraObject<String, Double>> path = AuxiliaryAlgorithms.shortestPath(completeMap, completeMap.vertices().get(0), "LX", 0.0);
        List<DijkstraObject<String, Double>> actual = null;

        assertEquals(actual, path, "Should be empty if vertex does not exist");


        // Test with no connections possible between vertices
        path = AuxiliaryAlgorithms.shortestPath(incompleteMap, incompleteMap.vertices().get(0), incompleteMap.vertices().get(10), 0.0);
        actual = new ArrayList<>();
        actual.add(new DijkstraObject<>(incompleteMap.vertices().get(10), null, null));

        assertEquals(actual, path, "Should be empty if no connections possible between vertices");


        // Test with the same vertex as source and destination
        path = AuxiliaryAlgorithms.shortestPath(incompleteMap, incompleteMap.vertices().get(0), incompleteMap.vertices().get(0), 0.0);
        actual = new ArrayList<>();
        actual.add(new DijkstraObject<>(incompleteMap.vertices().get(0), 0.0, null));

        assertEquals(actual, path, "Should be empty if no connections possible between vertices");


        // Test with correct information, Porto - Faro
        path = AuxiliaryAlgorithms.shortestPath(completeMap, completeMap.vertices().get(0), completeMap.vertices().get(10), 0.0);
        actual = new ArrayList<>();
        actual.add(new DijkstraObject<>(completeMap.vertices().get(0), 0.0, null));
        actual.add(new DijkstraObject<>(completeMap.vertices().get(3), 75.0, completeMap.vertices().get(0)));
        actual.add(new DijkstraObject<>(completeMap.vertices().get(4), 135.0, completeMap.vertices().get(3)));
        actual.add(new DijkstraObject<>(completeMap.vertices().get(9), 335.0, completeMap.vertices().get(4)));
        actual.add(new DijkstraObject<>(completeMap.vertices().get(10), 363.0, completeMap.vertices().get(9)));

        assertEquals(actual, path, "Shortest Path: Porto - Aveiro - Coimbra - Lisboa - Faro");


        // Test with correct information, Coimbra - Vila Real
        path = AuxiliaryAlgorithms.shortestPath(completeMap, completeMap.vertices().get(4), completeMap.vertices().get(2), 0.0);
        actual = new ArrayList<>();
        actual.add(new DijkstraObject<>(completeMap.vertices().get(4), 0.0, null));
        actual.add(new DijkstraObject<>(completeMap.vertices().get(3), 60.0, completeMap.vertices().get(4)));
        actual.add(new DijkstraObject<>(completeMap.vertices().get(0), 135.0, completeMap.vertices().get(3)));
        actual.add(new DijkstraObject<>(completeMap.vertices().get(2), 235.0, completeMap.vertices().get(0)));

        assertEquals(actual, path, "Shortest Path: Coimbra - Porto - Aveiro - Vila Real");


        // Test with correct information, Leiria - Guarda
        path = AuxiliaryAlgorithms.shortestPath(completeMap, completeMap.vertices().get(5), completeMap.vertices().get(7), 0.0);
        actual = new ArrayList<>();
        actual.add(new DijkstraObject<>(completeMap.vertices().get(5), 0.0, null));
        actual.add(new DijkstraObject<>(completeMap.vertices().get(8), 170.0, completeMap.vertices().get(5)));
        actual.add(new DijkstraObject<>(completeMap.vertices().get(7), 270.0, completeMap.vertices().get(8)));;

        assertEquals(actual, path, "Shortest Path: Leiria - Castelo Branco - Guarda");

    }

    private void setUp(Map<String, DijkstraObject<String, Double>> dijkstraObjectMap, Map<String, Boolean> visited, String vOrig) {
        visited.clear();
        dijkstraObjectMap.clear();

        DijkstraObject<String, Double> first = new DijkstraObject<>(vOrig, 0.0, null);

        dijkstraObjectMap.put(vOrig, first);

        for (String vert : completeMap.vertices()) {
            if (!vert.equals(vOrig))
                dijkstraObjectMap.put(vert, new DijkstraObject<>(vert, null, null));
            visited.put(vert, false);
        }
    }

    // Test the method getVertexWithMostConnections
    @Test
    public void testGetVertexWithMostConnections() {
        System.out.println("Test of getVertexWithMostConnections");

        // Setting things up for the tests
        DijkstraObject<String, Double> expected;
        DijkstraObject<String, Double> actual;

        Map<String, DijkstraObject<String, Double>> dijkstraObjectMap = new HashMap<>();
        Map<String, Boolean> visitedMap = new HashMap<>();;
        String vOrig;

        // Test with correct Information, passing Porto, should return Castelo Branco
        vOrig = completeMap.vertices().get(0);
        setUp(dijkstraObjectMap, visitedMap, vOrig);
        AuxiliaryAlgorithms.shortestPathDijkstra(completeMap, vOrig, visitedMap, dijkstraObjectMap);
        actual = AuxiliaryAlgorithms.getVertexWithMostConnections(vOrig, dijkstraObjectMap);
        expected = new DijkstraObject<>(completeMap.vertices().get(0), 4.0, completeMap.vertices().get(8));

        assertEquals(actual, expected, "Braga - Castelo Branco - 5.0");

        // Test with correct Information, passing Castelo Branco, should return Braga
        vOrig = expected.getKey();
        setUp(dijkstraObjectMap, visitedMap, vOrig);
        AuxiliaryAlgorithms.shortestPathDijkstra(completeMap, vOrig, visitedMap, dijkstraObjectMap);
        actual = AuxiliaryAlgorithms.getVertexWithMostConnections(vOrig, dijkstraObjectMap);
        expected = new DijkstraObject<>(completeMap.vertices().get(0), 4.0, completeMap.vertices().get(8));;

        assertEquals(actual, expected, "Braga - Castelo Branco - 5.0");



        // Test with correct Information, passing Aveiro, should return Castelo Branco
        dijkstraObjectMap = new HashMap<>();
        visitedMap = new HashMap<>();
        vOrig = completeMap.vertices().get(1);
        setUp(dijkstraObjectMap, visitedMap, vOrig);
        AuxiliaryAlgorithms.shortestPathDijkstra(completeMap, vOrig, visitedMap, dijkstraObjectMap);
        actual = AuxiliaryAlgorithms.getVertexWithMostConnections(vOrig, dijkstraObjectMap);
        expected = new DijkstraObject<>(completeMap.vertices().get(1), 5.0, completeMap.vertices().get(8));

        assertEquals(actual, expected, "Braga - Castelo Branco - 5.0");

        // Test with correct Information, passing Castelo Branco, should return Braga
        vOrig = expected.getKey();
        setUp(dijkstraObjectMap, visitedMap, vOrig);
        AuxiliaryAlgorithms.shortestPathDijkstra(completeMap, vOrig, visitedMap, dijkstraObjectMap);
        actual = AuxiliaryAlgorithms.getVertexWithMostConnections(vOrig, dijkstraObjectMap);
        expected =  new DijkstraObject<>(completeMap.vertices().get(1), 5.0, completeMap.vertices().get(8));

        assertEquals(actual, expected, "Braga - Castelo Branco - 5.0");

        // Test with invalid Information, passing non-existing vertex, should return null
        dijkstraObjectMap = new HashMap<>();
        visitedMap = new HashMap<>();
        vOrig = "Non-existing vertex";
        setUp(dijkstraObjectMap, visitedMap, vOrig);
        AuxiliaryAlgorithms.shortestPathDijkstra(completeMap, vOrig, visitedMap, dijkstraObjectMap);
        actual = AuxiliaryAlgorithms.getVertexWithMostConnections(vOrig, dijkstraObjectMap);
        expected = new DijkstraObject<>("Non-existing vertex", 0.0, null);

        assertEquals(actual, expected, "Should be null");


        // Test with correct Information, passing Faro, should return Braga
        vOrig = completeMap.vertices().get(10);
        setUp(dijkstraObjectMap, visitedMap, vOrig);
        AuxiliaryAlgorithms.shortestPathDijkstra(completeMap, vOrig, visitedMap, dijkstraObjectMap);
        actual = AuxiliaryAlgorithms.getVertexWithMostConnections(vOrig, dijkstraObjectMap);
        expected = new DijkstraObject<>(completeMap.vertices().get(10), 5.0, completeMap.vertices().get(1));

        assertEquals(actual, expected, "Faro - Braga - 5.0");

        // Test with correct Information, passing Braga, should return Castelo Branco
        vOrig = expected.getKey();
        setUp(dijkstraObjectMap, visitedMap, vOrig);
        AuxiliaryAlgorithms.shortestPathDijkstra(completeMap, vOrig, visitedMap, dijkstraObjectMap);
        actual = AuxiliaryAlgorithms.getVertexWithMostConnections(vOrig, dijkstraObjectMap);
        expected = new DijkstraObject<>(completeMap.vertices().get(10), 5.0, completeMap.vertices().get(1));

        assertEquals(actual, expected, "Faro - Braga - 5");

    }


}