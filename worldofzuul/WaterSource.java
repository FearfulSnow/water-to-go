package worldofzuul;

public class WaterSource extends Room {
    private int waterCost;

    public WaterSource (String desciption){
        super(desciption);
        this.waterCost = waterCost;
    }

    public int getWaterDiscount(Item pipes) {
        Inventory waterSoucePipes = new Inventory();
        return waterSoucePipes.getItem(pipes);
        
    }

    //setWaterCost method
    public void setWaterCost(){
        switch (getWaterDiscount()) {
            case 1:
                waterCost = 9;
                break;
            case 2:
                waterCost = 8;
                break;
            case 3:
                waterCost = 7;
                break;
            case 4:
                waterCost = 6;
                break;
            case 5:
                waterCost = 5;
                break;
            case 6:
                waterCost = 4;
                break;
            case 7:
                waterCost = 3;
                break;
            case 8:
                waterCost = 2;
                break;
            case 9:
                waterCost = 1;
                break;
        }
    }
    //collectWater method
    public void collectWater(){ //Sets the water to full, which is 100
        Inventory waterInv = new Inventory();
        waterInv.setWater(100);
    }
}
