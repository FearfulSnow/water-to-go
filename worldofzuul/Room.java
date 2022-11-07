package worldofzuul;

import java.util.HashMap;

public class Room {
    private final String name;
    private final String description;
    private HashMap<String, Room> exits;
    private int waterCost;

    public Room(String name, String description, int waterCost) {
        this.name = name;
        this.description = description;
        this.waterCost = waterCost;
        exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
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
