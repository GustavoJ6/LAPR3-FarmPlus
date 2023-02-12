package GUI.Screens;

import Controller.App;
import GUI.Components.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.*;

public class DotsPopUpWindowGUI {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button btReadMore, btDelete;

    private boolean readMore;

    public void setInfo(String data) {

        // Defining btReadMore action
        btReadMore.setOnAction(event -> {
            readMore = true;
            try {
                DataShowReadMoreAndDeleteFactory(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Defining btDelete action
        btDelete.setOnAction(event -> {
            readMore = false;
            try {
                DataShowReadMoreAndDeleteFactory(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void DataShowReadMoreAndDeleteFactory(String data) throws IOException {

        switch (data) {
            case "DistributionNetwork" -> {

                if (readMore) {
                    CommonsGUI.setPopUpWindowInfo(borderPane, "Distribution Network", "Distribution Network Data", CommonsGUI.distributinNetworkText, new Image("Images/Distribution_Network_Data.png"));
                }
                else {
                    App.getInstance().getSystemData().clearFullData();
                    App.getInstance().getMainPageGUI().checkDataInSystemAndShowTheAvailable();
                    CommonsGUI.showAlert(Alert.AlertType.INFORMATION, "Deleted Data", "All the Distribution Network related Data has been deleted!");
                }
            }

            case "Products" -> {

                if (readMore) {
                    CommonsGUI.setPopUpWindowInfo(borderPane, "Products and Orders", "Products and Orders Data", CommonsGUI.productsText, new Image("Images/Products_Data.png"));
                }
                else {
                    App.getInstance().getSystemData().clearProductsRelatedData();
                    App.getInstance().getMainPageGUI().checkDataInSystemAndShowTheAvailable();
                    CommonsGUI.showAlert(Alert.AlertType.INFORMATION, "Deleted Data", "All the Products and Orders related Data has been deleted!");
                }
            }

            case "WateringPlan" -> {

                if (readMore) {
                    CommonsGUI.setPopUpWindowInfo(borderPane, "Watering Plan", "Watering Plan Data", CommonsGUI.wateringPlanText, new Image("Images/Watering_Plan_Data.png"));
                }
                else {
                    App.getInstance().getWateringStore().clearWateringPlan();
                    App.getInstance().getMainPageGUI().checkDataInSystemAndShowTheAvailable();
                    CommonsGUI.showAlert(Alert.AlertType.INFORMATION, "Deleted Data", "All the Watering Controller related Data has been deleted!");
                }

            }
        }
        // When the pop-up window is closed, the main window is enabled again
     // stage.setOnCloseRequest(closeEvent -> borderPane.setDisable(false));
    }
}
