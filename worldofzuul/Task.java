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
        isCompleted = true;
    }


    public boolean isRequirementsMet() {
        return false;
    }

    public boolean isCompleted() {
        return isCompleted;
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
