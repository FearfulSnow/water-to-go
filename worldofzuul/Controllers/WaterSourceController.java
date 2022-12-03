package worldofzuul.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import worldofzuul.Inventory;

import java.io.IOException;

public class WaterSourceController {
    @FXML
    private TextField waterTextBox;

    @FXML
    void fillWater(ActionEvent event) throws IOException {
        waterTextBox.setText("You fill your water bottle.");
        Inventory.setWater(100);
    }
}
