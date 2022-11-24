package worldofzuul.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import worldofzuul.RoomExplore;
import java.io.IOException;

public class RoomExploreController {

        SceneController sceneController = new SceneController();

        @FXML
        void goHome(ActionEvent event) throws IOException {
            sceneController.goHome(event);
        }

        @FXML
        void search(ActionEvent event) {
            RoomExplore.collectItem();
        }

    }


