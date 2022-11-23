package worldofzuul;

import java.util.*;

public class RoomExplore extends Room {
    // Arraylist made for items.
    private static ArrayList<Item> itemList = new ArrayList<>() {{
        add(new Item("salt water battery", 1));
        add(new Item("plastic", 1));
        add(new Item("filter", 1));
        add(new Item("metal scrap", 1));
        add(new Item("pipe", 1));
        add(new Item("nothing", 0));
    }};

    public RoomExplore(String name, String description, int waterCost) {
        super(name, description, waterCost);
    }

    public static void collectItem() {
        //Find item, in the list (Random or searched for)
        //return found item
        int sizeOfItemList = itemList.size();

        Item itemToReturn = itemList.get(getRandomItemNumber(0, sizeOfItemList));

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
