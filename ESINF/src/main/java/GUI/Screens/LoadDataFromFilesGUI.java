package GUI.Screens;

import Controller.*;
import Functionalities.*;
import GUI.Components.CommonsGUI;
import Utils.Constants;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class LoadDataFromFilesGUI implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private HBox hBoxBar;

    // Bottom hBox
    @FXML
    private HBox hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight;

    @FXML
    private Button btBack;

    // Load Data HBox
    @FXML
    private HBox hBoxDistributionNetwork, hBoxProducts, hBoxWateringPlan;

    // Load Data Buttons
    @FXML
    private Button btDistributionNetwork, btProducts, btWateringPlan;

    // Load Data Dots Buttons
    @FXML
    private Button btDotsDistributionNetwork, btDotsProducts, btDotsWateringPlan;

    // Bottom Buttons
    @FXML
    private Button btProfile, btHome, btSettings;

    // Indicates what automatic file is going to be loaded
    // This field should be an enum, and it can have the following values: 1 - Distribution Network, 2 - Products, 3 - Watering Plan
    private int typeOfFile;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Making it Responsive
        borderPane.widthProperty().addListener(e ->
                CommonsGUI.setResponsiveness(borderPane, hBoxBar, hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight, btProfile, btHome, btSettings));

        // Defining the Home's button's action
        btBack.setOnAction(e -> {
            try {
                CommonsGUI.homeEsinf(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Check if there is a Distribution Network loaded
        btProducts.setDisable(!App.getInstance().loadedData.get(1));

        // Load Distribution Network
        btDistributionNetwork.setOnAction(e -> {
            typeOfFile = 1;
            chooseWayToLoadFile();
        });

        // Dots' Buttons
        btDotsDistributionNetwork.setOnAction(e -> {
            try {
                Text info = new Text();
                info.setText("""
                        The Distribution Network data consists of two different concepts:
                        1. The Nodes, corresponding to the Participants,
                        being them Clients (Particulars and Companies) and Producers.
                        2. The Edges, corresponding to the routes connecting them.
                                                
                        So, in order to load information about the Distribution Network, you must provide two files.
                                                
                        1. The first file must contain the information about the Clients and Producers.
                        Each line must contain an ID, the coordinates of the node and and the name that unmistakably identifies it.
                        The file must be in the following format (example):
                        Loc id,lat,lng,Clientes-Produtores
                        CT1,40.6389,-8.6553,C1
                        CT2,38.0333,-7.8833,C2
                        CT3,41.5333,-8.4167,C3
                                                
                        The first line is mandatory. It identifies the type of the file.
                        The lines that follow must follow that format -> ID,Latitude,Longitude,Name
                                                
                        2. The second file must contain the information about the Edges.
                        Each line must contain two names previously declared and the distance between them.
                        The file must be in the following format (example):
                        Loc id 1,Loc id 2, length (m)
                        CT10,CT13,63448
                        CT10,CT6,67584
                        CT10,CT1,110848
                                                
                        The first line is mandatory. It identifies the type of the file.
                        The lines that follow must follow that format -> Name1,Name2,Distance
                        """);
                CommonsGUI.setPopUpWindowInfo(borderPane, "Distribution Network", "Distribution Network Data", info, new Image("Images/Distribution_Network_Data.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Load Products
        btProducts.setOnAction(e -> {
            typeOfFile = 2;
            chooseWayToLoadFile();
        });
        // Dots' Buttons
        btDotsProducts.setOnAction(e -> {
            try {
                Text info = new Text();
                info.setText("""
                        The products file consists of the orders that the clients ask for and the products that the
                        producers provide on a given day.
                                                
                        In order to load information about the Products, you must first load the Distribution Network.
                        Then, you must provide a file with the information about the Products and Orders.
                                                
                        The file must be in the following format (example):
                        "Clientes-Produtores","Dia","Prod1","Prod2","Prod3","Prod4","Prod5"
                        "C1",1,0,0,0,0,5
                        "C2",1,0,5.5,4.5,0,4
                        "C3",1,10,0,0,0,9
                        """);
                CommonsGUI.setPopUpWindowInfo(borderPane, "Products and Orders", "Products and Orders Data", info, new Image("Images/Products_Data.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Load Watering Plan
        btWateringPlan.setOnAction(e -> {
            typeOfFile = 3;
            chooseWayToLoadFile();
        });

        // Dots' Buttons
        btDotsWateringPlan.setOnAction(e -> {
            try {
                Text info = new Text();
                info.setText("""
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
                                        
                        • 't' - all the days
                        • 'i' - odd days
                        • 'p' - even days

                        Here's an example:
                        14:00,17:00
                        a,10,t
                        b,12,p
                        c,12,i
                        """);

                CommonsGUI.setPopUpWindowInfo(borderPane, "Watering Plan", "Watering Plan Data", info, new Image("Images/Watering_Plan_Data.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Defining the Button Bar Button's actions
        CommonsGUI.setBarButtons(btHome, btProfile, btSettings);
    }

    private void chooseWayToLoadFile() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Type of File");
        alert.setHeaderText("Choose the type of file do you want to load?");

        ButtonType automatic = new ButtonType("Automatic");
        ButtonType manually = new ButtonType("Manually");
        ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(automatic, manually, cancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == automatic) {
            boolean isBigFile;
            if (typeOfFile != 3) {
                isBigFile = isSizeOfFileBig();
            } else {
                isBigFile = true;
            }
            if (!wasOperationCanceled) {
                loadNetworkDataAutomatic(isBigFile);
            }


        } else if (result.get() == manually) {
            try {
                loadNetworkDataManually();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            alert.close();
        }
    }

    // This is a bad implementation, but it works
    private boolean wasOperationCanceled;

    private boolean isSizeOfFileBig() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Size of File");
        alert.setHeaderText("Do you want to load Small or Big file(s)?");

        ButtonType small = new ButtonType("Small");
        ButtonType big = new ButtonType("Big");
        ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(small, big, cancel);
        Optional<ButtonType> result = alert.showAndWait();
        wasOperationCanceled = result.get() == cancel;

        return result.get() == big;
    }

    private void loadNetworkDataAutomatic(boolean isBigFile) {
        switch (typeOfFile) {
            case 1 -> loadDistributionNetworkAutomatic(isBigFile);
            case 2 -> loadProductsAutomatic(isBigFile);
            case 3 -> loadWateringPlanAutomatic();
        }
    }

    private void loadWateringPlanAutomatic() {
        if (loadWateringPlan(Constants.PATH_TO_FILE_WATERING_PLANS)) {
            App.getInstance().loadedData.put(typeOfFile, true);
            CommonsGUI.showAlert(Alert.AlertType.INFORMATION, "Success", "Watering Plan Data Loaded Successfully!");
        }
    }

    private void loadProductsAutomatic(boolean isBigFile) {
        if (isBigFile) {
            if (loadProducts(Constants.PATH_TO_BIG_FILE_PRODUCTS)) {
                App.getInstance().loadedData.put(typeOfFile, true);
                CommonsGUI.showAlert(Alert.AlertType.INFORMATION, "Success", "The Products Data was loaded successfully!");
            } else {
                alertErrorAutomatic();
            }
        } else {
            if (loadProducts(Constants.PATH_TO_SMALL_FILE_PRODUCTS)) {
                App.getInstance().loadedData.put(typeOfFile, true);
                CommonsGUI.showAlert(Alert.AlertType.INFORMATION, "Success", "The Products Data was loaded successfully!");
            } else {
                alertErrorAutomatic();
            }
        }
    }

    private void loadDistributionNetworkAutomatic(boolean isBigFile) {
        boolean isLoaded = false;
        if (isBigFile) {
            if (loadParticipants(Constants.PATH_TO_BIG_FILE_VERTICES) && loadRoutes(Constants.PATH_TO_BIG_FILE_DISTANCES)) {
                App.getInstance().loadedData.put(typeOfFile, true);
                printSuccessMessage();
                isLoaded = true;
            } else {
                alertErrorAutomatic();
            }
        } else {
            if (loadParticipants(Constants.PATH_TO_SMALL_FILE_VERTICES) && loadRoutes(Constants.PATH_TO_SMALL_FILE_DISTANCES)) {
                App.getInstance().loadedData.put(typeOfFile, true);
                printSuccessMessage();
                isLoaded = true;
            } else {
                alertErrorAutomatic();
            }
        }
        if (isLoaded) {
            btProducts.setDisable(false);
        }
    }

    private void loadNetworkDataManually() throws IOException {
        // Distribution Network
        if (typeOfFile == 1) {
            // Loading network alert
            CommonsGUI.showAlert(Alert.AlertType.INFORMATION, "Loading the Network", "Please, load the Participants file first and then the Routes file!");

            // Choosing the Participants file path
            String fileParticipantsPath = getFileFromFileDirectory();
            // Checking result
            if (fileParticipantsPath != null) {
                if (!loadParticipants(fileParticipantsPath)) {
                    alertErrorManually();
                    return;
                }
            } else {
                return;
            }
            alertSuccess();

            // Choosing the routes file path
            String fileRoutesPath = getFileFromFileDirectory();
            if (!loadRoutes(fileRoutesPath)) {
                alertErrorManually();
                return;
            }

            App.getInstance().loadedData.put(typeOfFile, true);
            printSuccessMessage();

            btProducts.setDisable(false);
        }
        // Products
        else if (typeOfFile == 2) {
            // Choosing the Products file
            String fileProductsPath = getFileFromFileDirectory();

            if (!loadProducts(fileProductsPath)) {
                alertErrorManually();
                return;
            }

            App.getInstance().loadedData.put(typeOfFile, true);
            alertSuccess();
        }

        // Watering Plan
        else {
            // Choosing the Watering Plan file
            String fileWateringPlanPath = getFileFromFileDirectory();

            if (!loadWateringPlan(fileWateringPlanPath)) {
                alertErrorManually();
                return;
            }

            App.getInstance().loadedData.put(typeOfFile, true);
            alertSuccess();
        }
    }

    private void printSuccessMessage() {
        if (App.getInstance().loadedData.get(2)) {
            CommonsGUI.showAlert(Alert.AlertType.INFORMATION, "Loading the Distribution Network", "The Distribution Network was loaded successfully!\nThe Products from the previous network were deleted!");
        }else{
            alertSuccess();
        }
    }

    private boolean loadWateringPlan(String fileWateringPlanPath) {
        WateringPlanReader wateringPlanReader = new WateringPlanReader();
        return wateringPlanReader.readFromFile(fileWateringPlanPath);
    }

    private boolean loadProducts(String fileProductsPath) {
        ProductsFileReader productsFileReader = new ProductsFileReader();
        return productsFileReader.readFromFile(fileProductsPath);
    }

    private boolean loadParticipants(String path) {
        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        return participantsFileReader.readFromFile(path);
    }

    private boolean loadRoutes(String path) {
        RoutesFileReader routesFileReader = new RoutesFileReader();
        return routesFileReader.readFromFile(path);
    }

    private String getFileFromFileDirectory() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(Constants.PATH_TO_DATA_TO_LOAD));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.txt", "*.csv"));
        // Only return if not null
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            return file.getPath();
        }
        return null;

    }

    // Alert Success - Informs the User that the file was loaded successfully
    private void alertSuccess() {
        CommonsGUI.showAlert(Alert.AlertType.INFORMATION, "Success", "The file was loaded successfully!");
    }

    // Alert Error - Informs the User that the file was not loaded successfully (Manually)
    private void alertErrorManually() {
        CommonsGUI.showAlert(Alert.AlertType.ERROR, "Error", "The selected file is invalid. Try again!");
    }

    // Alert Error - Informs the User that the file was not loaded successfully (Automatic)
    private void alertErrorAutomatic() {
        CommonsGUI.showAlert(Alert.AlertType.ERROR, "Error", "Something went wrong loading the file(s) automatically. Please use the manual option or try again.");
    }
}
