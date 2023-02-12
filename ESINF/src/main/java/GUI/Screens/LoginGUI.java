package GUI.Screens;

import Controller.*;
import GUI.Components.*;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class LoginGUI implements Initializable{


    @FXML
    private BorderPane borderPane;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private JFXToggleButton toggleButton;

    @FXML
    private Button btLogin;

    private int loginAttempts = 4;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btLogin.setOnAction(this::login);
        btLogin.setDefaultButton(true);

        toggleButton.setSelected(App.getInstance().desktopMode);

        toggleButton.setOnAction(e -> {
            App.getInstance().desktopMode = toggleButton.isSelected();
            try {
                CommonsGUI.toLoginGUI(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void login(ActionEvent e) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        AuthSystem.User user = AuthSystem.getInstance().login(username, password);

        Alert alert;
        if (user != null) {

            applicationPerRoleFactory(user, e);

        } else {
            // Login failed
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login");
            alert.setHeaderText("Login Failed!");
            alert.setContentText("Invalid username or password!");
            alert.showAndWait();
            loginAttempts--;
            if (loginAttempts == 0) {
                alert.setHeaderText("You are not allowed to try again!");
                alert.setContentText("Too many bad login attempts!");
                alert.showAndWait();
                System.exit(0);
            }
        }
    }

    private void applicationPerRoleFactory(AuthSystem.User user, ActionEvent e) {

        switch (user.role()) {
            case ESINF_USER -> {
                try {
                    CommonsGUI.homeEsinf(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            case BDDAD_USER -> {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("NIY");
                alert.setHeaderText("Not Implemented Yet!");
                alert.setContentText("This feature is not implemented yet!");
                alert.showAndWait();
            }
        }

    }

}
