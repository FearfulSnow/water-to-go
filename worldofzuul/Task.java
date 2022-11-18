package worldofzuul;

public class Task {

    private final int id;

    private final String description;

    private final Item requirement;

    private final Item reward;

    public boolean isCompleted = false;

    public Task(int id, String description, Item requirement, Item reward) {
        this.id = id;
        this.description = description;
        this.requirement = requirement;
        this.reward = reward;
    }

    public boolean completeTask() {
        if (!isRequirementsMet()) {
            System.out.println("Requirements not met.");
            return false;
        }
        System.out.println("Requirements met!");
        Inventory.removeItem(requirement);
        Inventory.addItem(reward);
        System.out.println("Well done! You have completed the task. Feel free to accept the next one!");
        isCompleted = true;
        return true;
    }


    public boolean isRequirementsMet() {
        System.out.printf("Checking requirements... \nNeeds %dx %s\n", requirement.getQuantity(), requirement.getName());
        return Inventory.getItem(requirement.getName()) != null && Inventory.getItem(requirement.getName()).getQuantity() >= requirement.getQuantity();
    }

    public String getDescription() {
        return description;
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
            ", requirement=" + requirement +
            ", reward=" + reward +
            '}';
    }
}
