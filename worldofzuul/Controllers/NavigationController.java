package worldofzuul.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import worldofzuul.Game;
import worldofzuul.RoomName;

import java.io.IOException;
import java.util.HashMap;

public class NavigationController {
    @FXML
    private FlowPane navigationPane;
    @FXML
    private Button village;
    @FXML
    private Button well;
    @FXML
    private Button unitedNations;
    @FXML
    private Button wilderness;

    @FXML
    public void initialize() {
        HashMap<String, Button> buttonMap = new HashMap<>() {{
            put(village.getText(), village);
            put(well.getText(), well);
            put(unitedNations.getText(), unitedNations);
            put(wilderness.getText(), wilderness);
        }};

        Game.getInstance().currentRoom.getExits().forEach((direction, room) -> {
            buttonMap.get(direction).setVisible(true);
            buttonMap.get(direction).setManaged(true);
        });

        navigationPane.setPrefWrapLength(village.getWidth() + 32);
    }

    @FXML
    void goExploreRoom(ActionEvent event) throws IOException {
        Game.getInstance().goToRoom(RoomName.EXPLORE);
        navigationPane.getScene().setRoot(FXMLLoader.load(getClass().getClassLoader().getResource("worldofzuul/Scenes/RoomExplore.fxml")));
    }

    @FXML
    void goFnRoom(ActionEvent event) throws IOException {
        Game.getInstance().goToRoom(RoomName.FN);
        navigationPane.getScene().setRoot(FXMLLoader.load(getClass().getClassLoader().getResource("worldofzuul/Scenes/FnRoom.fxml")));
    }

    @FXML
    void goWaterSource(ActionEvent event) throws IOException {
        Game.getInstance().goToRoom(RoomName.WATER);
        navigationPane.getScene().setRoot(FXMLLoader.load(getClass().getClassLoader().getResource("worldofzuul/Scenes/WaterSource.fxml")));
    }

    @FXML
    void goHome(ActionEvent event) throws IOException {
        Game.getInstance().goToRoom(RoomName.HOME);
        navigationPane.getScene().setRoot(FXMLLoader.load(getClass().getClassLoader().getResource("worldofzuul/Scenes/Home.fxml")));
    }
}
