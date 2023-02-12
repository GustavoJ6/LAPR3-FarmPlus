package Functionalities;

import Controller.App;
import Domain.Participants.Client;
import Domain.Participants.Producer;
import Domain.Products.BasketOrder;
import Domain.Products.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DispatchListGeneratorTest {

    private final DispatchListGenerator dispatchListGenerator = new DispatchListGenerator();
    private final ProductsFileReader productsFileReader = new ProductsFileReader();
    @BeforeEach
    void setUp() {
        App.getInstance().getSystemData().getOrders().clear();
        App.getInstance().getSystemData().getProductsAvailableInTheNetwork().clear();
        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        participantsFileReader.readFromFile("DataToLoad/Test/DispatchListData/DispListParticipants.csv");
        RoutesFileReader routesFileReader = new RoutesFileReader();
        routesFileReader.readFromFile("DataToLoad/Test/DispatchListData/DispListDistancias.csv");
    }

    @Test
    void generateSimpleDispatchList_ValidOrdersAndProducts_ReturnsCorrectDispatchList() {
        // ARRANGE
        productsFileReader.readFromFile("DataToLoad/Test/DispatchListData/DispListCabazesValidTest.csv");
        int day = 1;

        // ACT
        List<BasketOrder> resultList = dispatchListGenerator.generateSimpleDispatchList(App.getInstance().getSystemData().getOrders(), day);
        List<BasketOrder> expectedList = new ArrayList<>();
        Product prod1Order1 = new Product("Prod1",0, 1, new Producer("P1"));
        Product prod2Order1 = new Product("Prod2",0, 1, new Producer("P1"));
        Product prod3Order1 = new Product("Prod3",0, 1, new Producer("P1"));
        BasketOrder order1 = new BasketOrder(List.of(prod1Order1,prod2Order1,prod3Order1), new Client("C1"), 1 );
        expectedList.add(order1);
        Product prod1Order2 = new Product("Prod1",1, 1, new Producer("P1"));
        BasketOrder order2 = new BasketOrder(List.of(prod1Order2), new Client("C2"), 1 );
        expectedList.add(order2);
        Product prod1Order3 = new Product("Prod2",0, 1, new Producer("P1"));
        Product prod2Order3 = new Product("Prod3",1, 1, new Producer("P2"));
        BasketOrder order3 = new BasketOrder(List.of(prod1Order3,prod2Order3), new Client("C3"), 1 );
        expectedList.add(order3);

        // ASSERT
        assertEquals(expectedList.size(), resultList.size());
        assertEquals(expectedList.get(0).getProducts().size(), resultList.get(0).getProducts().size());
        assertEquals(expectedList.get(1).getProducts().size(), resultList.get(1).getProducts().size());
        assertEquals(expectedList.get(2).getProducts().size(), resultList.get(2).getProducts().size());
    }

    @Test
    void generateSimpleDispatchList_NoOrders_ReturnsNull() {
        // ARRANGE
        productsFileReader.readFromFile("DataToLoad/Test/DispatchListData/DispListCabazesEmptyTest.csv");
        int day = 1;

        // ACT
        List<BasketOrder> resultList = dispatchListGenerator.generateSimpleDispatchList(App.getInstance().getSystemData().getOrders(), day);
        List<BasketOrder> expectedList = null;

        // ASSERT
        assertEquals(expectedList, resultList);
    }

    @Test
    void generateSimpleDispatchList_NoProducts_ReturnsNull() {
        // ARRANGE
        productsFileReader.readFromFile("DataToLoad/Test/DispatchListData/DispListCabazesProductsEmptyTest.csv");
        int day = 1;

        // ACT
        List<BasketOrder> resultList = dispatchListGenerator.generateSimpleDispatchList(App.getInstance().getSystemData().getOrders(), day);
        List<BasketOrder> expectedList = null;

        // ASSERT
        assertEquals(expectedList, resultList);
    }

    @Test
    void generateDispatchListWithRestrictions_NoOrdersAndNoProducts_ReturnsNull() {
        // ARRANGE
        productsFileReader.readFromFile("DataToLoad/Test/DispatchListData/DispListCabazesEmptyTest.csv");
        int day = 1;
        int nProducers = 2;

        // ACT
        List<BasketOrder> resultList = dispatchListGenerator.generateDispatchListWithRestrictions(App.getInstance().getSystemData().getOrders(), day, 2);
        List<BasketOrder> expectedList = null;

        // ASSERT
        assertEquals(expectedList, resultList);
    }

}