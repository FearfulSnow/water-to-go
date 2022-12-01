package worldofzuul.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import worldofzuul.Game;

public class StatusRowController {
    @FXML
    private Label roomLabel;

    @FXML
    public void initialize() {
        roomLabel.setText(Game.getInstance().currentRoom.getName());
    }
}
