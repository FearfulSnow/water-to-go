package worldofzuul;

import javax.swing.*;
import java.util.HashMap;

public class Room {
    private final String name;
    private final String description;
    private HashMap<String, Room> exits = new HashMap<>();
    private int waterCost;
    private String bg;
    JPanel p;

    public Room(String name, String description, int waterCost, String bg) {
        this.name = name;
        this.description = description;
        this.waterCost = waterCost;
        this.bg = bg;
        p = new JPanel();
    }

    public JPanel getUI() {
        p.add(new JLabel("background img", new ImageIcon(getClass().getResource(bg)), JLabel.CENTER));
        return p;
    }

    public int getWaterCost() {
        return waterCost;
    }

    public void setWaterCost(int waterCost) {
        this.waterCost = waterCost;
    }

    public String getName() {
        return name;
    }

    public void setExits(HashMap<String, Room> exitsList) {
        this.exits = exitsList;
    }

    public String getShortDescription() {
        return description;
    }

    public String getLongDescription() {
        return description + ".\n" + getExitString();
    }

    private String getExitString() {
        StringBuilder returnString = new StringBuilder("Exits:");
        getExits().forEach((direction, neighbor) -> returnString.append(" ").append(direction).append(" (").append(neighbor.getWaterCost()).append(")"));
        return returnString.toString();
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public HashMap<String, Room> getExits() {
        return exits;
    }
}
