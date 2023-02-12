package GUI.Screens;

import Controller.FindNearestHubController;
import GUI.Components.CommonsGUI;
import GUI.Components.NearestHubHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class FindNearestHubGUI implements Initializable{
    @FXML
    private BorderPane borderPane;

    @FXML
    private HBox hBoxBar;

    @FXML
    private HBox hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight;

    @FXML
    private TableView<NearestHubHelper> tableView;

    @FXML
    private TableColumn<NearestHubHelper, String> TcClientId;

    @FXML
    private TableColumn<NearestHubHelper, String> TcHubId;

    @FXML
    private Button btBack;

    @FXML
    private Button btProfile, btHome, btSettings;

    private FindNearestHubController controller;

    public void setController(FindNearestHubController controller) {
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
        Map<String, String> nearestHub = controller.getNearestHub();
        ObservableList<NearestHubHelper> nearestHubList = FXCollections.observableArrayList();

            if (!nearestHub.isEmpty()) {
                for (Map.Entry<String, String> entry : nearestHub.entrySet()) {
                    nearestHubList.add(new NearestHubHelper(entry.getKey(), entry.getValue()));
                }
            }
            else {
                nearestHubList.add(new NearestHubHelper("No clients", "No hubs"));
            }
            TcClientId.setCellValueFactory(new PropertyValueFactory<>("clientID"));
            TcHubId.setCellValueFactory(new PropertyValueFactory<>("hubID"));
            tableView.setItems(nearestHubList);
    }
}
