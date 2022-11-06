package worldofzuul;

import java.util.ArrayList;

public class FnRoom extends Room{
    private ArrayList<Task> taskArrayList = new ArrayList<>();
    private int currentTaskIndex = 0;

    public FnRoom(String name, String description, int waterCost)
    {
        super(name, description, waterCost);
        createTasks();
    }
    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }
    public void setTaskArrayList(ArrayList<Task> taskArrayList) {
        this.taskArrayList = taskArrayList;
    }

    private void createTasks() {
        setTaskArrayList(new ArrayList<>(){{
            add(new Task(0, "Welcome to the FN encampment, we're short on supplies at the moment, please find us 5 AAA batteries. We will reward you with pipe.", new Item("battery", 1), new Item("pipe", 1)));
            add(new Task(1, "get the ", new Item("placeholder requirement", 1), new Item("pipe", 1)));
            add(new Task(2, "get the ", new Item("placeholder requirement", 1), new Item("pipe", 1)));
            add(new Task(3, "get the ", new Item("placeholder requirement", 1), new Item("pipe", 1)));
            add(new Task(4, "get the ", new Item("placeholder requirement", 1), new Item("pipe", 1)));
            add(new Task(5, "get the ", new Item("placeholder requirement", 1), new Item("pipe", 1)));
            add(new Task(6, "get the ", new Item("placeholder requirement", 1), new Item("pipe", 1)));
            add(new Task(7, "get the ", new Item("placeholder requirement", 1), new Item("pipe", 1)));
            add(new Task(8, "get the ", new Item("placeholder requirement", 1), new Item("pipe", 1)));
            add(new Task(9, "get the ", new Item("placeholder requirement", 1), new Item("pipe", 1)));
        }});
    }

    public int getCurrentTaskIndex() {
        return currentTaskIndex;
    }

    public void setCurrentTaskIndex(int currentTaskIndex) {
        this.currentTaskIndex = currentTaskIndex;
    }

    public Task giveTask(int id) {
        System.out.println("Give task #" + id);
        return taskArrayList.get(id);
    }

    public void completeTask(int id) {
        System.out.println("Complete task #" + id);
        taskArrayList.get(id).completeTask();
        setCurrentTaskIndex(id + 1);
        System.out.println("Next task index is " + currentTaskIndex);
    }
}

