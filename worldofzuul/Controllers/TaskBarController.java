package worldofzuul.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import worldofzuul.FnRoom;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TaskBarController implements PropertyChangeListener {
    @FXML
    private Label taskCompletionLabel;
    @FXML
    private ProgressBar taskBar;

    double currentProgress = 0.0;


    @FXML
    public void initialize() {
        FnRoom.addPropertyChangeListener(this);
        update();
    }

    @FXML
    private void update() {
        long completedTasks = FnRoom.getTaskArrayList().stream().filter(task -> task.isCompleted).count();
        currentProgress = ((double) completedTasks) / FnRoom.getTaskArrayList().size();
        taskBar.setProgress(currentProgress);
        taskCompletionLabel.setText(((int) completedTasks) + "/" + FnRoom.getTaskArrayList().size());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        update();
    }
}
