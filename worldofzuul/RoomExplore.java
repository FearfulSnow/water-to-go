package worldofzuul;

import java.util.*;

public class RoomExplore extends Room {
    // Arraylist made for items.
    private ArrayList<Item> itemList = new ArrayList<>() {{
        add(new Item("salt water battery", 1));
        add(new Item("plastic", 1));
        add(new Item("nothing", 0));
    }};

    public RoomExplore(String name, String description, int waterCost) {
        super(name, description, waterCost);
    }

    public void collectItem() {
        //Find item, in the list (Random or searched for)
        //return found item
        int sizeOfItemList = itemList.size();

        Item itemToReturn = itemList.get(getRandomItemNumber(0, sizeOfItemList));

        if (itemToReturn.getName().equals("nothing")) {
            System.out.println("You found nothing");
        } else {
            System.out.println("You found " + itemToReturn);
            InventorySingle.addItem(itemToReturn);
        }
        InventorySingle.setWater(InventorySingle.getWater() - 10);
    }

    private int getRandomItemNumber(int min, int max) {
        Random ran = new Random();
        return ran.nextInt(max - min) + min;
    }
}
