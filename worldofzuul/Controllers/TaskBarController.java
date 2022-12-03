package worldofzuul.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import worldofzuul.FnRoom;

public class TaskBarController {
    @FXML
    private Label taskCompletionLabel;
    @FXML
    private ProgressBar taskBar;

    double currentProgress = 0.0;


    @FXML
    public void initialize() {
        update();
    }

    @FXML
    private void update() {
        currentProgress = ((double) FnRoom.getTaskArrayList().stream().filter(task -> task.isCompleted).count());
        taskBar.setProgress(currentProgress);
        taskCompletionLabel.setText(((int) currentProgress) + "/" + FnRoom.getTaskArrayList().size());
    }
}
