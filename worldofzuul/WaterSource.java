package worldofzuul;


public class WaterSource extends Room {
    private int waterCost;

    public WaterSource (String desciption){
        super(desciption);
        this.waterCost = waterCost;
    }

    public int getWaterDiscount() {
        for (Item pipes: Inventory.items) {
            if (pipes.equals("pipes")) {
                int pipesAmount = pipes.getQuantity();
                return pipesAmount;
            }
        }
    }

    //setWaterCost method
    public void setWaterCost(){
        this.waterCost = 10 - getWaterDiscount();
        }
    //collectWater method
    public void collectWater(){ //Sets the water to full, which is 100
        Inventory.setWater(Inventory.getMaxWater());

    }
}
