package Controller;

import Domain.*;
import Domain.Products.*;
import GUI.Screens.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

import java.io.*;
import java.util.*;

public class ChooseDispatchedListController {

    private final DistributionNetworkData data;
    private List<BasketOrder> dispatchList;

    private boolean restricted;

    public ChooseDispatchedListController() {
        this.data = App.getInstance().getSystemData();
    }

    /**
     * Sets simple dispatch list.
     *
     * @param cBoxDispatchList the c box dispatch list
     */
    public void setSimpleDispatchList(ComboBox<String> cBoxDispatchList) {
        for (int i = 0; i < data.getSimpleDispatchLists().size(); i++) {
            cBoxDispatchList.getItems().add("Simple List - Day " + (i + 1));
        }
    }

    /**
     * Sets restrictions dispatch list.
     *
     * @param cBoxDispatchList the c box dispatch list
     */
    public void setRestrictionsDispatchList(ComboBox<String> cBoxDispatchList) {
        for (int i = 0; i < data.getDispatchListsWithRestrictions().size(); i++) {
            cBoxDispatchList.getItems().add("Restriction List - Day " + (i + 1));
        }
    }

    /**
     * Sets dispatch list.
     *
     * @param cBoxDispatchList the c box dispatch list
     */
    public void setDispatchList(ComboBox<String> cBoxDispatchList) {
        String choosenList = cBoxDispatchList.getSelectionModel().getSelectedItem();
        // Gets the index of the chosen item
        int index = Integer.parseInt(choosenList.substring(choosenList.length() - 1));
        if (choosenList.contains("Simple")) {
            dispatchList = data.getSimpleDispatchLists().get(index - 1);
            restricted = false;
        } else {
            dispatchList = data.getDispatchListsWithRestrictions().get(index - 1);
            restricted = true;
        }
    }

    public void cleanComboBox(ComboBox<String> cBoxDispatchList) {
        cBoxDispatchList.getItems().clear();
    }

    public void toExpeditionListMinimizedPathGUI(ActionEvent event) throws IOException {
        Parent root;
        FXMLLoader loader;
        if (App.getInstance().desktopMode)
            loader = new FXMLLoader(getClass().getResource("/fxml/Desktop/expeditionListMinimizedPathDesktop.fxml"));
        else
            loader = new FXMLLoader(getClass().getResource("/fxml/expeditionListMinimizedPath.fxml"));
        root = loader.load();

        ExpeditionListMinimizedPathGUI nextSceneUi = loader.getController();
        nextSceneUi.setProducersList(dispatchList, restricted);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * To calculate statistics page.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    public void toCalculateStatisticsPage(ActionEvent event) throws IOException {
        Parent root;
        FXMLLoader loader;
        if (App.getInstance().desktopMode)
            loader = new FXMLLoader(getClass().getResource("/fxml/Desktop/statisticsPageDesktop.fxml"));
        else
            loader = new FXMLLoader(getClass().getResource("/fxml/statisticsPage.fxml"));
        root = loader.load();

        CalculateStatisticsGUI nextSceneUi = loader.getController();
        nextSceneUi.setInfo(dispatchList);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
