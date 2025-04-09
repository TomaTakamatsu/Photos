package src.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtUser;

    @FXML
    private Button btnLogin;

    public void Login(ActionEvent e) throws Exception{
        if (txtUser.getText().equals("admin")){
            lblStatus.setText("Logged in");

            Stage loginStage = (Stage) btnLogin.getScene().getWindow();
            loginStage.close();

            Stage photosStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/main.fxml"));
            Parent root = loader.load();
            MainController controller = loader.getController();

            Scene scene = new Scene(root, 600, 400);
            photosStage.setTitle("Photos App");
            photosStage.setScene(scene);
            photosStage.show();
        }
        else{
            lblStatus.setText("Login failed");
        }
    }

}
