package worldofzuul.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import worldofzuul.Inventory;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class WaterBarController implements PropertyChangeListener {
    @FXML
    private Label waterAmountLabel;

    @FXML
    private ProgressBar waterBar;

    private int water = Inventory.getWater();

    @FXML
    public void initialize() {
        Inventory.addPropertyChangeListener(this);
        update();
    }

    @FXML
    private void update() {
        waterAmountLabel.setText(Inventory.getWater() + "%");
        waterBar.setProgress(progressFromWaterAmount());
    }

    private double progressFromWaterAmount() {
        return (double) water / Inventory.getMaxWater();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.water = (int) evt.getNewValue();
        update();
    }
}
