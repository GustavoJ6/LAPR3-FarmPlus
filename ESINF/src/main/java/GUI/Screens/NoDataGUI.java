package GUI.Screens;

import Controller.*;
import GUI.Components.CommonsGUI;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class NoDataGUI implements Initializable{


    @FXML
    private BorderPane borderPane;

    @FXML
    private HBox hBoxBar;

    // Bottom hBox
    @FXML
    private HBox hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight;

    // Bottom Buttons
    @FXML
    private Button btProfile, btHome, btSettings;

    @FXML
    private Button btLoadData;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Sets the responsiveness into the bottom bar - Center the items
        borderPane.widthProperty().addListener(e -> {
            CommonsGUI.setResponsiveness(borderPane, hBoxBar, hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight, btProfile, btHome, btSettings);
        });

        btLoadData.setOnAction(e -> {
            try {
                toLoadData(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        CommonsGUI.setBarButtons(btHome, btProfile, btSettings);
    }

    private void toLoadData(ActionEvent event) throws IOException {
        Parent root;
        FXMLLoader loader;
        if (App.getInstance().desktopMode)
            loader = new FXMLLoader(getClass().getResource("/fxml/Desktop/loadDataFromFilesDesktop.fxml"));
        else
            loader = new FXMLLoader(getClass().getResource("/fxml/loadDataFromFiles.fxml"));
        root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
