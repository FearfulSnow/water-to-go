package worldofzuul;

import java.util.*;

public class RoomExplore extends Room {

    private static LinkedList<Info> infoLinkedList = new LinkedList<>() {{

        add(new Info(0, 10, "Togo is a small but densely populated country in Western Africa.\nThe southern part of the country is a low coastal plain with extensive lagoons and marshes, while further north is the savanna – dry and arid. \n67% of the country’s land is considered Agricultural, with Togo’s main exports being Cocoa Beans, Coffee, and Peanuts."));
        add(new Info(1, 10, "Current estimates are that 55% of rural communities in Togo do not have access to an improved water source."));
        add(new Info(2, 10, "More than 60 percent of Togo's population lives below the poverty line, and many people lack reliable access to drinking water, education, health and electricity"));
        add(new Info(3, 10, "“With funds from generous donors, we have been able to make repairs to existing wells in various small villages. This will help educational systems and Togo's health…”-FN"));
    }};
    // Arraylist made for items.
    private ArrayList<Item> itemList = new ArrayList<>() {{
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

    public void collectItem() {
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
        getNextInfo();
    }

    private int getRandomItemNumber(int min, int max) {
        Random ran = new Random();
        return ran.nextInt(max - min) + min;
    }

    public void getNextInfo() {

        if (infoLinkedList.size() > 0) {
            int randomNo = getRandomItemNumber(0,(infoLinkedList.size()+1)*infoLinkedList.size());
            if((randomNo % infoLinkedList.size() == 0)){

                System.out.println(infoLinkedList.pop().toString());
            }
        }
    }
}
