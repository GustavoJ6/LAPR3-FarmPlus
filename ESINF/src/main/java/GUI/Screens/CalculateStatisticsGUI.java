package GUI.Screens;

import Controller.CalculateStatisticsController;
import Domain.Participants.*;
import Domain.Products.*;
import GUI.Components.*;
import Miscellaneous.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.*;

import java.io.*;
import java.net.URL;
import java.util.*;

public class CalculateStatisticsGUI implements Initializable {


    @FXML
    private BorderPane borderPane;

    @FXML
    private TabPane tabPaneMain;

    @FXML
    private Button btBack;

    @FXML
    private Tab tabClient, tabProducer, tabHub;

    @FXML
    private TabPane tPaneBasketOrder, tPaneClient, tPaneProducer, tPaneHub;

    @FXML
    private Tab tbAdvanceBasketOrder, tbAdvanceClient, tbAdvanceProducer, tbAdvanceHub;

    @FXML
    private Button btShowMoreBasketOrder, btShowMoreClient, btShowMoreProducer, btShowMoreHub;

    // Basket Order
    @FXML
    private ComboBox<String> cBoxBasketOrder;

    @FXML
    private TableView<BasketOrderHelper> tableViewBasketOrder;

    @FXML
    private TableColumn<BasketOrderHelper, String> tcProdsTotallySatisfied, tcProdsPartiallySatisfied, tcProdsNotSatisfied, tcPercentageSatisfaction, tcNrProducersPerBasket;

    @FXML
    private BarChart<String, Number> bChartProdsTotallySatisfied, bChartProdsPartiallySatisfied, bChartProdsNotSatisfied, bChartPercentageSatisfaction, bChartNrProducersPerBasket;

    // Client
    @FXML
    private ComboBox<String> cBoxClient;

    @FXML
    private TableView<ClientHelper> tableViewClient;

    @FXML
    private TableColumn<ClientHelper, String> tcBasketTotallySatisfiedClient, tcBasketPartiallySatisfiedClient, tcNrProducers;

    @FXML
    private BarChart<String, Number> bChartBasketTotallySatisfiedClient, bChartBasketPartiallySatisfiedClient, bChartNrProducers;

    // Producer
    @FXML
    private ComboBox<String> cBoxProducer;

    @FXML
    private TableView<ProducerHelper> tableViewProducer;

    @FXML
    private TableColumn<ProducerHelper, String> tcBasketTotallySatisfiedProducer, tcBasketPartiallySatisfiedProducer, tcNrClients, tcNrProdsSoldOut, tcNrSuppliedHubs;

    @FXML
    private BarChart<String, Number> bChartBasketTotallySatisfiedProducer, bChartBasketPartiallySatisfiedProducer, bChartNrClients, bChartNrProdsSoldOut, bChartNrSuppliedHubs;

    // Hub
    @FXML
    private ComboBox<String> cBoxHub;

    @FXML
    private TableView<HubHelper> tableViewHub;

    @FXML
    private TableColumn<HubHelper, String> tcNrClientesPerHub, tcNrProducersPerHub;

    @FXML
    private BarChart<String, Number> bChartNrClientesPerHub, bChartNrProducersPerHubr;

    @FXML
    private HBox hBoxBar;

    // Bottom hBox
    @FXML
    private HBox hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight;

    // Bottom Buttons
    @FXML
    private Button btProfile, btHome, btSettings;

    private final CalculateStatisticsController controller = new CalculateStatisticsController();
    private List<BasketOrderStatistics> basketOrderList;
    private Collection<ClientStatistics> clientList;
    private Collection<ProducerStatistics> producerList;
    private Collection<HubStatistics> hubList;

    private boolean lotsOfData = false;

    // This booleans are responsible to check whether the user has already seen a certain tab
    // TODO explain this
    private boolean isBasketOrder, isClient, isProducer, isHub;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Sets the responsiveness into the bottom bar - Center the items
        borderPane.widthProperty().addListener(e -> {
            CommonsGUI.setResponsiveness(borderPane, hBoxBar, hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight, btProfile, btHome, btSettings);
        });

        btBack.setOnAction(e -> {
            try {
                CommonsGUI.toChooseDispatchListGUI(e, false, "CalculateStatisticsGUI");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Button bar Button's actions
        CommonsGUI.setBarButtons(btHome, btProfile, btSettings);

        // Basket Order's caption
        btShowMoreBasketOrder.setOnMouseEntered(Me -> showMoreFactory("BasketOrder"));
        btShowMoreBasketOrder.setOnMouseExited(e -> {
            CommonsGUI.closePopUpWindow(borderPane);
        });

        // Client's caption
        btShowMoreClient.setOnMouseEntered(Me -> showMoreFactory("Client"));
        btShowMoreClient.setOnMouseExited(e -> {
            CommonsGUI.closePopUpWindow(borderPane);
        });

        // Producer's caption
        btShowMoreProducer.setOnMouseEntered(Me -> showMoreFactory("Producer"));
        btShowMoreProducer.setOnMouseExited(e -> {
            CommonsGUI.closePopUpWindow(borderPane);
        });

        // Hub's caption
        btShowMoreHub.setOnMouseEntered(Me -> showMoreFactory("Hub"));
        btShowMoreHub.setOnMouseExited(e -> {
            CommonsGUI.closePopUpWindow(borderPane);
        });

        // Initialize the booleans - false by default
        isBasketOrder = false; isClient = false; isProducer = false; isHub = false;

        // Detect the tab change - The data is only loaded when the user clicks on the tab
        tabPaneMain.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
            if (tabClient.equals(newTab))
                setInfoFactory("Client", isClient);

            else if (tabProducer.equals(newTab))
                setInfoFactory("Producer", isProducer);

            else if (tabHub.equals(newTab))
                setInfoFactory("Hub", isHub);
        });


        // Detect the tab change - The data is only loaded when the user clicks on the tab - Warning the user this funcionalities might not be working properly
        tPaneBasketOrder.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
            if (tbAdvanceBasketOrder.equals(newTab) && lotsOfData)
                advancedSettingsAlert();
        });

        tPaneClient.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
            if (tbAdvanceClient.equals(newTab) && lotsOfData)
                advancedSettingsAlert();
        });

        tPaneProducer.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
            if (tbAdvanceProducer.equals(newTab) && lotsOfData)
                advancedSettingsAlert();
        });

        tPaneHub.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
            if (tbAdvanceHub.equals(newTab) && lotsOfData)
                advancedSettingsAlert();
        });


        // When an item from the combo box is selected, it will highlight the corresponding row on the table
        // Basket Order
        cBoxBasketOrder.setOnAction(event -> {
            highlightRow(tableViewBasketOrder, cBoxBasketOrder);
        });

        // Client
        cBoxClient.setOnAction(event -> {
            highlightRow(tableViewClient, cBoxClient);
        });

        // Producer
        cBoxProducer.setOnAction(event -> {
            highlightRow(tableViewProducer, cBoxProducer);
        });

        // Hub
        cBoxHub.setOnAction(event -> {
            highlightRow(tableViewHub, cBoxHub);
        });
    }

    /**
     * This method is responsible to set the information once the user clicks enters on the US
     */
    public void setInfo(List<BasketOrder> dispatchList) {
        // Calculates all the stats
        controller.calculateStatistics(dispatchList);
        if (dispatchList.size() > 30)
            lotsOfData = true;

        // Getting the results and associating them to the corresponding lists
        basketOrderList = controller.getBasketOrderStatistics();
        clientList = controller.getClientStatistics();
        producerList = controller.getProducerStatistics();
        hubList = controller.getHubStatistics();

        // Basket Order is the first tab to be loaded
        setInfoFactory("BasketOrder", isBasketOrder);
    }


    /**
     * Sets the basket order statistics - TableView
     */
    private void setBasketOrderList() {
        ObservableList<BasketOrderHelper> basketOrderObservableList = FXCollections.observableArrayList();

        int basketOrderCounter = 1;
        for (BasketOrderStatistics stats : basketOrderList) {
            basketOrderObservableList.add(new BasketOrderHelper(basketOrderCounter, stats.getNrProdsTotallySatisfied(), stats.getNrProdsPartiallySatisfied(), stats.getNrProdsNotSatisfied(), stats.getPercentageOfSatisfaction(), stats.getNrProducers()));
            cBoxBasketOrder.getItems().add(String.valueOf(basketOrderCounter));
            basketOrderCounter++;
        }

        tcProdsTotallySatisfied.setCellValueFactory(new PropertyValueFactory<>("totalSatisfied"));
        tcProdsPartiallySatisfied.setCellValueFactory(new PropertyValueFactory<>("partiallySatisfied"));
        tcProdsNotSatisfied.setCellValueFactory(new PropertyValueFactory<>("notSatisfied"));
        tcPercentageSatisfaction.setCellValueFactory(new PropertyValueFactory<>("percentageSatisfaction"));
        tcNrProducersPerBasket.setCellValueFactory(new PropertyValueFactory<>("nrProducers"));

        tableViewBasketOrder.setItems(basketOrderObservableList);
    }

    /**
     * Sets the basket order statistics - Bar Chart
     */
    public void setBasketOrderBarChart() {
        int basketCounter = 0;
        for (BasketOrderStatistics stats : basketOrderList) {
            basketCounter++;
            XYChart.Series<String, Number> totallySatisfied = new XYChart.Series<>();
            XYChart.Series<String, Number> parciallySatisfied = new XYChart.Series<>();
            XYChart.Series<String, Number> notSatisfied = new XYChart.Series<>();
            XYChart.Series<String, Number> percentageSatisfaction = new XYChart.Series<>();
            XYChart.Series<String, Number> nrProducers = new XYChart.Series<>();

            totallySatisfied.setName(String.valueOf(basketCounter));
            parciallySatisfied.setName(String.valueOf(basketCounter));
            notSatisfied.setName(String.valueOf(basketCounter));
            percentageSatisfaction.setName(String.valueOf(basketCounter));
            nrProducers.setName(String.valueOf(basketCounter));

            totallySatisfied.getData().add(new XYChart.Data<>("Nr Totally Satisfied", stats.getNrProdsTotallySatisfied()));
            parciallySatisfied.getData().add(new XYChart.Data<>("Nr Parcially Satisfied", stats.getNrProdsPartiallySatisfied()));
            notSatisfied.getData().add(new XYChart.Data<>("Nr Not Satisfied", stats.getNrProdsNotSatisfied()));
            percentageSatisfaction.getData().add(new XYChart.Data<>("Nr Parcially Satisfied", stats.getPercentageOfSatisfaction()));
            nrProducers.getData().add(new XYChart.Data<>("Nr Not Satisfied", stats.getNrProducers()));
            bChartProdsTotallySatisfied.getData().add(totallySatisfied);
            bChartProdsPartiallySatisfied.getData().add(parciallySatisfied);
            bChartProdsNotSatisfied.getData().add(notSatisfied);
            bChartPercentageSatisfaction.getData().add(percentageSatisfaction);
            bChartNrProducersPerBasket.getData().add(nrProducers);
        }
    }

    /**
     * Sets the client statistics - TableView
     */
    private void setClientList() {
        ObservableList<ClientHelper> clientObservableList = FXCollections.observableArrayList();

        for (ClientStatistics stats : clientList) {
            clientObservableList.add(new ClientHelper(stats.getClient().getClientId(), stats.getNrBasketOrdersTotallySatisfied(), stats.getNrBasketOrdersPartiallySatisfied(), stats.getNrProducers()));
        }

        tcBasketTotallySatisfiedClient.setCellValueFactory(new PropertyValueFactory<>("totalSatisfied"));
        tcBasketPartiallySatisfiedClient.setCellValueFactory(new PropertyValueFactory<>("partiallySatisfied"));
        tcNrProducers.setCellValueFactory(new PropertyValueFactory<>("nrProducers"));

        tableViewClient.setItems(clientObservableList);
    }

    /**
     * Sets the client statistics - BarChart
     */
    private void setClientBarChart() {
        Set<Client> clients = new HashSet<>();
        for (ClientStatistics stats : clientList) {
            clients.add(stats.getClient());
            XYChart.Series<String, Number> totallySatisfied = new XYChart.Series<>();
            XYChart.Series<String, Number> parciallySatisfied = new XYChart.Series<>();
            XYChart.Series<String, Number> nrProducers = new XYChart.Series<>();

            totallySatisfied.setName(String.valueOf(stats.getClient()));
            parciallySatisfied.setName(String.valueOf(stats.getClient()));
            nrProducers.setName(String.valueOf(stats.getClient()));

            totallySatisfied.getData().add(new XYChart.Data<>("Nr Totally Satisfied", stats.getNrBasketOrdersTotallySatisfied()));
            parciallySatisfied.getData().add(new XYChart.Data<>("Nr Parcially Satisfied", stats.getNrBasketOrdersPartiallySatisfied()));
            nrProducers.getData().add(new XYChart.Data<>("Nr Not Satisfied", stats.getNrProducers()));
            bChartBasketTotallySatisfiedClient.getData().add(totallySatisfied);
            bChartBasketPartiallySatisfiedClient.getData().add(parciallySatisfied);
            bChartNrProducers.getData().add(nrProducers);
        }
        ObservableList<String> clientObservableList = FXCollections.observableArrayList();
        for (Client client : clients)
            clientObservableList.add(client.toString());

        cBoxClient.setItems(clientObservableList);
    }

    /**
     * Sets the producer statistics - TableView
     */
    private void setProducerList() {
        ObservableList<ProducerHelper> producerObservableList = FXCollections.observableArrayList();

        for (ProducerStatistics stats : producerList) {
            producerObservableList.add(new ProducerHelper(stats.getProducer().getProducerId(), stats.getNrBasketOrdersTotallySatisfied(), stats.getNrBasketOrdersPartiallySatisfied(), stats.getNrClients(), stats.getNrProdsSoldOut(), stats.getNrSuppliedHubs()));
        }

        tcBasketTotallySatisfiedProducer.setCellValueFactory(new PropertyValueFactory<>("totalSatisfied"));
        tcBasketPartiallySatisfiedProducer.setCellValueFactory(new PropertyValueFactory<>("partiallySatisfied"));
        tcNrClients.setCellValueFactory(new PropertyValueFactory<>("nrClients"));
        tcNrProdsSoldOut.setCellValueFactory(new PropertyValueFactory<>("nrProdsSoldOut"));
        tcNrSuppliedHubs.setCellValueFactory(new PropertyValueFactory<>("nrSuppliedHubs"));

        tableViewProducer.setItems(producerObservableList);
    }

    /**
     * Sets the client statistics - BarChart
     */
    private void setProducerBarChart() {
        Set<Producer> producers = new HashSet<>();
        for (ProducerStatistics stats : producerList) {
            producers.add(stats.getProducer());

            XYChart.Series<String, Number> totallySatisfied = new XYChart.Series<>();
            XYChart.Series<String, Number> parciallySatisfied = new XYChart.Series<>();
            XYChart.Series<String, Number> nrClients = new XYChart.Series<>();
            XYChart.Series<String, Number> nrProdsSoldOut = new XYChart.Series<>();
            XYChart.Series<String, Number> nrSuppliedHubs = new XYChart.Series<>();

            totallySatisfied.setName(String.valueOf(stats.getProducer()));
            parciallySatisfied.setName(String.valueOf(stats.getProducer()));
            nrClients.setName(String.valueOf(stats.getProducer()));
            nrProdsSoldOut.setName(String.valueOf(stats.getProducer()));
            nrSuppliedHubs.setName(String.valueOf(stats.getProducer()));

            totallySatisfied.getData().add(new XYChart.Data<>("Nr Totally Satisfied", stats.getNrBasketOrdersTotallySatisfied()));
            parciallySatisfied.getData().add(new XYChart.Data<>("Nr Parcially Satisfied", stats.getNrBasketOrdersPartiallySatisfied()));
            nrClients.getData().add(new XYChart.Data<>("Nr Not Satisfied", stats.getNrClients()));
            nrProdsSoldOut.getData().add(new XYChart.Data<>("Nr Not Satisfied", stats.getNrProdsSoldOut()));
            nrSuppliedHubs.getData().add(new XYChart.Data<>("Nr Not Satisfied", stats.getNrSuppliedHubs()));
            bChartBasketTotallySatisfiedProducer.getData().add(totallySatisfied);
            bChartBasketPartiallySatisfiedProducer.getData().add(parciallySatisfied);
            bChartNrClients.getData().add(nrClients);
            bChartNrProdsSoldOut.getData().add(nrProdsSoldOut);
            bChartNrSuppliedHubs.getData().add(nrSuppliedHubs);
        }
        ObservableList<String> producerObservableList = FXCollections.observableArrayList();
        for (Producer producer : producers)
            producerObservableList.add(producer.toString());

        cBoxProducer.setItems(producerObservableList);
    }

    /**
     * Sets the hub statistics - TableView
     */
    private void setHubList() {
        ObservableList<HubHelper> hubObservableList = FXCollections.observableArrayList();

        for (HubStatistics stats : hubList) {
            hubObservableList.add(new HubHelper(stats.getHub(), stats.getNrClients(), stats.getNrProducers()));
        }

        tcNrClientesPerHub.setCellValueFactory(new PropertyValueFactory<>("nrClients"));
        tcNrProducersPerHub.setCellValueFactory(new PropertyValueFactory<>("nrProducers"));

        tableViewHub.setItems(hubObservableList);
    }

    /**
     * Sets the hub statistics - BarChart
     */
    private void setHubBarChart() {
        Set<String> hubs = new HashSet<>();
        for (HubStatistics stats : hubList) {
            hubs.add(stats.getHub());

            XYChart.Series<String, Number> nrClients = new XYChart.Series<>();
            XYChart.Series<String, Number> nrProducers = new XYChart.Series<>();

            nrClients.setName(String.valueOf(stats.getHub()));
            nrProducers.setName(String.valueOf(stats.getHub()));

            nrClients.getData().add(new XYChart.Data<>("Nr Clients", stats.getNrClients()));
            nrProducers.getData().add(new XYChart.Data<>("Nr Producers", stats.getNrProducers()));

            bChartNrClientesPerHub.getData().add(nrClients);
            bChartNrProducersPerHubr.getData().add(nrProducers);
        }
        ObservableList<String> hubObservableList = FXCollections.observableArrayList();
        hubObservableList.addAll(hubs);

        cBoxHub.setItems(hubObservableList);
    }


    /**
     * Factory method for setting the statistics
     */
    public void setInfoFactory(String role, boolean isLoaded) {

        switch (role) {
            case "BasketOrder":
                if (!isLoaded) {
                    setBasketOrderList();
                    setBasketOrderBarChart();
                    isBasketOrder = true;
                }
                break;

            case "Client":
                if (!isLoaded) {
                    setClientList();
                    setClientBarChart();
                    isClient = true;
                }
                break;

            case "Producer":
                if (!isLoaded) {
                    setProducerList();
                    setProducerBarChart();
                    isProducer = true;
                }
                break;

            case "Hub":
                // TODO implement the methods
                if (!isLoaded) {
                    setHubList();
                    setHubBarChart();
                    isHub = true;
                }
                break;
        }
    }

    /**
     * This method is responsible to set an information alert to the user - Warning the user this funcionalities might not be working properly
     */
    private void advancedSettingsAlert() {
        CommonsGUI.showAlert(Alert.AlertType.INFORMATION, "Advanced Settings", "As a load of data was loaded, this funcionaltity might be working properly. We are sorry for the inconvenience.");
    }


    /**
     * This method is responsible to set the information displayed when clicking on the eye button (showing information about the statistics)
     */
    private void showMoreFactory(String type) {
        Text caption;

        switch (type) {
            case "BasketOrder" -> {
                caption = new Text("""
        The following table shows the statistics of the baskets orders.
        These statistics are:
        
        TS - Number of Products Totally Satisfied
        PS - Number of Products Partially Satisfied
        NS - Number of Products Not Satisfied
        %S - Percentage of Satisfaction
        NP - Number of Different Producers per Basket
        """);
                showMore("Basket Order Caption", caption, new Image("images/basketOrder.png"));
            }

            case "Client" -> {
                caption = new Text("""
        The following table shows the statistics of the clients.
        These statistics are:
        
        TS - Number of Basket Orders Totally Satisfied
        PS - Number of Basket Orders Partially Satisfied
        NP - Number of Different Producers that contribute to the Client's Basket Orders
        """);
                showMore("Client Caption", caption, new Image("images/client.png"));
            }

            case "Producer" -> {
                caption = new Text("""
        The following table shows the statistics of the producers.
        These statistics are:
        
        TS - Number of Basket Orders Totally Satisfied
        PS - Number of Basket Orders Partially Satisfied
        NP - Number of Different Producers that contribute to the Client's Basket Orders
        NP - Number of Products Sold Out
        NH - Number of Hubs Supplied
        """);
                showMore("Producer Caption", caption, new Image("Images/farmer.png"));
            }

            case "Hub" -> {
                caption = new Text("""
        The following table shows the statistics of the hubs.
        These statistics are:
        
        NC - Number of Clients per Hub
        NP - Number of Producers per Hub
        """);
                showMore("Hub Caption", caption, new Image("images/hub.png"));
            }
        }
    }

    /**
     * This method is responsible to open the window with the information about the statistics
     */
    private void showMore(String title, Text caption, Image image) {

        try {
            CommonsGUI.openPopUpWindowInfoForSubtitle("Caption", title, caption, image, btShowMoreBasketOrder.getScaleX(), btShowMoreBasketOrder.getTranslateY());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is responsible to highlight the selected row in the table
     */
    private void highlightRow(TableView<?> tableView, ComboBox<?> comboBox) {
        String selectedItem = (String) comboBox.getSelectionModel().getSelectedItem();
        for (int i = 0; i < tableView.getItems().size(); i++) {
            if (tableView.getItems().get(i).toString().equals(selectedItem)) {
                tableView.requestFocus();
                tableView.getSelectionModel().select(i);
                tableView.scrollTo(i);
                break;
            }
        }
    }
}