package worldofzuul;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
  private int water;
  private int maxWater = 100;
  private List<Item> items = new ArrayList<>();

  public Inventory(int water) {
    this.water = water;
  }

  public int getWater() {
    return water;
  }

  public void setWater(int water) {
    this.water = water;
    if (this.water > this.maxWater) this.water = this.maxWater;
    if (this.water < 0) this.water = 0;
  }

  public int getMaxWater() {
    return maxWater;
  }

  public void setMaxWater(int maxWater) {
    this.maxWater = maxWater;
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
}
