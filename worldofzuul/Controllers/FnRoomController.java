package worldofzuul.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import worldofzuul.FnRoom;

import java.io.IOException;

public class FnRoomController {
    SceneController sceneController = new SceneController();
    double currentProgress = 0.0;
    @FXML
    private TextField textEX;
    @FXML
    private ProgressBar TaskProgressBar;

    @FXML
    void goHome(ActionEvent event) throws IOException {
        sceneController.goHome(event);
    }

    @FXML
    void completeTask(ActionEvent event) throws IOException {
        if (FnRoom.currentTask == null){
            textEX.setText("You have no tasks to complete");
        } else if (FnRoom.currentTask.completeTask()) {
            FnRoom.currentTask = null;
            textEX.setText("Well done! You have completed the task. Feel free to accept the next one!");
            currentProgress += 1/ (double) FnRoom.getTaskArrayList().size();
            TaskProgressBar.setProgress(currentProgress);
            //if (//win)
        } else {
            String str = "\nNeeds " + FnRoom.currentTask.getRequirement().getQuantity() + "x " + FnRoom.currentTask.getRequirement().getName() + "\n";
            textEX.setText(str);
        }
    }
    @FXML
    void acceptTask(ActionEvent event) throws IOException {
        FnRoom.giveTask();
        textEX.setText(FnRoom.currentTask.getDescription());
    }
}
