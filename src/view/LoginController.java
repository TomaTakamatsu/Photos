package view;

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

        // Loading admin panel
        if (txtUser.getText().equals("admin")){
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("admin.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 600, 400);
            stage.setTitle("Admin");
            stage.setScene(scene);
            stage.show();
        }
        else{
            lblStatus.setText("Login failed");
        }
    }

}
