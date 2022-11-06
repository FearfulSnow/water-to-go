package worldofzuul;

public class Item {
  private final String name;
  private int quantity;

  public Item(String name, int quantity) {
    this.name = name;
    this.quantity = quantity;
  }

  public int getQuantity() {
    return quantity;
  }

  @Override
  public String toString() {
    return "Item{" +
        "name='" + name + '\'' +
        ", quantity=" + quantity +
        '}';
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }
}
