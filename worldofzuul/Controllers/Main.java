package worldofzuul.Controllers;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import worldofzuul.Game;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Game.getInstance(); //creates rooms, taskList, inventory
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("worldofzuul/Scenes/Home.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
