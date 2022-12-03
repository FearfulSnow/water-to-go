package worldofzuul.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import worldofzuul.FnRoom;

import java.io.IOException;

public class FnRoomController {
    @FXML
    private TextField textEX;

    @FXML
    private Button acceptButton;
    @FXML
    private Button completeButton;

    @FXML
    void completeTask(ActionEvent event) throws IOException {
        FnRoom.completeCurrentTask();
        update();
    }
    @FXML
    void acceptTask(ActionEvent event) throws IOException {
        FnRoom.giveTask();
        textEX.setText(FnRoom.currentTask.getDescription());
        update();
    }

    @FXML
    public void initialize() {
        update();
    }

    private void update() {
        acceptButton.setDisable(FnRoom.currentTask != null);
        completeButton.setDisable(FnRoom.currentTask == null);
        if (FnRoom.currentTask != null) completeButton.setDisable(!FnRoom.currentTask.isRequirementsMet());
    }
}
