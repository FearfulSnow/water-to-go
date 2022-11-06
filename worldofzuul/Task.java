package worldofzuul;

public class Task {

    private final int id;

    private final String description;

    public boolean isCompleted;

    private final Item requirement;

    private final Item reward;

    public Task(int id, String description, Item requirement, Item reward) {
        this.id = id;
        this.description = description;
        this.requirement = requirement;
        this.reward = reward;
    }

    public void completeTask() {
        System.out.println("Completed task");
        isCompleted = true;
    }


    public boolean isRequirementsMet(Inventory inventory) {
        System.out.println("Checking requirements");
        return inventory.getItem(requirement.getName()) != null && inventory.getItem(requirement.getName()).getQuantity() >= requirement.getQuantity();
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Item getRequirement() {
        return requirement;
    }

    public Item getReward() {
        return reward;
    }

    @Override
    public String toString() {
        return "Task{" +
            "id=" + id +
            ", description='" + description + '\'' +
            ", isCompleted=" + isCompleted +
            ", requirement=" + requirement +
            ", reward=" + reward +
            '}';
    }
}
