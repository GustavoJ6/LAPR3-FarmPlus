package GUI.Screens;

import Controller.*;
import GUI.Components.CommonsGUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ChooseDispatchedListGUI implements Initializable {


    @FXML
    private BorderPane borderPane;

    @FXML
    private Button btBack;

    @FXML
    private ComboBox<String> cBoxTypeList, cBoxDispatchList;

    @FXML
    private HBox hBoxBar;

    // Bottom hBox
    @FXML
    private HBox hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight;

    // Bottom Buttons
    @FXML
    private Button btProfile, btHome, btSettings;

    @FXML
    private Button button;

    private ChooseDispatchedListController controller;
    private boolean us310;
    private boolean setUp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = new ChooseDispatchedListController();

        // Sets the responsiveness into the bottom bar - Center the items
        borderPane.widthProperty().addListener(e -> {
            CommonsGUI.setResponsiveness(borderPane, hBoxBar, hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight, btProfile, btHome, btSettings);
        });

        setUp = false;

        btBack.setOnAction(e -> {
            try {
                CommonsGUI.homeEsinf(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        button.setOnAction(e -> {
            // Checking whether an item was chosen both in the type and the dispatch list
            if (cBoxDispatchList.getSelectionModel().isEmpty() || cBoxTypeList.getSelectionModel().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Not enough information");
                alert.setContentText("Please select both the type and the dispatch List");
                alert.showAndWait();
            } else {
                try {
                    if (us310)
                        controller.toExpeditionListMinimizedPathGUI(e);
                    else
                        controller.toCalculateStatisticsPage(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

        button.setDefaultButton(true);

        // Setting on Action when selecting an item from the comboBox
        cBoxTypeList.setOnAction(e -> {
            cBoxDispatchList.setDisable(false);

            switch (cBoxTypeList.getSelectionModel().getSelectedItem()) {
                case "Simple" -> {
                    controller.setSimpleDispatchList(cBoxDispatchList);
                }

                case "With Restrictions" -> {
                    controller.setRestrictionsDispatchList(cBoxDispatchList);
                }
            }
        });

        // cBoxDispatchList setOnAction
        cBoxDispatchList.setOnAction(e -> {
            if (setUp)
                controller.cleanComboBox(cBoxDispatchList);

            controller.setDispatchList(cBoxDispatchList);
        });

        CommonsGUI.setBarButtons(btHome, btProfile, btSettings);
    }


    public void setInfo(boolean us310, String buttonText) {
        this.us310 = us310;
        cBoxDispatchList.setDisable(true);

        List<String> typeDispatchList = new ArrayList<>();
        typeDispatchList.add("Simple");
        typeDispatchList.add("With Restrictions");

        ObservableList<String> observableList = FXCollections.observableArrayList(typeDispatchList);
        cBoxTypeList.setItems(observableList);

        button.setText(buttonText);
    }
}
