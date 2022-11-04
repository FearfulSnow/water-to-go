package worldofzuul;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
  private int water;
  private List<Item> items = new ArrayList<>();

  public int getWater() {
    return water;
  }

  public Inventory(int water) {
    this.water = water;
  }

  public void setWater(int water) {
    this.water = water;
  }

  public Item getItem(String name) {
    for (Item item: this.items) {
      if (item.getName().equals(name)) {
        return item;
      }
    }
    return null;
  }

  public List<Item> getItems() {
    return items;
  }

  public void itemsToString() {
    for (Item item : items) {
      System.out.printf("%dx %s\n", item.getQuantity(), item.getName());
    }
  }

  public void addItem(String name, int quantity) {
    Item item = this.getItem(name);
    if (item == null) {
      Item toBeAdded = new Item(name, quantity);
      this.items.add(toBeAdded);
    } else {
      this.getItem(name).setQuantity(item.getQuantity() + quantity);
    }
    System.out.printf("Added %dx %s to inventory.\n", quantity, name);
  }

  public void removeItem(String name, int quantity) {
    Item item = this.getItem(name);
    if (item == null) {
      System.out.println("Item " + name + " does not exist in inventory");
      return;
    }
    this.getItem(name).setQuantity(item.getQuantity() - quantity);
    if (this.getItem(name).getQuantity() <= 0) {
      this.items.remove(this.getItem(name));
    }
    System.out.printf("Removed %dx %s from inventory.\n", quantity, name);
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

//  public static void main(String[] args) {
//    Item rock = new Item("Rock", 1);
//    Inventory inventory = new Inventory(100);
//    inventory.addItem(rock.getName(), rock.getQuantity());
//
//    System.out.println(inventory.getItem("Rock").toString());
//  }
}
