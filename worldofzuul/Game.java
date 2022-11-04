package worldofzuul;

import java.util.ArrayList;
import java.util.HashMap;

public class Game
{
    private final Parser parser;
    private Room currentRoom;
    public Inventory inventory;

    public Task currentTask;
        

    public Game() 
    {
        createRooms();
        parser = new Parser();
        inventory = new Inventory(100);
    }


    private void createRooms()
    {
        Room outside = new Room("outside", "outside the main entrance of the university", 10);
        Room secretRoom = new Room("secret room", "in a super secret room! Shh", 10);
        Room waterSource = new Room("water source", "by a well filled with fresh water", 20);
        Room FnRoom = new FnRoom("fn room", "An encampment filled with people pretending to care.", 20);


        outside.setExits(new HashMap<>() {{
            put("secret", secretRoom);
            put("well", waterSource);
        }});

        secretRoom.setExits(new HashMap<>() {{
            put("home", outside);
        }});

        waterSource.setExits(new HashMap<>() {{
            put("home", outside);
        }});

        currentRoom = outside;
    }



    public void createTasks(){

        // adding like tasks and such to like an array list to manage them i guess? idk u figure it out einestien. t(-.-t)
        if (currentRoom instanceof FnRoom){

            ((FnRoom) currentRoom).setTaskArrayList(new ArrayList<>(){{
                add(new Task(0, "Welcome to the FN encampment, we're short on supplies at the moment, please find us 5 AAA batteries. We will reward you with pipe.", new Item("5 AAA batteries", 1), new Item("pipe", 1)));
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

                for (Task task:((FnRoom) currentRoom).getTaskArrayList()) {

                    if (!currentTask.isCompleated){


                    }


                }
            }


        }




    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
            if (inventory.getWater() == 0 && !currentRoom.getName().equals("water source") && !canMove()) {
                break;
            }
        }
        System.out.println("Thank you for playing. Goodbye.");
    }

    private boolean canMove() {
        boolean canMove = true;
        for (Room room : currentRoom.getExits().values()) {
            canMove = room.getWaterCost() <= inventory.getWater();
            if (canMove) return true;
        }

        return canMove;
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN -> {
                System.out.println("I don't know what you mean...");
                return false;
            }
            case HELP -> printHelp();
            case GO -> goRoom(command);
            case INVENTORY -> {
                if (inventory.getItems().isEmpty()) {
                    System.out.println("Your inventory is empty.");
                } else {
                    System.out.println("Your inventory contains the following items:");
                    inventory.itemsToString();
                }
            }
            case GIVE -> {
                // For testing purposes
                if (command.hasSecondWord()) {
                    inventory.addItem(command.getSecondWord(), 1);
                } else {
                    System.out.println("Missing 2nd argument");
                }
            }
            case REMOVE -> {
                // For testing purposes
                if (command.hasSecondWord()) {
                    inventory.removeItem(command.getSecondWord(), 1);
                } else {
                    System.out.println("Missing 2nd argument");
                }
            }
            case ACCEPTTASK -> {
                if(!currentRoom.getName().equals("fn room"))return false;

            }
            case COMPLETETASK -> {
                if(!currentRoom.getName().equals("fn room"))return false;
                System.out.println("din mor");
            }
            case QUIT -> wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander around at the university.\n");
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            inventory.setWater(inventory.getWater() - nextRoom.getWaterCost());
            System.out.printf("You have %d water remaining.\n", inventory.getWater());
            if (inventory.getWater() == 0 && !currentRoom.getName().equals("water source")) {
                youLose();
                return;
            }
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private void youLose() {
        System.out.println("You have run out of water and can no longer continue. Try again.");
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
