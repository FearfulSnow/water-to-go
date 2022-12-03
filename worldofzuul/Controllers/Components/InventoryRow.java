package worldofzuul.Controllers.Components;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import worldofzuul.Item;

public class InventoryRow {
    @FXML public MenuItem row = new MenuItem();

    public InventoryRow(Item item) {
        row.setText(item.getName() + " x" + item.getQuantity());
    }

    public MenuItem getRow() {
        return row;
    }
}
