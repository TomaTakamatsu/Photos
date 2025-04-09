package src.app;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import src.view.LoginController;
public class PhotoApp extends Application {
    @Override
    public void start(Stage loginStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/login.fxml"));
        Parent root = loader.load();
        LoginController controller = loader.getController();

        Scene scene = new Scene(root, 600, 400);
        loginStage.setTitle("Login Menu");
        loginStage.setScene(scene);
        loginStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}