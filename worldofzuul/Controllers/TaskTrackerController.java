package worldofzuul.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import worldofzuul.FnRoom;
import worldofzuul.Task;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TaskTrackerController implements PropertyChangeListener {
    @FXML
    private Label taskRequirement;

    private Task currentTask;

    @FXML
    public void initialize() {
        FnRoom.addPropertyChangeListener(this);
        update();
    }

    @FXML
    private void update() {
        if (currentTask != null || FnRoom.currentTask != null) {
            currentTask = FnRoom.currentTask;
            taskRequirement.setText("Find " + currentTask.getRequirement().getName() + " x" + currentTask.getRequirement().getQuantity());
        } else {
            taskRequirement.setText("Visit United Nations to get a task");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.currentTask = ((Task) evt.getNewValue());
        update();
    }
}
