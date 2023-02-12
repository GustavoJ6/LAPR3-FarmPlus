package GUI.Screens;

import Controller.AuthSystem;
import GUI.Components.CommonsGUI;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class ProfileGUI implements Initializable {


    public Button btLogout;
    @FXML
    private BorderPane borderPane;

    @FXML
    private HBox hBoxBar, hBoxBar1, hBoxBar2, hBoxBar3;

    // Buttom hBox
    @FXML
    private HBox hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight;

    @FXML
    private Label lbGreet;

    @FXML
    private Label txtUserName;

    @FXML
    private Label txtPassword;

    @FXML
    private Button btReveal;

    // Buttom Buttons
    @FXML
    private Button btProfile, btHome, btSettings;

    private boolean isPasswordVisible = false;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Making it Responsive
        borderPane.widthProperty().addListener(e -> {
            CommonsGUI.setResponsiveness(borderPane, hBoxBar, hBoxVert1, hBoxVert2, hBoxLeft, hBoxRight, btProfile, btHome, btSettings);
            double hBoxBarWidth = 0.9 * borderPane.getWidth();
            hBoxBar.setPrefWidth(hBoxBarWidth);
            hBoxBar1.setPrefWidth(hBoxBarWidth);
            hBoxBar2.setPrefWidth(hBoxBarWidth);
            hBoxBar3.setPrefWidth(hBoxBarWidth);
        });

        String username = AuthSystem.getInstance().getCurrentUser().username();
        lbGreet.setText("Hello, " + username + "!");
        txtUserName.setText(username);

        // Password
        txtPassword.setText(getPasswordHidden(AuthSystem.getInstance().getCurrentUser().password()));

        btReveal.setOnAction(this::passwordReveal);

        btLogout.setOnAction(this::logout);

        // Defining the Button Bar Button's actions
        CommonsGUI.setBarButtons(btHome, btProfile, btSettings);
    }

    private void passwordReveal(ActionEvent e) {
        String password = AuthSystem.getInstance().getCurrentUser().password();
        if (isPasswordVisible) {
            txtPassword.setText(getPasswordHidden(password));
            isPasswordVisible = false;
        } else {
            txtPassword.setText(password);
            isPasswordVisible = true;
        }
    }

    private String getPasswordHidden(String pwd) {
        // Create a string with the same length as the password with *'s
        StringBuilder sb = new StringBuilder();
        sb.append("*".repeat(pwd.length()));

        return sb.toString();
    }

    public void logout(ActionEvent e) {
        AuthSystem.getInstance().logout();
        try {
            CommonsGUI.toLoginGUI(e);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
