package worldofzuul;
public class WaterSource extends Room {
    private int waterDiscount;

    public WaterSource(String name, String description, int waterCost) {
        super(name, description, waterCost);
    }

    public void setWaterDiscount() {
        Item pipe = Inventory.getItem("pipe");
        if (pipe != null) waterDiscount = pipe.getQuantity() * 10;
        if (waterDiscount > super.getWaterCost()) waterDiscount = super.getWaterCost();
    }

    public int getWaterDiscount() {
        return waterDiscount;
    }

    @Override
    public int getWaterCost() {
        return super.getWaterCost() - getWaterDiscount();
    }
}
