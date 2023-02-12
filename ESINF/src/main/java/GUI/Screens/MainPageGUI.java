package GUI.Screens;

import Controller.App;
import Domain.DistributionNetwork;
import GUI.Components.CommonsGUI;
import GUI.Components.MainPageGUIHelper;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class MainPageGUI implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private HBox hBoxBar;

    @FXML
    private HBox hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight;
    @FXML
    private Button btProfile, btHome, btSettings;

    // Data bar
    @FXML
    private VBox vBoxProductsData, vBoxDistributionNetworkData, vBoxWateringPlanData;

    // Data Bar
    @FXML
    private Button btDotsDistributionNetwork, btDotsProducts, btDotsWateringPlan;

    // java.Functionalities' Buttons
    @FXML
    private Button btLoadData, btMostDistantPoints, btDefineNHubs, btNearestHub, btConnectedNetwork, btWateringController, btDispatchList, btExpeditionListMinimizedPath, btCalculateStatistics;

    // Dots' Buttons
    @FXML
    private Button btDotsLoadData, btDotsMostDistantPoints, btDotsDefineNHubs, btDotsNearestHub, btDotsConnectedNetwork, btDotsWateringController, btDotsDispatchList, btDotsExpeditionListMinimizedPath, btDotsCalculateStatistics;

    private MainPageGUIHelper helper;

    private final DistributionNetwork distributionNetwork = App.getInstance().getSystemData().getDistributionNetwork();

    private enum userStories {
        LOAD_DATA, MOST_DISTANT_POINTS, DEFINE_N_HUBS, NEAREST_HUB, CONNECTED_NETWORK, WATERING_CONTROLLER, DISPATCH_LIST, EXPEDITION_LIST_MINIMIZED_PATH, CALCULATE_STATISTICS
    }

    public MainPageGUI() {
        // Store this instance in App
        App.getInstance().setMainPageGUI(this);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startupMainPage();

        // DATA IN THE SYSTEM BAR
        btDotsDistributionNetwork.setOnAction(e -> {
            try {
                CommonsGUI.toDotsPopUpWindow(borderPane, "Distribution Network", "DistributionNetwork");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        btDotsProducts.setOnAction(e -> {
            try {
                CommonsGUI.toDotsPopUpWindow(borderPane, "Products and Orders", "Products");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        btDotsWateringPlan.setOnAction(e -> {
            try {
                CommonsGUI.toDotsPopUpWindow(borderPane, "Watering Plan", "WateringPlan");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        // LOADING DATA
        btLoadData.setOnAction(e -> {
            toFunctionalityFactory(e, userStories.LOAD_DATA);
        });
        // Dots
        btDotsLoadData.setOnMouseClicked(event -> {
            try {
                Text info = new Text();
                info.setText("""
                        This functionality of the program is to Load Data from Files.
                        There are 3 possible ways to load files:

                        1. Distribution network
                        - This option allows the user to load data from two CSV
                        files that contain information to build a distribution network.
                                                
                        In this given context, the first file to be loaded (when manually) must be the
                        .csv file that contains the information about the Participants of the network.
                        After that, the user must load the .csv file that contains the information about
                        the Connections between the Participants of the network.
                        For more information consult the eye icon next to the button on the screen of the
                        selection of the type of file to be loaded.

                        2. Products
                        - This option allows the user to load data from a CSV
                        file that contains information about the products being distributed.
                                                
                        In this given context, the file to be loaded (when manually) must be the
                        .csv file that contains the information about the Orders and the Products.
                                            
                        3. Watering Plan
                        - This option allows the user to load data from a TXT or CSV file
                        that contains information about the watering plan for the distribution network.
                                                
                        There is always the option to load the files automatically, from predefined paths,
                        and the possibility for the user to choose the files via a file explorer.

                        Overall, this functionality allows the user to input relevant data
                        into the program from external sources, making it easier to track and
                        manage the distribution network, products, and watering plan.
                        """);
                info.setFont(Font.font(50));
                CommonsGUI.setPopUpWindowInfo(borderPane, "Load Data", "Load Data From Files (US301/US307)", info, new Image("Images/Load_Data_Func.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        // MOST DISTANT POINTS
        btMostDistantPoints.setOnAction(e -> {
            if (isDistributionNetworkDataLoaded()) {
                toFunctionalityFactory(e, userStories.MOST_DISTANT_POINTS);
            } else {
                CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Data in the System", "To use this functionality, you must first load the data of the Distribution Network.");
            }
        });
        // Dots
        btDotsMostDistantPoints.setOnAction(event -> {
            try {
                Text info = new Text();
                info.setText("""
                        The main goals of this functionality are to find out whether the network is connected
                        as well as, the distance between the two points on the Distribution Network
                        that are furthest apart from each other.
                                                
                        To accomplish this, needs to have a Distribution Network loaded into
                        the program. This can be done by using the Load Data functionality.
                                                
                        It then uses the Dijkstra algorithm to calculate the shortest path between all
                        pairs of points in the network.
                        Once the distances have been calculated, the program can then identify
                        the two points with the greatest distance between them and display this information
                        to the user.
                        In addition to the distance between the two points, the program can also indicate
                        whether the network is connected (i.e., whether it is possible to reach any point
                        in the Network from any other point).
                        """);
                CommonsGUI.setPopUpWindowInfo(borderPane, "Most Distant Points", "Most Distant Par of Vertices (US302)", info, new Image("Images/Most_Distant_Points_Func.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        // DEFINE N HUBS
        btDefineNHubs.setOnAction(e -> {
            if (isDistributionNetworkDataLoaded()) {
                toFunctionalityFactory(e, userStories.DEFINE_N_HUBS);
            } else {
                CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Data in the System", "To use this functionality, you must first load the data of the Distribution Network.");
            }
        });
        // Dots
        btDotsDefineNHubs.setOnAction(event -> {
            try {
                Text info = new Text();
                info.setText("""
                        The goal of this functionality is to define the N "hubs" of the Distribution Network.
                         
                        To accomplish this, it is necessary to have a Distribution Network loaded
                        into the program. This can be done by using the Load Data functionality.
                                                
                        The user must then input the number of hubs that they want to define.
                                               
                        In this given context, a Hub is a Company. In order for a Company to be considered
                        a Hub, it must be one of the N that has the shortest average distance to all
                        the other Participants.
                                                
                        """);
                CommonsGUI.setPopUpWindowInfo(borderPane, "Define Hubs", "Define the N Hubs of the Distribution Network (US303)", info, new Image("Images/Define_N_Hubs_Func.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        // THE NEAREST HUBS
        btNearestHub.setOnAction(e -> {
            if (areHubsDefined()) {
                toFunctionalityFactory(e, userStories.NEAREST_HUB);
            } else {
                CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Hubs Defined", "To use this functionality, you must first define the hubs of the Distribution Network.");
            }
        });
        // Dots
        btDotsNearestHub.setOnAction(event -> {
            try {
                Text info = new Text();
                info.setText("""
                        The goal of this functionality is to allow the user to find/determine the Nearest Hub
                        for each client in the Distribution Network.
                            
                        To accomplish this, it is necessary to have a Distribution Network loaded
                        into the program. This can be done by using the Load Data functionality.
                        It is also necessary to have defined the Hubs of the Distribution Network.
                        This can be done by using the Define N Hubs functionality.
                                                
                        When the user clicks on the button, the program will display a table with
                        the information of the Nearest Hub for each client in the Distribution Network.
                        """);
                CommonsGUI.setPopUpWindowInfo(borderPane, "Find Nearest Hub", "Find Nearest Hub of each Client (US304)", info, new Image("Images/Nearest_Point_Func.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        // CONNECTED NETWORK
        btConnectedNetwork.setOnAction(e -> {
            if (isDistributionNetworkDataLoaded()) {
                toFunctionalityFactory(e, userStories.CONNECTED_NETWORK);
            } else {
                CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Data in the System", "To use this functionality, you must first load the data of the Distribution Network.");
            }
        });
        // Dots
        btDotsConnectedNetwork.setOnAction(event -> {

            Text info = new Text();
            info.setText("""
                    The goal of this functionality is to determine the Minimum Network
                    that connects all the Participants of the Network.
                                            
                    To accomplish this, it is necessary to have a Distribution Network loaded
                    into the program. This can be done by using the Load Data functionality.
                                            
                    When the user clicks on the button, the program will display a table with
                    the information of the Minimum Network that connects all the Participants.
                    """);
            try {
                CommonsGUI.setPopUpWindowInfo(borderPane, "Connected Network", "Determine the Minimum connecting all the Participants (US305)", info, new Image("Images/Connected_Network_Func.png"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        // WATERING CONTROLLER
        btWateringController.setOnAction(e -> {
            if (!App.getInstance().isWateringStoreEmpty()) {
                toFunctionalityFactory(e, userStories.WATERING_CONTROLLER);
            } else {
                CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Watering Controller Data", "To use this functionality, you must first load the data of the Watering plans.");
            }
        });
        // Dots
        btDotsWateringController.setOnAction(event -> {
            Text info = new Text();
            info.setText("""
                    The goal of this functionality is to simulate a watering controller.\s
                    To do this, the user must first input a file containing information\s
                    about the watering plan (more information about this file can be\s
                    found in the "Watering Data" button).
                                            
                    Once the necessary information has been inputted, the program\s
                    will use the data from the file to determine which sectors are\s
                    being watered, if any, and how much time is left in the watering process
                    """);
            try {
                CommonsGUI.setPopUpWindowInfo(borderPane, "Watering Controller", "Simulation of a Watering Controller (US306)", info, new Image("Images/Watering_Controller_Func.png"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // DISPATCH LISTS
        btDispatchList.setOnAction(e -> {
            if (isDistributionNetworkDataLoaded() && isProductsDataLoaded())
                toFunctionalityFactory(e, userStories.DISPATCH_LIST);
            else {
                CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Data in the System", "To use this functionality, you must first load the data of the Distribution Network and of the Products and Orders.");
            }
        });
        // Dots
        btDotsDispatchList.setOnAction(event -> {
            {
                Text info = new Text();
                info.setText("""
                        The main goals of this functionality is to generate a dispatch list.
                        It is subdivided into two sub-functionalities:
                        -Generate a "Simple Dispatch List"
                        -Generate a "Closest Hub Dispatch List".
                                                
                        The "Simple Dispatch List" functionality is used to generate a dispatch list
                        without any type of restriction.
                                                
                        The "Closest Hub Dispatch List" functionality is used to generate a dispatch list
                        that prioritizes the N (defined by the user) closest producers to the client's Hub.
                                                
                                                
                        In order to generate a dispatch list, the user must first input information about
                        the distribution network, such as the participants and their locations,
                        the connections between them, the products that are available in the network,
                        and the orders of the network. All this data can be loaded by using the
                        "Load Data" button.
                                                
                        Once the necessary information has been loaded into the system, the user will
                        need to choose the type of dispatch list that they want to generate.
                        The user can choose between the "Simple Dispatch List" and
                        the "Closest Hub Dispatch List".
                                                
                        To generate a simple dispatch list, the user must select a day.
                        To generate a closest hub dispatch list, the user must select a day
                        and the number of producers that they want to consider.
                        """);
                info.setFont(Font.font(50));
                try {
                    CommonsGUI.setPopUpWindowInfo(borderPane, "Generate a Dispatch List", "Generate a Dispatch List (US308/US309)", info, new Image("Images/Watering_Plan_Data.png"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        // EXPEDITION LIST MINIMIZED PATH
        btExpeditionListMinimizedPath.setOnAction(e -> {
            // Hubs not defined
            // Hubs not defined
            if (!areHubsDefined())
                CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Hubs Defined", "To use this functionality, you must first define at least one hub.");
                // No dispatch list generated
            else if (!areThereAnyDispatchLists())
                CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Dispatch Lists", "To use this functionality, you must first generate at least one dispatch list.");
            else if (!App.getInstance().isThereAnyNearestHubDefined())
                CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Nearest Hubs Defined", "To use this functionality, you must first define the clients nearest hubs.");
            else
                toFunctionalityFactory(e, userStories.EXPEDITION_LIST_MINIMIZED_PATH);
        });
        // Dots
        btDotsExpeditionListMinimizedPath.setOnAction(event -> {
            try {
                Text info = new Text();
                info.setText("""
                        This function is responsible for calculating the minimized path for an expedition list.
                        The user must first load the data of the Distribution Network and of the Products and Orders.
                        This can be done by using the Load Data functionality.
                                                
                        After loading the data, the user must select the day for which they want to calculate the minimized path.
                        The following step is selecting one of the available dispatch lists (simple or restricted).
                        When the user clicks on the button, the window will be switched to the main window of the user story.
                                                
                        Once there, the user must select one of the available starting points (producers).
                        Finally the application user will be presented with a table containing the minimized path for the selected producer
                        and the number of baskets dropped in each hub.
                        """);
                CommonsGUI.setPopUpWindowInfo(borderPane, "Minimized Path", "Expedition List Minimized Path (US310)", info, new Image("Images/Shortest_Route.png"));
                info.setFont(Font.font(50));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // CALCULATE STATISTICS
        btCalculateStatistics.setOnAction(e -> {
            // Hubs not defined
            if (!areHubsDefined())
                CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Hubs Defined", "To use this functionality, you must first define at least one hub.");
                // No dispatch list generated
            else if (!areThereAnyDispatchLists())
                CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Dispatch Lists", "To use this functionality, you must first generate at least one dispatch list.");
            else if (!App.getInstance().isThereAnyNearestHubDefined())
                CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Nearest Hubs Defined", "To use this functionality, you must first define the clients nearest hubs.");
            else
                toFunctionalityFactory(e, userStories.CALCULATE_STATISTICS);


        });
        // Dots
        btDotsCalculateStatistics.setOnAction(event -> {
            try {
                Text info = new Text();
                info.setText("""
                        The goal of this functionality is to provide the user with statistics about the distribution
                        network. The program calculates statistics for four different categories: basket orders,
                        clients, producers, and hubs.
                          To run this functionality, the user must first:
                                                
                            • Load the data from files about the distribution network (US301).
                            • Load the data from files about the Products and Orders (US307)
                            • Define Hubs (US302)
                            • Generate dispatch List (US308/9)
                            
                        Basket Order statistics include:
                                                
                            • Number of products that were totally satisfied (i.e., the quantity requested was
                            fully dispatched)
                            • Number of products that were partially satisfied
                            • Number of products that were not satisfied
                            • Percentage of satisfaction
                            • Number of different producers that contributed to supplying the order
                                                
                        Client statistics include:
                                                
                            • Number of basket orders that were totally satisfied (i.e., all products were
                            totally satisfied)
                            • Number of basket orders that were partially satisfied
                            • Number of different producers that contributed to supplying the orders
                                                
                        Producer statistics include:
                                                
                            • Number of basket orders that were totally satisfied (i.e., all products were
                            totally satisfied)
                            • Number of basket orders that were partially satisfied
                            • Number of different clients that received orders where the producer contributed
                            • Number of products that were completely sold out
                            • Number of hubs supplied
                                                
                        Hub statistics include:
                                                
                            • Number of different clients that collected their orders
                            • Number of different producers that sent orders there
                                                
                          This functionality can be useful for a variety of purposes, such as analyzing the
                        performance of different parts of the network and identifying areas for improvement.
                        It can also help the user to better understand the structure and capabilities of
                        the network, and may be useful for planning and optimization purposes.
                        """);
                CommonsGUI.setPopUpWindowInfo(borderPane, "Calculate Statistics", "Calculate Statistics for a Dispatch List (US311)", info, new Image("Images/statistics.png"));
                info.setFont(Font.font(50));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }


    private void toFunctionalityFactory(ActionEvent e, userStories name) {

        switch (name) {
            case LOAD_DATA -> {
                try {
                    helper.toLoadDataFromFilesGUI(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            case MOST_DISTANT_POINTS -> {
                try {
                    helper.toMostDistantPairOfVerticesGUI(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            case DEFINE_N_HUBS -> {
                try {
                    helper.toDefineNHubsGUI(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            case NEAREST_HUB -> {
                try {
                    if (!App.getInstance().isThereAnyHubDefined()) {
                        CommonsGUI.showAlert(Alert.AlertType.ERROR, "No Hubs", "Please define the hubs first!");
                    } else helper.toFindNearestHubGUI(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            case CONNECTED_NETWORK -> {
                try {
                    if (!distributionNetwork.getDistributionNetwork().isConnected()) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Connection Network");
                        alert.setHeaderText("The network is not connected");
                        alert.setContentText("Please make sure the network is connected");
                        alert.showAndWait();
                    } else helper.toConnectedNetworkGUI(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            case WATERING_CONTROLLER -> {
                try {
                    helper.toWateringGUI(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            case DISPATCH_LIST -> {
                try {
                    helper.toGenerateDispatchListMenuGUI(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            case EXPEDITION_LIST_MINIMIZED_PATH -> {
                try {
                    // TODO - Nome para o button
                    CommonsGUI.toChooseDispatchListGUI(e, true, "Minimmized Path");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            case CALCULATE_STATISTICS -> {
                try {
                    CommonsGUI.toChooseDispatchListGUI(e, false, "Calculate Statistics");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void startupMainPage() {
        helper = new MainPageGUIHelper();

        // Sets the responsiveness into the bottom bar - Center the items
        borderPane.widthProperty().addListener(e -> CommonsGUI.setResponsiveness(borderPane, hBoxBar, hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight, btProfile, btHome, btSettings));

        // Defining the Button Bar Button's actions
        CommonsGUI.setBarButtons(btHome, btProfile, btSettings);

        // Checks if the data is loaded and sets the visibility depending on it
        checkDataInSystemAndShowTheAvailable();


    }

    public void checkDataInSystemAndShowTheAvailable() {

        if (!App.getInstance().loadedData.get(1)) {
            vBoxDistributionNetworkData.setVisible(false);
            vBoxDistributionNetworkData.setManaged(false);
        } else {
            vBoxDistributionNetworkData.setVisible(true);
            vBoxDistributionNetworkData.setManaged(true);
        }

        if (!App.getInstance().loadedData.get(2)) {
            vBoxProductsData.setVisible(false);
            vBoxProductsData.setManaged(false);
        } else {
            vBoxProductsData.setVisible(true);
            vBoxProductsData.setManaged(true);
        }

        if (!App.getInstance().loadedData.get(3)) {
            vBoxWateringPlanData.setVisible(false);
            vBoxWateringPlanData.setManaged(false);
        } else {
            vBoxWateringPlanData.setVisible(true);
            vBoxWateringPlanData.setManaged(true);
        }
    }

    private boolean isDistributionNetworkDataLoaded() {
        return !App.getInstance().getSystemData().getDistributionNetwork().isEmpty();
    }

    private boolean areHubsDefined() {
        return App.getInstance().isThereAnyHubDefined();
    }

    private boolean isProductsDataLoaded() {
        return !App.getInstance().getSystemData().getOrders().isEmpty();
    }

    private boolean areThereAnyDispatchLists() {
        return !App.getInstance().getSystemData().getSimpleDispatchLists().isEmpty()
                || !App.getInstance().getSystemData().getDispatchListsWithRestrictions().isEmpty();
    }
}
