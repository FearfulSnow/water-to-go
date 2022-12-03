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

    public void completeTask() {
        if (!isRequirementsMet()) {
            System.out.println("Requirements not met.");
            return;
        }
        System.out.println("Requirements met!");
        Inventory.removeItem(requirement);
        Inventory.addItem(reward);
        System.out.println("Well done! You have completed the task. Feel free to accept the next one!");
        isCompleted = true;
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
