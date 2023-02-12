package GUI.Screens;

import Controller.App;
import Controller.GenerateDispatchListController;
import Domain.Products.BasketOrder;
import GUI.Components.CommonsGUI;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class GenerateDispatchListsMenuGUI {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button btBack, btGenerateList, btHome, btProfile, btSettings;

    @FXML
    private ComboBox<CommonsGUI.TypeOfList> cbTypeOfList;

    @FXML
    private HBox hBoxBar, hBoxBar1, hBoxBar2, hBoxLeft, hBoxRight, hBoxVert1, hBoxVert2;

    @FXML
    private TextField txtDayList, txtNumberOfProducers;

    private CommonsGUI.TypeOfList typeOfList;

    private final GenerateDispatchListController generateDispatchListController = new GenerateDispatchListController();

    public void initialize() {
        // BOTTOM BAR
        borderPane.widthProperty().addListener(e -> {
            CommonsGUI.setResponsiveness(borderPane, hBoxBar, hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight, btProfile, btHome, btSettings);
        });
        // BACK BUTTON
        btBack.setOnAction(e -> {
            try {
                CommonsGUI.homeEsinf(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Allows the user to press enter
        btGenerateList.setDefaultButton(true);

        // SET COMBOBOX
        cbTypeOfList.setItems(FXCollections.observableArrayList(CommonsGUI.TypeOfList.values()));

        cbTypeOfList.setOnAction(this::cbTypeOfListActionFactory);

        // Defining the Button Bar Button's actions
        CommonsGUI.setBarButtons(btHome, btProfile, btSettings);
    }

    private void cbTypeOfListActionFactory(ActionEvent actionEvent) {
        switch (cbTypeOfList.getValue()) {
            case Simple -> cbTypeOfListActionSimple();
            case ClosestHub -> cbTypeOfListActionClosestHub();
        }
    }

    private void cbTypeOfListActionSimple() {
        typeOfList = CommonsGUI.TypeOfList.Simple;
        txtDayList.setVisible(true);
        txtNumberOfProducers.setVisible(false);
        btGenerateList.setVisible(true);
    }

    private void cbTypeOfListActionClosestHub() {
        if (!App.getInstance().isThereAnyHubDefined()){
            CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Hubs", "Please define the hubs first!");
            return;
        }

        typeOfList = CommonsGUI.TypeOfList.ClosestHub;
        txtDayList.setVisible(true);
        txtNumberOfProducers.setVisible(true);
        btGenerateList.setVisible(true);
    }


    @FXML
    void generateBtnListFactory(ActionEvent event) {
        switch (typeOfList) {
            case Simple -> generateListSimple(event);
            case ClosestHub -> generateListClosestHub(event);
        }
    }

    private void generateListSimple(ActionEvent event) {
        String day = txtDayList.getText();
        if (!checkIntInput(day, "Day")) {
            return;
        }

        if (!generateDispatchListController.areThereOrdersForDay(Integer.parseInt(day))){
            CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Orders", "There are no orders for the day " + day);
            return;
        }

        String title = "Simple Dispatch List";
        List<BasketOrder> dispatchList = generateDispatchListController.generateSimpleDispatchList(Integer.parseInt(day));

        if (dispatchList == null){
            CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Orders", "There are no products available to fulfill the orders for the day " + day);
            return;
        }

        try {
            toGenerateDispatchListGUI(dispatchList, title, event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void generateListClosestHub(ActionEvent event) {

        String day = txtDayList.getText();
        if (!checkIntInput(day, "Day")) {
            return;
        }
        String numberOfProducers = txtNumberOfProducers.getText();
        if (!checkIntInput(numberOfProducers, "Number of Producers")) {
            return;
        }


        List<BasketOrder> dispatchList = generateDispatchListController.getDispatchListWithRestrictionsOfDayIfAlreadyExists(Integer.parseInt(day));

        if (dispatchList == null){
            if (!generateDispatchListController.areThereOrdersForDay(Integer.parseInt(day))){
                CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Orders", "There are no orders for the day " + day);
                return;
            }

            // Check if there are n producers
            if (!generateDispatchListController.areThereNProducersInTheNetwork(Integer.parseInt(numberOfProducers))){
                CommonsGUI.showAlert(Alert.AlertType.ERROR, "Not Enough Producers", "There are not " + numberOfProducers + " producers in the network!");
                return;
            }

            dispatchList = generateDispatchListController.generateDispatchListWithRestrictions(Integer.parseInt(day), Integer.parseInt(numberOfProducers));

            if (dispatchList == null){
                CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Products", "There are no products available to fulfill the orders for the day " + day);
                return;
            }

        }else{
            CommonsGUI.showAlert(Alert.AlertType.INFORMATION, "Dispatch List Already Generated", "A closest hub dispatch list was already generated for the day " + day + ". If you are trying to" +
                    " generate a new one, please change the day. The previous one will be shown." +
                    "\n" +
                    "Another workaround is to delete the data of the Distribution Network, and start again, by loading all the files, defining the hubs and generating the dispatch list.");
        }

        String title = "Closest Hub Dispatch List";
        try {
            toGenerateDispatchListGUI(dispatchList, title, event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void toGenerateDispatchListGUI(List<BasketOrder> dispatchList, String title, ActionEvent event) throws IOException {
        Parent root;
        FXMLLoader loader;
        if (App.getInstance().desktopMode)
            loader = new FXMLLoader(getClass().getResource("/fxml/Desktop/generateDispatchListOutDesktop.fxml"));
        else
            loader = new FXMLLoader(getClass().getResource("/fxml/generateDispatchListOut.fxml"));
        root = loader.load();

        GenerateDispatchListGUI nextSceneUi = loader.getController();
        nextSceneUi.setInfo(dispatchList, title);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private boolean checkIntInput(String integer, String field) {
        try {
            Integer.parseInt(integer);
        } catch (NumberFormatException ex) {
            CommonsGUI.showAlert(Alert.AlertType.ERROR, "Error in the input", "The %s must be a number".formatted(field));
            return false;
        }
        return true;
    }

}
