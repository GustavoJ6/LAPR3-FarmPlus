package GUI.Screens;

import com.jfoenix.controls.JFXToggleButton;
import Controller.App;
import GUI.Components.CommonsGUI;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class SettingsGUI implements Initializable{


    @FXML
    private BorderPane borderPane;

    @FXML
    private HBox hBoxBar, hBoxBar1;

    // Button hBox
    @FXML
    private HBox hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight;

    @FXML
    private JFXToggleButton toggle;

    // Button Buttons
    @FXML
    private Button btProfile, btHome, btSettings;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Sets the responsiveness into the bottom bar - Center the items
        borderPane.widthProperty().addListener(e -> {
            CommonsGUI.setResponsiveness(borderPane, hBoxBar, hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight, btProfile, btHome, btSettings);
        });

        // Detecting if the toggle was previously on or off, in order to set it to the same state
        toggle.setSelected(App.getInstance().desktopMode);

        toggle.setOnAction(e -> {
            App.getInstance().desktopMode = toggle.isSelected();
            try {
                CommonsGUI.toSettingsGUI(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Defining the Button Bar Button's actions
        CommonsGUI.setBarButtons(btHome, btProfile, btSettings);
    }
}
