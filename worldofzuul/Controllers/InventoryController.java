package worldofzuul.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import worldofzuul.Controllers.Components.InventoryRow;
import worldofzuul.Inventory;
import java.util.ArrayList;
import java.util.List;

public class InventoryController {
    @FXML
    private MenuItem inventoryEmpty;
    @FXML
    private MenuBar inventoryMenu;

    private List<MenuItem> inventoryRows = new ArrayList<>();

    @FXML
    private void update() {
        inventoryEmpty.setVisible(Inventory.getItems().isEmpty());
        inventoryMenu.getMenus().get(0).getItems().removeAll(inventoryRows);
        inventoryRows.clear();
        Inventory.getItems().forEach(item -> {
            InventoryRow row = new InventoryRow(item);
            inventoryRows.add(row.getRow());
        });
        inventoryMenu.getMenus().get(0).getItems().addAll(inventoryRows);
    }
}
