package GUI.Screens;

import Controller.ConnectionNetworkController;
import Domain.Graph.KruskalObject;
import Domain.Participants.Participant;
import GUI.Components.CommonsGUI;
import GUI.Components.ConnectionsNetworkHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class ConnectionNetworkGUI implements Initializable {


    @FXML
    private BorderPane borderPane;

    @FXML
    private HBox hBoxBar;

    @FXML
    private HBox hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight;

    @FXML
    private TableView<ConnectionsNetworkHelper> tableView;

    @FXML
    private TableColumn<ConnectionsNetworkHelper, String> tcNumber;

    @FXML
    private TableColumn<ConnectionsNetworkHelper, String> tcEdge;

    @FXML
    private TableColumn<ConnectionsNetworkHelper, String> tcDistance;

    @FXML
    private Button btBack;

    @FXML
    private Button btProfile, btHome, btSettings;

    private ConnectionNetworkController controller;

    public void setController(ConnectionNetworkController controller) {
        this.controller = controller;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Sets the responsiveness into the bottom bar - Center the items
        borderPane.widthProperty().addListener(e -> {
            CommonsGUI.setResponsiveness(borderPane, hBoxBar, hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight, btProfile, btHome, btSettings);
        });


        // Defining the Back's button's action
        btBack.setOnAction(e -> {
            try {
                CommonsGUI.homeEsinf(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        // Defining the Button Bar Button's actions
        CommonsGUI.setBarButtons(btHome, btProfile, btSettings);
    }

    public void setInfo() {
        List<KruskalObject<Participant, Double>> listToFillObservableList = controller.runKruskalAlgorithmGUI();
        ObservableList<ConnectionsNetworkHelper> observableList = FXCollections.observableArrayList();

        if (listToFillObservableList.isEmpty()) {
            observableList.add(new ConnectionsNetworkHelper("No connections", "No connections", "No connections"));
        } else {
            int counter = 0;
            for (KruskalObject<Participant, Double> kruskalObject : listToFillObservableList) {
                observableList.add(new ConnectionsNetworkHelper(String.valueOf(counter), "(" + kruskalObject.getvOrig().toString() + "-" + kruskalObject.getvDest().toString() + ")", kruskalObject.getWeight().toString() + "m"));
                counter++;
            }

            observableList.add(new ConnectionsNetworkHelper("Total", "Total", String.valueOf(listToFillObservableList.stream().mapToDouble(KruskalObject::getWeight).sum()) + "m"));
        }

        tcNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        tcEdge.setCellValueFactory(new PropertyValueFactory<>("edge"));
        tcDistance.setCellValueFactory(new PropertyValueFactory<>("weight"));

        tableView.setItems(observableList);
    }

}
