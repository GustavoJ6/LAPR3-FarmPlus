package GUI.Screens;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;

import java.awt.*;

public class PopUpWindowGUI  {


    @FXML
    private Label title;

    @FXML
    private Text info;

    @FXML
    private ImageView image;

    public void setInfo(String title, Text info, Image image) {
        this.title.setText(title);
        this.info.setText(info.getText());
        this.image.setImage(image);
    }
}
