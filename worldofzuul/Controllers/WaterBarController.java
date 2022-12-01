package worldofzuul.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import worldofzuul.Inventory;

public class WaterBarController {
    @FXML
    private Label waterAmountLabel;

    @FXML
    private ProgressBar waterBar;

    @FXML
    public void initialize() {
        update();
    }

    @FXML
    private void update() {
        waterAmountLabel.setText(Inventory.getWater() + "%");
        waterBar.setProgress(progressFromWaterAmount());
    }

    private double progressFromWaterAmount() {
        return ((double) Inventory.getWater()) / Inventory.getMaxWater();
    }
}
