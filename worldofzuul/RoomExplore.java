package worldofzuul;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;

public class RoomExplore extends Room {
    // Arraylist made for items.
    private static ArrayList<Item> itemList = new ArrayList<>() {{
        add(new Item("Metal Scrap", 1));
        add(new Item("Plastic", 1));
        add(new Item("Filter", 1));
        add(new Item("Bag of gravel", 1));
        add(new Item("Bag of sand", 1));
        add(new Item("nothing", 0));
    }};

    private static final PropertyChangeSupport support = new PropertyChangeSupport(RoomExplore.class);

    public RoomExplore(String name, String description, int waterCost) {
        super(name, description, waterCost);
    }

    public static void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public static void collectItem() {
        //Find item, in the list (Random or searched for)
        //return found item
        int sizeOfItemList = itemList.size();

        Item itemToReturn = itemList.get(getRandomItemNumber(0, sizeOfItemList));
        support.firePropertyChange("foundItem", null, itemToReturn);

        if (itemToReturn.getName().equals("nothing")) {
            System.out.println("You found nothing");
        } else {
            System.out.printf("You found %dx %s\n", itemToReturn.getQuantity(), itemToReturn.getName());
            Inventory.addItem(itemToReturn);
        }
        Inventory.setWater(Inventory.getWater() - 10);
    }

    private static int getRandomItemNumber(int min, int max) {
        Random ran = new Random();
        return ran.nextInt(max - min) + min;
    }
}
