package GUI.Screens;

        import javafx.fxml.FXML;
        import javafx.scene.control.Label;
        import javafx.scene.layout.BorderPane;
        import javafx.scene.text.Text;

public class RouteGUI {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Label lbRoute;

    @FXML
    private Text txtRoute;

    public void setInfo(String originDestination, String route) {
        lbRoute.setText(originDestination);
        txtRoute.setText(route);
    }

}