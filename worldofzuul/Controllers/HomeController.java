package worldofzuul.Controllers;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HomeController {
    private static final PropertyChangeSupport support = new PropertyChangeSupport(HomeController.class);
    public void showIntro(boolean shouldShow) {
        if (shouldShow) {
            System.out.println("show intro");
            support.firePropertyChange("showIntro", false, true);
        }
    }

    public static void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

}
