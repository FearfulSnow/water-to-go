package worldofzuul.Controllers.Components;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import worldofzuul.Item;

public class InventoryRow {
    @FXML public HBox row = new HBox();
    @FXML private Label itemName;
    @FXML private Label itemQty;

    public InventoryRow(Item item) {
        itemName = new Label(item.getName());
        itemQty = new Label("x" + item.getQuantity());
        HBox.setHgrow(itemName, Priority.ALWAYS);
        itemName.setMaxWidth(140);
        row.setPrefWidth(150);
        row.getChildren().addAll(itemName, itemQty);
    }

    public HBox getRow() {
        return row;
    }
}
