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

public class InventoryController {
    @FXML
    private VBox inventoryList;
    @FXML
    private Label inventoryEmpty;

    private List<HBox> inventoryRows = new ArrayList<>();
    @FXML
    public void toggleInventory(ActionEvent event) throws IOException {
        inventoryEmpty.setVisible(Inventory.getItems().isEmpty());
        inventoryEmpty.setManaged(Inventory.getItems().isEmpty());

        inventoryList.getChildren().removeAll(inventoryRows);
        inventoryRows.clear();
        for (Item item : Inventory.getItems()) {
            InventoryRow row = new InventoryRow(item);
            inventoryRows.add(row.getRow());
        }
        inventoryList.getChildren().addAll(inventoryRows);

        inventoryList.setVisible(!inventoryList.isVisible());
    }
}
