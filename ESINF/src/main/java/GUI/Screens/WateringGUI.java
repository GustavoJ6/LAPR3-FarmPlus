package GUI.Screens;

import Controller.*;
import GUI.Components.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class WateringGUI implements Initializable{


    @FXML
    private BorderPane borderPane;

    @FXML
    private HBox hBoxBar;

    // Buttom bar
    @FXML
    private HBox hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight;

    @FXML
    private TableView<WateringPlanHelper> tableView;

    @FXML
    private TableColumn<WateringPlanHelper, String> tcParcel;

    @FXML
    private TableColumn<WateringPlanHelper, String> tcTimeLeft;

    @FXML
    private Button btBack;

    // Buttom Buttons
    @FXML
    private Button btProfile, btHome, btSettings;

    private WateringController controller;

    public void setController(WateringController controller) {
        this.controller = controller;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Sets the responsivenss into the bottom bar - Center the items
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
        Map<String, Integer> parcelsTime = controller.watering();
        ObservableList<WateringPlanHelper> statsList = FXCollections.observableArrayList();

        if (parcelsTime.isEmpty())
            statsList.add(new WateringPlanHelper("No parcels", "Being Watered"));
        else
            for (Map.Entry<String, Integer> entry : parcelsTime.entrySet())
                statsList.add(new WateringPlanHelper(entry.getKey(), entry.getValue().toString()));



        tcParcel.setCellValueFactory(new PropertyValueFactory<>("parcel"));
        tcTimeLeft.setCellValueFactory(new PropertyValueFactory<>("timeLeft"));
        tableView.setItems(statsList);

    }
}
