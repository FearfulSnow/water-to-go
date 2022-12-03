package worldofzuul;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class FnRoom extends Room {
    private static ArrayList<Task> taskArrayList = new ArrayList<>();

    public static Task currentTask;
    private static PropertyChangeSupport support;

    public FnRoom(String name, String description, int waterCost) {
        super(name, description, waterCost);
        support = new PropertyChangeSupport(this);
        createTasks();
    }

    public static void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public static void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public static ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }

    public void setTaskArrayList(ArrayList<Task> taskArrayList) {
        this.taskArrayList = taskArrayList;
    }

    private void createTasks() {
        setTaskArrayList(new ArrayList<>() {{
            add(new Task(0, "Welcome to FN. Our main goal is to install pipes from the village to the water source to reduce the time spent on water collection.\nYour first task is to collect 2 salt water batteries and return it back to us.\nYour reward will be a pipe that you can use to install the pipeline to reduce the distance for villagers to obtain water.", new Item("salt water battery", 2), new Item("pipe", 1)));
            add(new Task(1, "In this task, you need to obtain 3 metal scraps.\nYour reward will be a pipe that you can use to install the pipeline to reduce the distance for villagers to obtain water.", new Item("metal scrap", 3), new Item("pipe", 1)));
            add(new Task(2, "In this task, you need to obtain 6 filters and return them back to us.", new Item("filter", 6), new Item("pipe", 1)));
        }});
    }

    public static void giveTask() {
        if (currentTask != null && !currentTask.isCompleted) {
            System.out.println("Finish your current task first before accepting the next task.");
            return;
        }
        System.out.println("Accepted task");
        for (Task task : taskArrayList) {
            if (!task.isCompleted) {
                currentTask = task;
                support.firePropertyChange("currentTask", null, currentTask);
                return;
            }
        }
    }

    public static void completeCurrentTask() {
        currentTask.completeTask();
        currentTask = null;
        support.firePropertyChange("currentTask", null, currentTask);
    }

    public static boolean isAllTasksDone(){
        for (Task task: taskArrayList) {
            if (!task.isCompleted){
                return false;
            }
        }
        return true;
    }
}

