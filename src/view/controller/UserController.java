package view.controller;

import app.model.Album;
import app.model.User;
import app.util.UserManager;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;


public class UserController {
    @FXML private Label welcomeLabel;
    @FXML private TableView<Album> albumTableView;
    @FXML private TableColumn<Album, String> nameColumn;
    @FXML private TableColumn<Album, Integer> countColumn;
    @FXML private TableColumn<Album, String> rangeColumn;
    @FXML private TextField albumNameField;
    @FXML private Button createAlbumButton;
    @FXML private Button deleteAlbumButton;
    @FXML private Button renameAlbumButton;
    @FXML private Button openAlbumButton;
    @FXML private Button logoutButton;

    private User currentUser;
    private ObservableList<Album> allAlbums;
    
    public void setUser(User user){
        this.currentUser = user;
        welcomeLabel.setText("Welcome, " + user.getUsername() + "!");
    }

    public void initialize(){

    }

}
