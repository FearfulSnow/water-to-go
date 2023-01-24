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

    public static ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }

    public void setTaskArrayList(ArrayList<Task> taskArrayList) {
        FnRoom.taskArrayList = taskArrayList;
    }

    private void createTasks() {
        setTaskArrayList(new ArrayList<>() {{
            add(new Task(0, """
                Welcome to Togo a small but densely populated country in Western Africa!
                The southern part of the country is a low coastal plain with extensive lagoons and marshes with lots of water, but here in the north there is only the savanna – dry and arid.
                The villagers must travel far to find water so we will create a new well closer to the village.
                First we must get some drill equipment. Bring us some metal and we will turn it into a drill.
                """, new Item("Metal Scrap", 3), new Item("Drill", 1)));
            add(new Task(1, """
                Now that we have a drill we will start digging.
                Did you know that more than 60% of Togo's population lives below the poverty line, and many people lack reliable access to drinking water, education, health and electricity.
                Next up we need to get this well filled with pipes for transport.
                See if you can find some plastic, that we can turn into PVC pipes.
                """, new Item("Metal Scrap", 3), new Item("PVC pipe", 1)));
            add(new Task(2, """
                These pipes will go into the drilled hole, but first we need to prepare some filters.
                Did you know that 67% of the country’s land is considered Agricultural, with Togo’s main exports being Cocoa Beans, Coffee, and Peanuts.
                Filters are needed to prevent different contaminants from affecting the water.
                See if you can find some filters.
                """, new Item("Metal Scrap", 3), new Item("Filtered pipe", 1)));
            add(new Task(3, """
                With filters in place, we can install the pipes into the hole.
                To make sure it is stable we need to fill gravel around the pipe.
                You can find gravel out in the wilderness.
                """, new Item("Metal Scrap", 3), new Item("Gravel", 1)));
            add(new Task(4, """
                The pipe has been installed in the hole, now we need to make a sanitary seal.
                This is made with concrete and encapsulates the top couple of meters of the pipe.
                More than 60% of Togo’s population lives below the poverty line so we need to mix our own cement using powder and sand.
                See if you can find some sand.
                """, new Item("Metal Scrap", 3), new Item("Concrete", 1)));
            add(new Task(5, """
                Finally, we are almost done.
                We only need to add a hand pump to the well and the villagers can have easy access to clean water.
                Current estimates are that 55% of rural communities in Togo do not have access to an improved water source.
                There is a long way to go to raise that number to 100%, but with funds from the general public we are able to build wells in other villages like this.
                Find some metal scraps and we can turn that into a pump.
                """, new Item("Metal Scrap", 3), new Item("Hand Pump", 1)));
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

    public static boolean isAllTasksDone() {
        for (Task task : taskArrayList) {
            if (!task.isCompleted) {
                return false;
            }
        }
        return true;
    }
}

