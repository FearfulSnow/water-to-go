package worldofzuul.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import worldofzuul.Controllers.Components.InventoryRow;
import worldofzuul.Inventory;
import worldofzuul.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeController {
    SceneController sceneController = new SceneController();
    InventoryController inventoryController = new InventoryController();

    @FXML
    void toggleInventory(ActionEvent event) throws IOException {
        inventoryController.toggleInventory(event);
    }

    @FXML
    void goToExploreRoom(ActionEvent event) throws IOException {
        sceneController.goExploreRoom(event);
    }

    @FXML
    void goToFnRoom(ActionEvent event) throws IOException {
        sceneController.goFnRoom(event);
    }

    @FXML
    void goToWaterSource(ActionEvent event) throws IOException {
        sceneController.goWaterSource(event);
    }

}
