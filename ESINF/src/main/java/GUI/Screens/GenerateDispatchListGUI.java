package GUI.Screens;

import Controller.*;
import Domain.Products.BasketOrder;
import Domain.Products.Product;
import GUI.Components.*;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class GenerateDispatchListGUI implements Initializable {


    @FXML
    private BorderPane borderPane;

    @FXML
    private HBox hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight, hBoxBar;

    @FXML
    private TableView<GenerateDispatchListHelper> tableView;

    @FXML
    private TableColumn<GenerateDispatchListHelper, String> tcProduct, tcQtOrdered, tcQtDispatched, tcProducer;

    @FXML
    private Button btProfile, btHome, btSettings, btBack;

    @FXML
    private Label txtTitleDispList;

    @FXML
    private ComboBox<String> cbChooseClient;

    // This map hold the relation between each client, and it's ordered products
    private final  Map<String, List<GenerateDispatchListHelper>> clientToProductsMap = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Sets the responsiveness into the bottom bar - Center the items
        borderPane.widthProperty().addListener(e -> {
            CommonsGUI.setResponsiveness(borderPane, hBoxBar, hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight, btProfile, btHome, btSettings);
        });
        // Defining the Back's button's action
        btBack.setOnAction(e -> {
            try {
                MainPageGUIHelper mainPageGUIHelper = new MainPageGUIHelper();
                mainPageGUIHelper.toGenerateDispatchListMenuGUI(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        // Defining the Button Bar Button's actions
        CommonsGUI.setBarButtons(btHome, btProfile, btSettings);

        cbChooseClient.setOnAction(this::chooseClient);
    }

    private void chooseClient(ActionEvent actionEvent) {
        String client = cbChooseClient.getValue();
        // Get the products of the selected client
        List<GenerateDispatchListHelper> productsOfTheSelectedClient = clientToProductsMap.get(client);
        // Set the products into the table
        setTable(productsOfTheSelectedClient);
    }

    public void setInfo(List<BasketOrder> basketOrders, String title) {
        // Setting the title
        txtTitleDispList.setText(title);

        // Setting the combo box
        for (BasketOrder basketOrder : basketOrders) {
            cbChooseClient.getItems().add(basketOrder.getClient().getClientId());
            List<GenerateDispatchListHelper> products = new ArrayList<>();

            for (Product product : basketOrder.getProducts()) {
                if (product.getProducer() != null){
                    products.add(new GenerateDispatchListHelper(product.getName(), product.getOrderedQuantity(), product.getDispatchedQuantity(), product.getProducer().getProducerId()));
                }else{
                    products.add(new GenerateDispatchListHelper(product.getName(), product.getOrderedQuantity()));
                }
            }
            clientToProductsMap.put(basketOrder.getClient().getClientId(), products);
        }

        // Set the combobox
        cbChooseClient.setValue(cbChooseClient.getItems().get(0));
        // Set the table view
        setTable(clientToProductsMap.get(cbChooseClient.getValue()));
    }

    private void setTable(List<GenerateDispatchListHelper> products) {
        tcProduct.setCellValueFactory(new PropertyValueFactory<>("product"));
        tcQtOrdered.setCellValueFactory(new PropertyValueFactory<>("qtOrdered"));
        tcQtDispatched.setCellValueFactory(new PropertyValueFactory<>("qtDispatched"));
        tcProducer.setCellValueFactory(new PropertyValueFactory<>("producer"));
        tableView.setItems(FXCollections.observableArrayList(products));
    }
}
