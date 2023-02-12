package Functionalities;

import Controller.*;
import Domain.*;
import Domain.Participants.*;
import Domain.Products.*;
import Miscellaneous.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculateStatisticsTest {

    private final DispatchListGenerator dispatchListGenerator = new DispatchListGenerator();
    private List<BasketOrder> dispatchList;
    private final CalculateStatisticsController controller = new CalculateStatisticsController();
    private final DistributionNetwork network = App.getInstance().getSystemData().getDistributionNetwork();
    @BeforeEach
    void setUp() {
        // Loading information from files
        App.getInstance().getSystemData().getOrders().clear();
        App.getInstance().getSystemData().getProductsAvailableInTheNetwork().clear();
        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        participantsFileReader.readFromFile("DataToLoad/Test/DispatchListData/DispListParticipants.csv");
        RoutesFileReader routesFileReader = new RoutesFileReader();
        routesFileReader.readFromFile("DataToLoad/Test/DispatchListData/DispListDistancias.csv");

        network.determineHubs(1);
        network.findNearestHUB(network.getListOfClients());
    }

    /**
     * Test 1 - Test if the statistics are calculated correctly
     */
    @Test
    void calculateStatistics_ValidDispatchList_ReturnsTrue() {
        // ARRANGE
        ProductsFileReader productsFileReader = new ProductsFileReader();
        productsFileReader.readFromFile("DataToLoad/Test/DispatchListData/DispListCabazesValidTest.csv");
        int day = 1;
        dispatchList = dispatchListGenerator.generateSimpleDispatchList(App.getInstance().getSystemData().getOrders(), day);


        // ACT
        controller.calculateStatistics(dispatchList);

        // BasketOrder
        List<BasketOrderStatistics> basketOrderResultList = controller.getBasketOrderStatistics();
        List<BasketOrderStatistics> basketOrderExpectedList = new ArrayList<>();
        basketOrderExpectedList.add(new BasketOrderStatistics(3, 0, 0, 1));
        basketOrderExpectedList.add(new BasketOrderStatistics(0, 1, 0, 1));
        basketOrderExpectedList.add(new BasketOrderStatistics(0, 2, 0, 2));

        // ASSERT - BASKET ORDER
        assertEquals(basketOrderExpectedList, basketOrderResultList);



        // Client
        Collection<ClientStatistics> clientResultList = controller.getClientStatistics();
        Collection<ClientStatistics> clientExpectedList = new ArrayList<>();
        clientExpectedList.add(new ClientStatistics(0, 1, 2));
        clientExpectedList.add(new ClientStatistics(1, 0, 1));
        clientExpectedList.add(new ClientStatistics(0, 1, 1));

        // ASSERT - CLIENT
        assertTrue(clientResultList.containsAll(clientExpectedList));


        // Producer
        Collection<ProducerStatistics> producerResultList = controller.getProducerStatistics();
        Collection<ProducerStatistics> producerExpectedList = new ArrayList<>();
        ProducerStatistics p1 = new ProducerStatistics(new Producer("P1"),  1, 2, 3);
        p1.addClient(new Client("C1")); p1.addClient(new Client("C2")); p1.addClient(new Client("C3"));
        p1.addHub("E1");
        ProducerStatistics p2 = new ProducerStatistics(new Producer("P2"),0, 1, 1);
        p2.addClient(new Client("C3"));
        p2.addHub("E1");

        producerExpectedList.add(p1); producerExpectedList.add(p2);

        // ASSERT - PRODUCER
        assertTrue(producerResultList.containsAll(producerExpectedList));


        // Hub
        Collection<HubStatistics> hubResultList = controller.getHubStatistics();
        Collection<HubStatistics> hubExpectedList = new ArrayList<>();
        HubStatistics h1 = new HubStatistics("E1");
        h1.addClient(new Client("C1")); h1.addClient(new Client("C2")); h1.addClient(new Client("C3"));
        h1.addProducer(new Producer("P1")); h1.addProducer(new Producer("P2"));

        hubExpectedList.add(h1);

        // ASSERT - HUB
        assertTrue(hubResultList.containsAll(hubExpectedList));
    }

    /**
     * Test 2 - with an emtpy dispatch list
     */
    @Test
    void calculateStatistics_EmptyDispatchList_ReturnsTrue() {
        // ARRANGE
        ProductsFileReader productsFileReader = new ProductsFileReader();
        productsFileReader.readFromFile("DataToLoad/Test/DispatchListData/DispListCabazesValidTest.csv");
        dispatchList = new ArrayList<>();

        // ACT
        controller.calculateStatistics(dispatchList);

        // BasketOrder
        List<BasketOrderStatistics> basketOrderResultList = controller.getBasketOrderStatistics();
        List<BasketOrderStatistics> basketOrderExpectedList = new ArrayList<>();

        // ASSERT - BASKET ORDER
        assertEquals(basketOrderExpectedList, basketOrderResultList);

        // Client
        Collection<ClientStatistics> clientResultList = controller.getClientStatistics();
        Collection<ClientStatistics> clientExpectedList = new ArrayList<>();

        // ASSERT - CLIENT
        assertTrue(clientResultList.containsAll(clientExpectedList));

        // Producer
        Collection<ProducerStatistics> producerResultList = controller.getProducerStatistics();
        Collection<ProducerStatistics> producerExpectedList = new ArrayList<>();

        // ASSERT - PRODUCER
        assertTrue(producerResultList.containsAll(producerExpectedList));

        // Hub
        Collection<HubStatistics> hubResultList = controller.getHubStatistics();
        Collection<HubStatistics> hubExpectedList = new ArrayList<>();

        // ASSERT - HUB
        assertTrue(hubResultList.containsAll(hubExpectedList));
    }

    /**
     * Test 3 - with a dispatch list with a null basket order
     */
    @Test
    void calculateStatistics_NullBasketOrder_ReturnsTrue() {
        // ARRANGE
        ProductsFileReader productsFileReader = new ProductsFileReader();
        productsFileReader.readFromFile("DataToLoad/Test/DispatchListData/DispListCabazesValidTest.csv");
        dispatchList = dispatchListGenerator.generateSimpleDispatchList(App.getInstance().getSystemData().getOrders(), 1);
        dispatchList.add(null);

        // ACT
        controller.calculateStatistics(dispatchList);

        // BasketOrder
        List<BasketOrderStatistics> basketOrderResultList = controller.getBasketOrderStatistics();
        List<BasketOrderStatistics> basketOrderExpectedList = new ArrayList<>();
        basketOrderExpectedList.add(new BasketOrderStatistics(3, 0, 0, 1));
        basketOrderExpectedList.add(new BasketOrderStatistics(0, 1, 0, 1));
        basketOrderExpectedList.add(new BasketOrderStatistics(0, 2, 0, 2));

        // ASSERT - BASKET ORDER
        assertEquals(basketOrderExpectedList, basketOrderResultList);

        // Client
        Collection<ClientStatistics> clientResultList = controller.getClientStatistics();
        Collection<ClientStatistics> clientExpectedList = new ArrayList<>();
        clientExpectedList.add(new ClientStatistics(0, 1, 2));
        clientExpectedList.add(new ClientStatistics(1, 0, 1));
        clientExpectedList.add(new ClientStatistics(0, 1, 1));

        // ASSERT - CLIENT
        assertTrue(clientResultList.containsAll(clientExpectedList));


        // Producer
        Collection<ProducerStatistics> producerResultList = controller.getProducerStatistics();
        Collection<ProducerStatistics> producerExpectedList = new ArrayList<>();
        ProducerStatistics p1 = new ProducerStatistics(new Producer("P1"),  1, 2, 3);
        p1.addClient(new Client("C1")); p1.addClient(new Client("C2")); p1.addClient(new Client("C3"));
        p1.addHub("E1");
        ProducerStatistics p2 = new ProducerStatistics(new Producer("P2"),0, 1, 1);
        p2.addClient(new Client("C3"));
        p2.addHub("E1");

        producerExpectedList.add(p1); producerExpectedList.add(p2);

        // ASSERT - PRODUCER
        assertTrue(producerResultList.containsAll(producerExpectedList));


        // Hub
        Collection<HubStatistics> hubResultList = controller.getHubStatistics();
        Collection<HubStatistics> hubExpectedList = new ArrayList<>();
        HubStatistics h1 = new HubStatistics("E1");
        h1.addClient(new Client("C1")); h1.addClient(new Client("C2")); h1.addClient(new Client("C3"));
        h1.addProducer(new Producer("P1")); h1.addProducer(new Producer("P2"));

        hubExpectedList.add(h1);

        // ASSERT - HUB
        assertTrue(hubResultList.containsAll(hubExpectedList));
    }

    /**
     * Test 4 - with a dispatch list with a null product
     */
    @Test
    void calculateStatistics_NullProduct_ReturnsTrue() {
        // ARRANGE
        ProductsFileReader productsFileReader = new ProductsFileReader();
        productsFileReader.readFromFile("DataToLoad/Test/DispatchListData/DispListCabazesValidTest.csv");
        dispatchList = dispatchListGenerator.generateSimpleDispatchList(App.getInstance().getSystemData().getOrders(), 1);
        dispatchList.get(0).getProducts().add(null);

        // ACT
        controller.calculateStatistics(dispatchList);

        // BasketOrder
        List<BasketOrderStatistics> basketOrderResultList = controller.getBasketOrderStatistics();
        List<BasketOrderStatistics> basketOrderExpectedList = new ArrayList<>();
        basketOrderExpectedList.add(new BasketOrderStatistics(3, 0, 0, 1));
        basketOrderExpectedList.add(new BasketOrderStatistics(0, 1, 0, 1));
        basketOrderExpectedList.add(new BasketOrderStatistics(0, 2, 0, 2));

        // ASSERT - BASKET ORDER
        assertEquals(basketOrderExpectedList, basketOrderResultList);

        // Client
        Collection<ClientStatistics> clientResultList = controller.getClientStatistics();
        Collection<ClientStatistics> clientExpectedList = new ArrayList<>();
        clientExpectedList.add(new ClientStatistics(0, 1, 2));
        clientExpectedList.add(new ClientStatistics(1, 0, 1));
        clientExpectedList.add(new ClientStatistics(0, 1, 1));

        // ASSERT - CLIENT
        assertTrue(clientResultList.containsAll(clientExpectedList));


        // Producer
        Collection<ProducerStatistics> producerResultList = controller.getProducerStatistics();
        Collection<ProducerStatistics> producerExpectedList = new ArrayList<>();
        ProducerStatistics p1 = new ProducerStatistics(new Producer("P1"),  1, 2, 3);
        p1.addClient(new Client("C1")); p1.addClient(new Client("C2")); p1.addClient(new Client("C3"));
        p1.addHub("E1");
        ProducerStatistics p2 = new ProducerStatistics(new Producer("P2"),0, 1, 1);
        p2.addClient(new Client("C3"));
        p2.addHub("E1");

        producerExpectedList.add(p1); producerExpectedList.add(p2);

        // ASSERT - PRODUCER
        assertTrue(producerResultList.containsAll(producerExpectedList));


        // Hub
        Collection<HubStatistics> hubResultList = controller.getHubStatistics();
        Collection<HubStatistics> hubExpectedList = new ArrayList<>();
        HubStatistics h1 = new HubStatistics("E1");
        h1.addClient(new Client("C1")); h1.addClient(new Client("C2")); h1.addClient(new Client("C3"));
        h1.addProducer(new Producer("P1")); h1.addProducer(new Producer("P2"));

        hubExpectedList.add(h1);

        // ASSERT - HUB
        assertTrue(hubResultList.containsAll(hubExpectedList));
    }

}