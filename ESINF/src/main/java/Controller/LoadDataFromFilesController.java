package Controller;

import Functionalities.ParticipantsFileReader;
import Functionalities.ProductsFileReader;
import Functionalities.RoutesFileReader;
import Functionalities.WateringPlanReader;

public class LoadDataFromFilesController {

    /**
     * Loads participants into the system's distribution network.
     *
     * @param path the path to the file containing the participants
     * @return the boolean associated with the success of the operation
     */
    public boolean loadParticipants(String path) {
        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        return participantsFileReader.readFromFile(path);
    }

    /**
     * Load routes between the distribution network participants.
     *
     * @param path the path
     * @return the boolean
     */
    public boolean loadRoutes(String path) {
        RoutesFileReader routesFileReader = new RoutesFileReader();
        return routesFileReader.readFromFile(path);
    }

    /**
     * Load products and orders into the system's distribution network.
     *
     * @param path the path
     * @return the boolean
     */
    public boolean loadProducts(String path) {
        ProductsFileReader productsFileReader = new ProductsFileReader();
        return productsFileReader.readFromFile(path);
    }

    /**
     * Load a watering plan into the store that contains those.
     *
     * @param path the path
     * @return the boolean
     */
    public boolean loadWateringPlan(String path) {
        WateringPlanReader productsFileReader = new WateringPlanReader();
        return productsFileReader.readFromFile(path);
    }
}
