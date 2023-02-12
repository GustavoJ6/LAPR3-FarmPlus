import Controller.*;
import Utils.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.stage.Stage;

public class MainGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        App.getInstance().initializeLoadedData();

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        Scene scene = new Scene(root);
        bootstrap();
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle(Constants.APP_NAME);
        primaryStage.getIcons().add(new Image("/Images/farmPlus_Icon.png"));
        primaryStage.show();
    }

    private void bootstrap() {
        //Utils.filesBootstrapSmall();
        //Utils.filesBootstrapBig();
        Utils.usersBootstrap();
        // App.getInstance().loadedData.put(1,true);
        // App.getInstance().loadedData.put(2,true);
        // App.getInstance().loadedData.put(3,true);
    }
}
