package worldofzuul.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import worldofzuul.FnRoom;
import worldofzuul.Game;
import worldofzuul.Inventory;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PopupController implements PropertyChangeListener {
    @FXML
    private Label popupText;
    @FXML
    private Button popupButton;
    @FXML
    private GridPane popup;

    @FXML
    private void closePopup() {
        popup.setVisible(false);
    }

    private void setPopupText(String text) {
        popupText.setText(text);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("showIntro")) intro();
        if (FnRoom.isAllTasksDone()) {
            youWin();
        }
        if (evt.getPropertyName().equals("water")) {
            if (((int) evt.getNewValue()) == 0 && !Game.getInstance().currentRoom.getName().equals("Well")) {
                youLose();
            }
        }
    }

    private void update() {
        if (Inventory.getWater() == 0 && !Game.getInstance().currentRoom.getName().equals("Well")) youLose();
    }

    private void youWin() {
        setPopupText("Congratulations you have built a new well!\n“With funds from generous donors, we have been able to make repairs to existing wells in various small villages. This will help educational systems and Togo's health…” - UN");
        popupButton.setText("Exit game");
        popupButton.setOnAction(actionEvent -> System.exit(0));
        popup.setVisible(true);
    }

    private void youLose() {
        setPopupText("You ran out of water and passed out. Try again");
        popupButton.setText("Exit game");
        popupButton.setOnAction(actionEvent -> System.exit(0));
        popup.setVisible(true);
    }

    private void intro() {
        setPopupText(Game.getInstance().welcomeString());
        popup.setVisible(true);
    }

    @FXML
    private void initialize() {
        FnRoom.addPropertyChangeListener(this);
        Inventory.addPropertyChangeListener(this);
        HomeController.addPropertyChangeListener(this);
        popup.setVisible(false);
        update();
    }
}
