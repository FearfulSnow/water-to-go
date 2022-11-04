package worldofzuul;

public class Task {

    private int id;

    private String description;

    public boolean isCompleated;

    private Item requirement;

    private Item reward;

    private Inventory inventory;

    public Task(int id, String description, Item requirement, Item reward) {
        this.id = id;
        this.description = description;
        this.requirement = requirement;
        this.reward = reward;
    }

    public void completeTask(){

        if (isRequirementsMeet()) {
            isCompleated = isRequirementsMeet();
            inventory.removeItem(requirement.getName(),1);
        }

    }


    public boolean isRequirementsMeet(){
        for (Item item: inventory.getItems()){if(requirement.equals(inventory.getItems()));

            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isCompleated=" + isCompleated +
                ", requirement=" + requirement +
                ", reward=" + reward +
                '}';
    }
}
