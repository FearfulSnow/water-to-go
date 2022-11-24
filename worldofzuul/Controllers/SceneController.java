package worldofzuul.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    void goExploreRoom(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("worldofzuul/Scenes/RoomExplore.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goFnRoom(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("worldofzuul/Scenes/FnRoom.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goWaterSource(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("worldofzuul/Scenes/WaterSource.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    void goHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("worldofzuul/Scenes/Home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
