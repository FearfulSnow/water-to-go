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
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("worldofzuul/Scenes/Home.fxml"));
        Parent root = loader.load();
        HomeController homeController = loader.getController();
        homeController.showIntro(true);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
