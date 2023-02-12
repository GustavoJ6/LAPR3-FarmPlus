package GUI.Screens;

import Controller.*;
import DTO.DijkstraObjectDTO;
import Domain.DistributionNetwork;
import Domain.Participants.*;
import Domain.Products.*;
import GUI.Components.*;
import Utils.Constants;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.geometry.Point2D;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class ExpeditionListMinimizedPathGUI implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private HBox hBoxBar;

    @FXML
    private Button btBack;

    // Bottom hBox
    @FXML
    private HBox hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight;

    @FXML
    private TableView<RoutesHelper> tvRoutes;

    @FXML
    private TableColumn<RoutesHelper, String> tcOrigin, tcDestination, tcDistance;

    @FXML
    private TableView<BasketHubHelper> tvHubs;

    @FXML
    private TableColumn<BasketHubHelper, String> tcHub, tcNumber;

    // Not sure se aqui não vai dar asneira, maybe será mais fácil de usar String e depois fazer a conexão através do id do producer
    @FXML
    private ComboBox<String> cBoxProducers;

    // Bottom Buttons
    @FXML
    private Button btProfile, btHome, btSettings;

    private Producer producer;

    private Map<List<List<DijkstraObjectDTO<Participant, Double>>>, List<Double>> pathsAndDistances;

    private final DistributionNetwork distributionNetwork = App.getInstance().getSystemData().getDistributionNetwork();

    private final ExpeditionListMinimizedPathController controller = new ExpeditionListMinimizedPathController();
    private Point2D point;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Sets the responsivenss into the bottom bar - Center the items
        borderPane.widthProperty().addListener(e -> {
            CommonsGUI.setResponsiveness(borderPane, hBoxBar, hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight, btProfile, btHome, btSettings);
        });

        CommonsGUI.setBarButtons(btHome, btProfile, btSettings);

        btBack.setOnAction(e -> {
            try {
                CommonsGUI.toChooseDispatchListGUI(e, true, "Minimized Path");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // onAction for the ComboBox
        cBoxProducers.setOnAction(this::updateInfo);

        // onHover of the TableView's row
        tvRoutes.setRowFactory(this::method);
    }

    private TableRow<RoutesHelper> method(TableView<RoutesHelper> routesHelperTableView) {
        final TableRow<RoutesHelper> row = new TableRow<>();

        // onHover of the TableView's row
        row.setOnMouseEntered(event -> {
            point = row.localToScreen(0, 0);
            try {
                if (row.getItem() != null)
                    setRoute(row.getItem(), point);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        row.setOnMouseExited(event -> {
            CommonsGUI.closeRoute();
        });

        return row;
    }

    /**
     * Updates the information of the TableView
     *
     * @param event - ActionEvent
     */
    private void updateInfo(ActionEvent event) {
        cBoxProducers.setDisable(true);
        producer = (Producer) distributionNetwork.getParticipantByID(cBoxProducers.getValue());
        setInfo();
    }

    /**
     * Sets the info of the TableView
     */
    public void setInfo() {

        // Gets the paths and distances
        ObservableList<RoutesHelper> routesObservableList = FXCollections.observableArrayList();

        // Gets the paths and distances from the controller and sets the TableView
        Map<List<List<DijkstraObjectDTO<Participant, Double>>>, List<Double>> paths = controller.returnMinimizedPath(producer.getParticipantId());
        pathsAndDistances = paths;
        List<Double> distances = null;
        for (Map.Entry<List<List<DijkstraObjectDTO<Participant, Double>>>, List<Double>> entry : pathsAndDistances.entrySet()) {
            String origin = new String();
            String destination = new String();

            List<List<DijkstraObjectDTO<Participant, Double>>> pathAndDistances = entry.getKey();
            distances = entry.getValue();

            int pathIndex = 1;
            for (List<DijkstraObjectDTO<Participant, Double>> path : pathAndDistances) {
                for (int position = 0; position < path.size(); position++) {
                    if (position == 0) {
                        origin = path.get(position).getKey().getParticipantId();
                    } else if (position == path.size() - 1) {
                        destination = path.get(position).getKey().getParticipantId();
                    }
                }
                pathIndex++;
                routesObservableList.add(new RoutesHelper(origin, destination, distances.get(pathIndex - 2).toString() + "m"));
            }
        }

        // Sets the TableView with the total distance
        routesObservableList.add(new RoutesHelper("Total", "Total", String.valueOf(distances.stream().mapToDouble(Double::doubleValue).sum()) + "m"));

        tcOrigin.setCellValueFactory(new PropertyValueFactory<>("vOrigin"));
        tcDestination.setCellValueFactory(new PropertyValueFactory<>("vDestination"));
        tcDistance.setCellValueFactory(new PropertyValueFactory<>("distanceRoute"));
        tvRoutes.setItems(routesObservableList);

        ObservableList<BasketHubHelper> hubsObservableList = FXCollections.observableArrayList();
        Map<String, Integer> basketsDroppedPerHub = controller.getBasketsDroppedPerHub();
        for (Map.Entry<String, Integer> entry : basketsDroppedPerHub.entrySet()) {
            hubsObservableList.add(new BasketHubHelper(entry.getKey(), entry.getValue()));
        }

        tcHub.setCellValueFactory(new PropertyValueFactory<>("hub"));
        tcNumber.setCellValueFactory(new PropertyValueFactory<>("nrDroppedBaskets"));
        tvHubs.setItems(hubsObservableList);
    }

    /**
     * Sets producers list.
     *
     * @param dispatchListP the dispatch list p
     * @param restricted    the restricted
     */
    public void setProducersList(List<BasketOrder> dispatchListP, boolean restricted) {
        // Lista a substituir
        controller.setProducersList(dispatchListP.get(0).getDay(), restricted);
        cBoxProducers.getItems().addAll(controller.getProducersFromExpeditionList());
    }

    private void setRoute(RoutesHelper item, Point2D point) throws IOException {
        // Sets the route
        String originDestination = new String();
        String allPath = new String();
        for (List<List<DijkstraObjectDTO<Participant, Double>>> path : pathsAndDistances.keySet()) {
            for (List<DijkstraObjectDTO<Participant, Double>> p : path) {
                if (p.get(0).getKey().getParticipantId().equals(item.getVOrigin()) && p.get(p.size() - 1).getKey().getParticipantId().equals(item.getVDestination())) {
                    originDestination = p.get(0).getKey().getParticipantId() + " - " + p.get(p.size() - 1).getKey().getParticipantId();
                    for (DijkstraObjectDTO<Participant, Double> d : p) {
                        allPath += d.getKey().getParticipantId() + " - ";
                    }
                    allPath = allPath.substring(0, allPath.length() - 3);
                }
            }
        }

        CommonsGUI.setRoute(allPath, originDestination, point);
    }
}