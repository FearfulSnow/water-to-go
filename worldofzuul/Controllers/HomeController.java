package worldofzuul.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
public class HomeController {

    SceneController sceneController = new SceneController();

    @FXML
    void goToExploreRoom(ActionEvent event) throws IOException {
        sceneController.goExploreRoom(event);
    }

    @FXML
    void goToFnRoom(ActionEvent event) throws IOException {
        sceneController.goFnRoom(event);
    }

    @FXML
    void goToWaterSource(ActionEvent event) throws IOException {
        sceneController.goWaterSource(event);
    }

}
