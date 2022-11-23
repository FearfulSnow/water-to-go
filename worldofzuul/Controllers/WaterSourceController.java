package worldofzuul.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import worldofzuul.Inventory;
import java.io.IOException;

public class WaterSourceController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField textEX;

    @FXML
    void FillWater(ActionEvent event) throws IOException {

        textEX.setText("You fill your water bottle.");

        Inventory.setWater(100);

        }


    @FXML
    void goToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("Home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
