package worldofzuul.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import worldofzuul.Room;
import worldofzuul.RoomExplore;

import java.io.IOException;

public class RoomExploreController {

Room currentRoom;

        @FXML
        private TextField exploreTextBox;
        private Stage stage;

        @FXML
        void goHome(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Home.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Image image = new Image(("HomeBackground.jpg"));
            ImageView homeImage = new ImageView();
            homeImage.setImage(image);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        @FXML
        void search(ActionEvent event) {
            RoomExplore.collectItem();
            System.out.println("Hello");
        }

    }


