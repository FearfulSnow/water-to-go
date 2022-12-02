package worldofzuul.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import worldofzuul.FnRoom;

public class TaskTrackerController {
    @FXML
    private Label taskRequirement;

    @FXML
    public void initialize() {
        update();
    }

    @FXML
    private void update() {
        if (FnRoom.currentTask != null) {
            taskRequirement.setText("Find " + FnRoom.currentTask.getRequirement().getName() + " x" + FnRoom.currentTask.getRequirement().getQuantity());
        } else {
            taskRequirement.setText("Visit United Nations to get a task");
        }
    }
}
