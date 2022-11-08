package worldofzuul;

import java.util.*;

public class RoomExplore extends Room {

    private ArrayList<Item> itemList; //Arraylist made for items.

    public RoomExplore(String name, String description, int waterCost) {
        super(name, description, waterCost);
        createItem();
    }


// Arraylist initialized as an empty arraylist


    public void createItem() {
        itemList = new ArrayList<>();
        //Arraylist is filled with different items.


        Item item1 = new Item("Scrap metal",2);
        itemList.add(item1);

        Item item2 = new Item ("plastic",2);
        itemList.add(item2);

        Item item3 = new Item ("nothing",0);
        itemList.add(item3);
    }

    //Returns the item which is collected
    public Item collectItem() {
        //Find item, in the list (Random or searched for)
        //return found item


        int sizeOfItemList = itemList.size();
        /*
        int randomNumber = (int) (Math.random() * 10);
        int itemNumberToReturn = randomNumber;
        if (randomNumber > sizeOfItemList) {
            itemNumberToReturn = sizeOfItemList - 1;
        }*/

        Item itemToReturn = itemList.get(getRandomItemNumber(0,sizeOfItemList));

        if (itemToReturn.getName().equals("nothing")) {
            System.out.println("You found nothing");
            return null;
        } else {
            System.out.println("You found " + itemToReturn);
        }
        return itemToReturn;
    }
    public int getRandomItemNumber(int min, int max){
        Random ran = new Random();
        return ran.nextInt(max-min)+min;
    }
}
