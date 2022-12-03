package worldofzuul;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
  private static Inventory inventory_instance = null;
  private static int water;
  private static final int maxWater = 100;
  private static List<Item> items = new ArrayList<>();

  private static final PropertyChangeSupport support = new PropertyChangeSupport(Inventory.class);

  private Inventory(int _water) {
    water = _water;
  }

  public static Inventory getInstance() {
    if (inventory_instance == null)
      inventory_instance = new Inventory(100);

    return inventory_instance;
  }

  public static void addPropertyChangeListener(PropertyChangeListener pcl) {
    support.addPropertyChangeListener(pcl);
  }

  public static int getWater() {
    return water;
  }

  public static void setWater(int _water) {
    int oldValue = water;
    water = _water;
    support.firePropertyChange("water", oldValue, water);
    if (water > maxWater) water = maxWater;
    if (water < 0) water = 0;
    System.out.printf("You have %d water remaining.\n", Inventory.getWater());
  }

  public static int getMaxWater() {
    return maxWater;
  }

  public static Item getItem(String name) {
    for (Item item: items) {
      if (item.getName().equals(name)) {
        return item;
      }
    }
    return null;
  }

  public static List<Item> getItems() {
    return items;
  }

  public static void itemsToString() {
    for (Item item : items) {
      System.out.printf("%dx %s\n", item.getQuantity(), item.getName());
    }
  }

  public static void addItem(Item item) {
    // Prevent pass by reference
    Item itemCopy = new Item(item.getName(), item.getQuantity());
    Item itemExists = getItem(item.getName());
    if (itemExists == null) {
      items.add(itemCopy);
    } else {
      getItem(itemCopy.getName()).setQuantity(itemExists.getQuantity() + itemCopy.getQuantity());
    }
    System.out.printf("Added %dx %s to inventory.\n", itemCopy.getQuantity(), itemCopy.getName());
  }
  public static void addItem(String name, int quantity) {
    Item item = getItem(name);
    if (item == null) {
      Item toBeAdded = new Item(name, quantity);
      items.add(toBeAdded);
    } else {
      getItem(name).setQuantity(item.getQuantity() + quantity);
    }
    System.out.printf("Added %dx %s to inventory.\n", quantity, name);
  }

  public static void removeItem(Item item) {
    Item itemExists = getItem(item.getName());
    if (itemExists == null) {
      System.out.printf("Item %s does not exist in inventory", item.getName());
      return;
    }
    if (itemExists.getQuantity() - item.getQuantity() < 0) {
      System.out.println("Not enough items in inventory");
      return;
    }
    getItem(item.getName()).setQuantity(itemExists.getQuantity() - item.getQuantity());
    if (getItem(item.getName()).getQuantity() <= 0) {
      items.remove(getItem(item.getName()));
    }
    System.out.printf("Removed %dx %s from inventory.\n", item.getQuantity(), item.getName());
  }
  public static void removeItem(String name, int quantity) {
    Item item = getItem(name);
    if (item == null) {
      System.out.println("Item " + name + " does not exist in inventory");
      return;
    }
    getItem(name).setQuantity(item.getQuantity() - quantity);
    if (getItem(name).getQuantity() <= 0) {
      items.remove(getItem(name));
    }
    System.out.printf("Removed %dx %s from inventory.\n", quantity, name);
  }
}
