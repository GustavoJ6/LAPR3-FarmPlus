package Functionalities;

import Controller.App;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductsFileReaderTest {

    @BeforeEach
    void setUp() {
        App.getInstance().getSystemData().clearFullData();
    }

    @Test
    void readFromFile_FileWithCorrectInformation_ReturnsTrue() {

        // ARRANGE
        ProductsFileReader productsFileReader = new ProductsFileReader();
        String path = "DataToLoad/Test/Products(cabazes_small).csv";

        // ACT
        boolean result = productsFileReader.readFromFile(path);

        // ASSERT
        assertTrue(result);
    }

    @Test
    void readFromFile_FileDoesNotExist_ReturnsFalse() {

        // ARRANGE
        ProductsFileReader productsFileReader = new ProductsFileReader();
        String path = "DataToLoad/Test/cabazes_small_not_exists.csv";

        // ACT
        boolean result = productsFileReader.readFromFile(path);

        // ASSERT
        assertFalse(result);
    }
}