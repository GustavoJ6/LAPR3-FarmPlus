package GUI.Screens;

import Controller.DefineHubsController;
import GUI.Components.CommonsGUI;
import GUI.Components.DefineHubsHelper;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class DefineNHubsGUI implements Initializable {


    @FXML
    private BorderPane borderPane;

    @FXML
    private HBox hBoxBar;

    @FXML
    private HBox hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight;

    @FXML
    private TableView<DefineHubsHelper> tableView;

    @FXML
    private TableColumn<DefineHubsHelper, String> tcNumberHub;

    @FXML
    private TableColumn<DefineHubsHelper, String> tcHub;

    @FXML
    private Button btBack;

    @FXML
    private Button btDefine;

    @FXML
    private Button btProfile, btHome, btSettings;

    @FXML
    private TextField txtNumberHubs;

    private final DefineHubsController controller = new DefineHubsController();

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

        // Defining the Defines button's action
        btDefine.setOnAction(this::defineHubs);
        // Allows the user to press enter to define the hubs
        btDefine.setDefaultButton(true);

        // Defining the Button Bar Button's actions
        CommonsGUI.setBarButtons(btHome, btProfile, btSettings);
    }

    private void defineHubs(ActionEvent e) {
        try {
            int numberHubs = Integer.parseInt(txtNumberHubs.getText());

            if (controller.isNumberOfHubsValid(numberHubs)) {

                List<String> hubsList = controller.getHubs(numberHubs);

                if (hubsList.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("No Hubs were determined");
                    alert.setContentText("Something went wrong defining the hubs, please try again!");
                    alert.showAndWait();
                } else {

                    setInfo(hubsList);

                }
            } else {
                int numOfCompanies = controller.getNumOfCompanies();
                CommonsGUI.showAlert(Alert.AlertType.ERROR, "Invalid number of hubs", "Number of hubs must be between 1 and " + numOfCompanies);
            }

        } catch (NumberFormatException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid number of hubs");
            alert.setContentText("Input must be a number");
            alert.showAndWait();
        }
    }

    public void setInfo(List<String> hubsList) {
        ObservableList<DefineHubsHelper> observableList = FXCollections.observableArrayList();
        int number = 1;
        for (String hub : hubsList) {
            observableList.add(new DefineHubsHelper(number, hub));
            number++;
        }

        tcNumberHub.setCellValueFactory(new PropertyValueFactory<>("Number"));
        tcHub.setCellValueFactory(new PropertyValueFactory<>("Hub"));

        tableView.setItems(observableList);
    }

}
