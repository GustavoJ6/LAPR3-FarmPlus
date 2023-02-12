package GUI.Components;

import Controller.App;
import GUI.Screens.*;
import Utils.Constants;
import javafx.event.*;
import javafx.fxml.*;
import javafx.geometry.Point2D;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

import java.io.*;

public class CommonsGUI {

    private static Stage subtitleStage;
    private static Stage routeStage;

    public enum TypeOfList {
        Simple, ClosestHub
    }

    /**
     * Sends the user to the home page.
     * Verifying if the user is in desktop mode or not and verifying if there is data in the system
     */
    public static void homeEsinf(ActionEvent event) throws IOException {
        Parent root;
        Stage stage;
        if (App.getInstance().desktopMode) {
            if (dataInSystem()) {
                root = FXMLLoader.load(CommonsGUI.class.getResource("/fxml/Desktop/mainPageDesktop.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            } else {
                root = FXMLLoader.load(CommonsGUI.class.getResource("/fxml/Desktop/noDataDesktop.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            }
        } else if (dataInSystem()) {
            root = FXMLLoader.load(CommonsGUI.class.getResource("/fxml/mainPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        } else {
            root = FXMLLoader.load(CommonsGUI.class.getResource("/fxml/noData.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        }
        stage.setTitle(Constants.APP_NAME);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Sends the user to the profile page.
     * Verifying if the user is in desktop mode or not.
     */
    public static void toProfileGUI(ActionEvent event) throws IOException {
        Parent root;
        if (App.getInstance().desktopMode)
            root = FXMLLoader.load(CommonsGUI.class.getResource("/fxml/Desktop/profileDesktop.fxml"));
        else
            root = FXMLLoader.load(CommonsGUI.class.getResource("/fxml/profile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        scene.getWindow().centerOnScreen();
        stage.show();
    }

    /**
     * Sends the user to the settings page.
     * Verifying if the user is in desktop mode or not.
     */
    public static void toSettingsGUI(ActionEvent event) throws IOException {
        Parent root;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ;
        if (App.getInstance().desktopMode)
            root = FXMLLoader.load(CommonsGUI.class.getResource("/fxml/Desktop/settingsDesktop.fxml"));
        else
            root = FXMLLoader.load(CommonsGUI.class.getResource("/fxml/settings.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        scene.getWindow().centerOnScreen();
        stage.show();
    }

    /**
     * Sends the user to the settings page.
     * Verifying if the user is in desktop mode or not.
     */
    public static void toLoginGUI(ActionEvent event) throws IOException {
        Parent root;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ;
        if (App.getInstance().desktopMode)
            root = FXMLLoader.load(CommonsGUI.class.getResource("/fxml/Desktop/loginDesktop.fxml"));
        else
            root = FXMLLoader.load(CommonsGUI.class.getResource("/fxml/login.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle(Constants.APP_NAME);
        stage.setScene(scene);
        scene.getWindow().centerOnScreen();
        stage.show();
    }

    /**
     * Sends the user to the page where a dispatch list is choosen.
     * Verifying if the user is in desktop mode or not.
     */
    public static void toChooseDispatchListGUI(ActionEvent event, boolean us310, String buttonName) throws IOException {
        Parent root;
        FXMLLoader loader;
        if (App.getInstance().desktopMode)
            loader = new FXMLLoader(CommonsGUI.class.getResource("/fxml/Desktop/chooseDispatchListDesktop.fxml"));
        else
            loader = new FXMLLoader(CommonsGUI.class.getResource("/fxml/chooseDispatchList.fxml"));
        root = loader.load();

        ChooseDispatchedListGUI nextSceneUi = loader.getController();
        nextSceneUi.setInfo(us310, buttonName);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * Sets the pop-up window info.
     *
     * @param title the title
     * @param info  the info describing the pop-up window
     * @throws IOException the io exception
     */
    public static void setPopUpWindowInfo(BorderPane borderPane, String stageTitle, String title, Text info, Image image) throws IOException {
        // Disables the main window
        borderPane.setDisable(true);
        Stage popUpWindowStage = new Stage();
        Parent root;
        FXMLLoader loader = new FXMLLoader(CommonsGUI.class.getResource("/fxml/popUpWindow.fxml"));
        root = loader.load();

        PopUpWindowGUI nextScene = loader.getController();
        nextScene.setInfo(title, info, image);

        Scene popScene = new Scene(root);
        popUpWindowStage.setTitle(stageTitle);
        popUpWindowStage.setScene(popScene);
        popUpWindowStage.setResizable(false);
        popUpWindowStage.centerOnScreen();
        popUpWindowStage.show();

        // When the pop-up window is closed, the main window is enabled again
        popUpWindowStage.setOnCloseRequest(closeEvent -> borderPane.setDisable(false));
    }

    /**
     * Sets the pop-up window info.
     *
     * @param title the title
     * @param info  the info describing the pop-up window
     * @throws IOException the io exception
     */
    public static void openPopUpWindowInfoForSubtitle(String stageTitle, String title, Text info, Image image, double x, double y) throws IOException {
        // Disables the main window
        subtitleStage = new Stage();
        Parent root;
        FXMLLoader loader = new FXMLLoader(CommonsGUI.class.getResource("/fxml/popUpWindow.fxml"));
        root = loader.load();

        PopUpWindowGUI nextScene = loader.getController();
        nextScene.setInfo(title, info, image);

        Scene popScene = new Scene(root);
        subtitleStage.setTitle(stageTitle);
        subtitleStage.setScene(popScene);
        subtitleStage.setResizable(false);
        subtitleStage.setX(x);
        subtitleStage.setY(y);
        subtitleStage.show();
    }

    /**
     * Closes the pop-up window.
     */
    public static void closePopUpWindow(BorderPane borderPane) {
        borderPane.setDisable(false);
        subtitleStage.close();
    }

    public static void toDotsPopUpWindow(BorderPane borderPane, String stageTitle, String dataToLoad) throws IOException {
        // Disables the main window
        borderPane.setDisable(true);

        Stage dotsStage = new Stage();
        Parent root;
        FXMLLoader loader = new FXMLLoader(CommonsGUI.class.getResource("/fxml/dotsPopUpWindow.fxml"));
        root = loader.load();

        DotsPopUpWindowGUI nextScene = loader.getController();
        nextScene.setInfo(dataToLoad);
        Scene popScene = new Scene(root);
        dotsStage.setTitle(stageTitle);
        dotsStage.setScene(popScene);
        dotsStage.setResizable(false);
        dotsStage.centerOnScreen();
        dotsStage.show();

        // When the pop-up window is closed, the main window is enabled again
        dotsStage.setOnCloseRequest(closeEvent -> borderPane.setDisable(false));
    }

    public static void setRoute(String originDestination, String route, Point2D point) throws IOException {
        routeStage = new Stage();

        Parent root;
        FXMLLoader loader = new FXMLLoader(CommonsGUI.class.getResource("/fxml/route.fxml"));
        root = loader.load();

        RouteGUI nextScene = loader.getController();
        nextScene.setInfo(originDestination, route);

        Scene popScene = new Scene(root);
        routeStage.setTitle("Route");
        routeStage.setScene(popScene);
        routeStage.setResizable(false);
        routeStage.setX(point.getX() - 250);
        routeStage.setY(point.getY() - 200);
        routeStage.show();
    }

    public static void closeRoute() {
        routeStage.close();
    }

    public static void setResponsiveness(BorderPane borderPane, HBox hBoxBar, HBox hBoxVert1, HBox hBoxVert2, HBox hBoxLeft, HBox hBoxRight, Button btProfile, Button btHome, Button btSettings) {
        // Making it Responsive
        double width = 0.5 * borderPane.getWidth();
        hBoxBar.setPrefWidth(0.9 * borderPane.getWidth());
        hBoxVert1.setPrefWidth(width);
        hBoxVert2.setPrefWidth(width);
        hBoxLeft.setPrefWidth(0.4 * borderPane.getWidth());
        hBoxRight.setPrefWidth(0.4 * borderPane.getWidth());

        btProfile.setPrefWidth(width);
        btHome.setPrefWidth(width);
        btSettings.setPrefWidth(width);
    }

    /**
     * Method that checks if there is data in the system
     *
     * @return true if there is data in the system, false otherwise
     */
    public static boolean dataInSystem() {
        return App.getInstance().loadedData.get(1) || App.getInstance().loadedData.get(2) || App.getInstance().loadedData.get(3);
    }

    public static void setBarButtons(Button btHome, Button btProfile, Button btSettings) {
        // Defining the Home's button's action
        btHome.setOnAction(e -> {
            try {
                CommonsGUI.homeEsinf(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Defining the Profile's button's action
        btProfile.setOnAction(e -> {
            try {
                CommonsGUI.toProfileGUI(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Defining the Setting's button's action
        btSettings.setOnAction(e -> {
            try {
                CommonsGUI.toSettingsGUI(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    public static Text wateringPlanText =
            new Text("""
                    The data in this file is in the form of a list of watering intervals
                    and the corresponding parcels that will be watered during each interval.
                    Each watering time represents a start time.
                    The start time is in the format HH:MM, where HH is the hour in 24-hour
                    format and MM is the minute.
                                
                    Following the various start times there's a list of parcels
                    that will be watered,
                    along with the duration of watering for each parcel
                                
                    Each parcel is represented by a name, the duration of watering in minutes
                    and the regularity of the watering.
                    The duration of watering is represented by an integer and the
                    regularity is represented by 3 options:
                        
                    • 't' - todos os dias
                    • 'i' - dias ímpares
                    • 'p' - dias pares

                    Here's an example:
                    14:00,17:00
                    a,10,t
                    b,12,p
                    c,12,i
                    """);

    public static Text productsText = new Text("""
            The products file consisted of the orders that the clients ask for and the products that the producers provided on a given day.
                    
            The file must be in the following format (example):
            "Clientes-Produtores","Dia","Prod1","Prod2","Prod3","Prod4","Prod5"
            "C1",1,0,0,0,0,5
            "C2",1,0,5.5,4.5,0,4
            "C3",1,10,0,0,0,9
            """);

    public static Text distributinNetworkText = new Text("""
            The Distribution Network data consists of two different concepts:
            1. The Nodes, corresponding to Clients (Particular and Companies) and Producers
            2. The Edges, corresponding to the Routes connecting them
                    
            So, in order to load information about the Distribution Network, you must provide two files.
                    
            1. The first file must contain the information about the Clients and Producers.
            Each line must contain an ID, the coordinates of the node and and the name that unmistakably identifies it.
            The file must be in the following format (example):
            Loc id,lat,lng,Clientes-Produtores
            CT1,40.6389,-8.6553,C1
            CT2,38.0333,-7.8833,C2
            CT3,41.5333,-8.4167,C3
                    
            The first file is mandatory. This line identifies the type of the file.
            The lines that follow must follow that format -> ID,Latitude,Longitude,Name
                    
            2. The second file must contain the information about the Edges.
            Each line must contain two names previously declared and the distance between them.
            The file must be in the following format (example):
            Loc id 1,Loc id 2, length (m)
            CT10,CT13,63448
            CT10,CT6,67584
            CT10,CT1,110848
                    
            The first file is mandatory. This line identifies the type of the file.
            The lines that follow must follow that format -> Name1,Name2,Distance
            """);

    public static void showAlert(Alert.AlertType typeOfAlert, String Title, String text) {
        Alert alert = new Alert(typeOfAlert);
        alert.setTitle(Title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}

