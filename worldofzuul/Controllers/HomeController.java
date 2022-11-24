package worldofzuul.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class HomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void goToExploreRoom(ActionEvent event) throws IOException {
    root = FXMLLoader.load(getClass().getClassLoader().getResource("worldofzuul/Scenes/RoomExplore.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }

    @FXML
    void goToFnRoom(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("worldofzuul/Scenes/FnRoom.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goToWaterSource(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("worldofzuul/Scenes/WaterSource.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
