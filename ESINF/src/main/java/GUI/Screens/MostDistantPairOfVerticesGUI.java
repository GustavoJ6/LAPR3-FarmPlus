package GUI.Screens;

import Controller.MostDistantPairOfVerticesController;
import DTO.*;
import Domain.Participants.*;
import GUI.Components.CommonsGUI;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class MostDistantPairOfVerticesGUI implements Initializable {


    @FXML
    private BorderPane borderPane;

    @FXML
    private HBox hBoxBar;

    // Buttom bar
    @FXML
    private HBox hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight;

    @FXML
    private Label lbConnected;

    @FXML
    private Label lbNumberOfConnections;

    @FXML
    private Button btBack;

    // Buttom Buttons
    @FXML
    private Button btProfile, btHome, btSettings;

    private MostDistantPairOfVerticesController controller;

    public void setController(MostDistantPairOfVerticesController controller) {
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


        CommonsGUI.setBarButtons(btHome, btProfile, btSettings);
    }

    public void setInfo() {
        boolean isConnected = controller.isConnected();


        if (isConnected) {
            lbConnected.setText("connected");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            DijkstraObjectDTO<Participant, Double> longest = controller.getLongestPath();

            lbNumberOfConnections.setText(longest.getDistance().toString());
            // This method will be first one to run when this windown is opened
            // Is in the controller that the info will be step up, meaning the TableView
            // Change the parameters as you need, if it's easier, this method can stay here on the java.GUI
            // controller.setInfo(lbConnected, lbNumberOfConnections);
        }
        else {
            lbConnected.setText("not connected");
            lbNumberOfConnections.setText("-");
        }
    }
}
