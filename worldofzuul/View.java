package worldofzuul;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private JPanel panel;
    public View () {
        panel = new JPanel();

        this.setSize(640, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBackground(Color.GRAY);

        this.add(panel);
        this.setVisible(true);
    }
}
