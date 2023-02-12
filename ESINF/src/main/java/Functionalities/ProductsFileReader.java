package Functionalities;

import Controller.App;
import Domain.Participants.Client;
import Domain.Participants.Participant;
import Domain.Participants.Producer;
import Domain.Products.BasketOrder;
import Domain.Products.Product;
import Domain.DistributionNetworkData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsFileReader implements IReaderFromFile {

    private static final String HEADER_FIRST_ELEMENT = "Clientes-Produtores";
    // App's distribution network data
    private final DistributionNetworkData distributionNetworkData = App.getInstance().getSystemData();

    @Override
    public boolean readFromFile(String path) {
        // Instantiate the reader
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(path));

            // Read the header
            String line = reader.readLine();
            line = line.replace("\"", "");
            String[] header = line.split(",");

            if (!header[0].equals(HEADER_FIRST_ELEMENT))
                return false;

            // Get the products names
            List<String> productNames = new ArrayList<>(Arrays.asList(header).subList(2, header.length));


            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                line = line.replace("\"", "");
                String[] lineElements = line.split(",");

                String participantType = lineElements[0].substring(0, 1);

                // Check if the participant is a client or a producer

                // If it's a client then create a new basket order
                if (participantType.equals(Participant.PARTICULAR) || participantType.equals(Participant.COMPANY)) {
                    addOrder(lineElements, productNames);
                }

                // If it's a producer then add the products to the network list of available products
                if (participantType.equals(Participant.PRODUCER)) {
                    addProducts(lineElements, productNames);
                }
            }
        } catch (IOException e) {
            return false;
        }

        return !distributionNetworkData.getOrders().isEmpty() || !distributionNetworkData.getProductsAvailableInTheNetwork().isEmpty();
    }

    public void addOrder(String[] lineElements, List<String> productNames) {
        Client client = (Client) distributionNetworkData.getDistributionNetwork().getParticipantByID(lineElements[0]);

        if (client == null) {
            return;
        }

        List<Product> products = new ArrayList<>();
        for (int i = 2; i < lineElements.length; i++) {
            // If product quantity is greater than 0 then add it to the order
            if (Double.parseDouble(lineElements[i]) > 0) {
                products.add(new Product(productNames.get(i - 2), Double.parseDouble(lineElements[i])));
            }
        }

        if (products.size() > 0) {
            BasketOrder order = new BasketOrder(products, client, Integer.parseInt(lineElements[1]));
            distributionNetworkData.getOrders().add(order);
        }
    }

    public void addProducts(String[] lineElements, List<String> productNames) {
        lineElements[0] = lineElements[0].replace("\"", "");
        Producer producer = (Producer) distributionNetworkData.getDistributionNetwork().getParticipantByID(lineElements[0]);

        // Add products to the distribution network
        for (int i = 2; i < lineElements.length; i++) {
            if (Double.parseDouble(lineElements[i]) > 0) {
                Product product = new Product(productNames.get(i - 2), Double.parseDouble(lineElements[i]), Integer.parseInt(lineElements[1]), producer);
                distributionNetworkData.getProductsAvailableInTheNetwork().add(product);
            }
        }
    }
}
