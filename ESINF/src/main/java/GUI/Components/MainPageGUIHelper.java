package GUI.Components;

import Controller.*;
import GUI.Screens.*;
import javafx.animation.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.*;

public class MainPageGUIHelper {

    private static ImageView imageView;
    private static Timeline timeline;
    private static Stage loadingStage;
    private static Stage dotsPopUpWindow;

    public void toLoadDataFromFilesGUI(ActionEvent event) throws IOException {
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

    public void toMostDistantPairOfVerticesGUI(ActionEvent event) throws IOException {
        Parent root;
        FXMLLoader loader;
        if (App.getInstance().desktopMode)
            loader = new FXMLLoader(getClass().getResource("/fxml/Desktop/mostDistantPairOfVerticesDesktop.fxml"));
        else
            loader = new FXMLLoader(getClass().getResource("/fxml/mostDistantPairOfVertices.fxml"));
        root = loader.load();

        MostDistantPairOfVerticesGUI nextSceneUi = loader.getController();
        //startLoadingAnimation();
        nextSceneUi.setController(new MostDistantPairOfVerticesController());
        nextSceneUi.setInfo();
        //stopLoadingAnimation();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toDefineNHubsGUI(ActionEvent event) throws IOException {
        Parent root;
        FXMLLoader loader;
        if (App.getInstance().desktopMode)
            loader = new FXMLLoader(getClass().getResource("/fxml/Desktop/defineNHubsDesktop.fxml"));
        else
            loader = new FXMLLoader(getClass().getResource("/fxml/defineNHubs.fxml"));
        root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toFindNearestHubGUI(ActionEvent event) throws IOException {
        Parent root;
        FXMLLoader loader;
        if (App.getInstance().desktopMode)
            loader = new FXMLLoader(getClass().getResource("/fxml/Desktop/findNearestHubDesktop.fxml"));
        else
            loader = new FXMLLoader(getClass().getResource("/fxml/findNearestHub.fxml"));
        root = loader.load();

        FindNearestHubGUI nextSceneUi = loader.getController();
        nextSceneUi.setController(new FindNearestHubController());
        nextSceneUi.setInfo();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toConnectedNetworkGUI(ActionEvent event) throws IOException {
        Parent root;
        FXMLLoader loader;
        if (App.getInstance().desktopMode)
            loader = new FXMLLoader(getClass().getResource("/fxml/Desktop/connectedNetworkDesktop.fxml"));
        else
            loader = new FXMLLoader(getClass().getResource("/fxml/connectedNetwork.fxml"));
        root = loader.load();

        ConnectionNetworkGUI nextSceneUi = loader.getController();
        nextSceneUi.setController(new ConnectionNetworkController());
        nextSceneUi.setInfo();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toWateringGUI(ActionEvent event) throws IOException {
        Parent root;
        FXMLLoader loader;
        if (App.getInstance().desktopMode)
            loader = new FXMLLoader(getClass().getResource("/fxml/Desktop/wateringDesktop.fxml"));
        else
            loader = new FXMLLoader(getClass().getResource("/fxml/watering.fxml"));
        root = loader.load();

        WateringGUI nextSceneUi = loader.getController();
        nextSceneUi.setController(new WateringController());
        nextSceneUi.setInfo();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toGenerateDispatchListMenuGUI(ActionEvent event) throws IOException {
        Parent root;
        FXMLLoader loader;
        if (App.getInstance().desktopMode)
            loader = new FXMLLoader(getClass().getResource("/fxml/Desktop/generateDispatchListsMenuDesktop.fxml"));
        else
            loader = new FXMLLoader(getClass().getResource("/fxml/generateDispatchListsMenu.fxml"));
        root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private static void startLoadingAnimation() throws IOException {
        loadingStage = new Stage();
        Parent root;
        FXMLLoader loader = new FXMLLoader(CommonsGUI.class.getResource("/fxml/loadingAnimation.fxml"));
        root = loader.load();

        Scene loadingScene = new Scene(root);
        loadingStage.setTitle("Loading...");
        loadingStage.setScene(loadingScene);
        loadingStage.setResizable(false);
        loadingStage.show();
    }

    private static void stopLoadingAnimation() {
        loadingStage.hide();
    }

/*    public void toDotsPopUpWindow(BorderPane borderPane, String data) {
        borderPane.setDisable(true);
        dotsPopUpWindow = new Stage();
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(CommonsGUI.class.getResource("/fxml/dotsPopUpWindow.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DotsPopUpWindowGUI nextScene = loader.getController();
        nextScene.setInfo(borderPane, data);

        Scene popScene = new Scene(root);
        dotsPopUpWindow.setTitle("PopUp Window");
        dotsPopUpWindow.setScene(popScene);
        dotsPopUpWindow.setResizable(false);
        dotsPopUpWindow.setX(100);
        dotsPopUpWindow.setY(100);
        dotsPopUpWindow.show();

        // When the pop-up window is closed, the main window is enabled again
        dotsPopUpWindow.setOnCloseRequest(closeEvent -> borderPane.setDisable(false));
    }*/
}
