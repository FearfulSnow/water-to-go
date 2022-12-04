package worldofzuul.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import worldofzuul.FnRoom;

import java.io.IOException;

public class FnRoomController {
    @FXML
    private Label taskText;

    @FXML
    private Button acceptButton;
    @FXML
    private Button completeButton;

    @FXML
    void completeTask(ActionEvent event) throws IOException {
        FnRoom.completeCurrentTask();
        taskText.setText("Well done! You have completed the task. Feel free to accept the next one!"); // This is where we would put facts
        update();
    }
    @FXML
    void acceptTask(ActionEvent event) throws IOException {
        FnRoom.giveTask();
        taskText.setText(FnRoom.currentTask.getDescription());
        update();
    }

    @FXML
    public void initialize() {
        update();
    }

    private void update() {
        acceptButton.setDisable(FnRoom.currentTask != null && !FnRoom.isAllTasksDone());
        completeButton.setDisable(FnRoom.currentTask == null);
        if (FnRoom.currentTask != null) completeButton.setDisable(!FnRoom.currentTask.isRequirementsMet());
    }
}
