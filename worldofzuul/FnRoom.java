package worldofzuul;

import java.util.ArrayList;

public class FnRoom extends Room{


    public FnRoom(String name, String description, int waterCost){super(name, description, waterCost);}

    private ArrayList<Task> taskArrayList = new ArrayList<>();
    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }
    public void setTaskArrayList(ArrayList<Task> taskArrayList) {
        this.taskArrayList = taskArrayList;
    }


/* for testing if shit acutally works in FnRoom class

    public static void main(String[] args) {
        System.out.println();

        FnRoom myRoom = new FnRoom("Test room", "test descrip", 100);

        myRoom.createTasks();
        System.out.println(myRoom.taskArrayList);

    }

*/

}

