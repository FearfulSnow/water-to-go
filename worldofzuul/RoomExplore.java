package worldofzuul;

import java.util.*;

public class RoomExplore extends Room {

    private ArrayList<String> itemList; //Arraylist made for items.

    public RoomExplore(String name, String description, int waterCost) {
        super(name, description, waterCost);
    }


// Arraylist initialized as an empty arraylist


    public void createItem() {
        itemList = new ArrayList<>();
        //Arraylist is filled with different items.


        String item1 = "Scrap metal";
        itemList.add(item1);

        String item2 = "plastic";
        itemList.add(item2);

        String item3 = "nothing";
        itemList.add(item3);
    }

        //Returns the item which is collected
    public String collectItem(){
        //Find item, in the list (Random or searched for)
        //return found item

        int sizeOfItemList = itemList.size();

        int randomNumber = (int) (Math.random()*10);
        int itemNumberToReturn = randomNumber;
        if(randomNumber>sizeOfItemList) {
            itemNumberToReturn = sizeOfItemList-1;
        }

        String itemToReturn = itemList.get(itemNumberToReturn);

        if(itemToReturn.equals("nothing")) {
            System.out.println("You found nothing");
        } else {
            System.out.println("You found " + itemToReturn);
            return itemToReturn;
        }
        return null;
    }
}
