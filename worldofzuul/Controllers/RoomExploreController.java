package worldofzuul.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import worldofzuul.Item;
import worldofzuul.RoomExplore;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RoomExploreController implements PropertyChangeListener {
    @FXML
    private TextField exploreTextBox;

    private Item recentItem;

    @FXML
    void search(ActionEvent event) {
        RoomExplore.collectItem();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        recentItem = (Item) evt.getNewValue();
        update();
    }

    @FXML
    private void initialize() {
        RoomExplore.addPropertyChangeListener(this);
    }

    @FXML
    private void update() {
        exploreTextBox.setText("You found " + recentItem.getName());
    }
}


