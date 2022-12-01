package worldofzuul.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import worldofzuul.RoomExplore;
import java.io.IOException;

public class RoomExploreController {
        @FXML
        void search(ActionEvent event) {
            RoomExplore.collectItem();
        }

    }


