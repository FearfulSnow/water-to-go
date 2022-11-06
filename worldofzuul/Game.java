package worldofzuul;

import java.util.HashMap;

public class Game {
    private final Parser parser;
    private Room currentRoom;
    public Inventory inventory;

    public Task currentTask;


    public Game() {
        createRooms();
        parser = new Parser();
        inventory = new Inventory(100);
    }


    private void createRooms() {
        Room home = new Room("home", "You are now in the village", 10);
        Room waterSource = new Room("water source", "You are now by the water source. Here you can refill your water bottle", 20);
        Room fnRoom = new FnRoom("fn room", "You are now in the FN-room. Here you can accept or complete tasks", 20);


        home.setExits(new HashMap<>() {{
            put("well", waterSource);
            put("fn", fnRoom);
        }});

        waterSource.setExits(new HashMap<>() {{
            put("home", home);
        }});

        fnRoom.setExits(new HashMap<>() {{
            put("home", home);
        }});

        currentRoom = home;
    }

    public void play() {
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

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) {
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
            case TASK -> {
                if (currentTask == null) System.out.println("You have no task");
                else System.out.println(currentTask);
            }
            case ACCEPTTASK -> {
                if (!currentRoom.getName().equals("fn room")) {
                    System.out.println("Not in FN room");
                    return false;
                }
                currentTask = ((FnRoom) currentRoom).giveTask(((FnRoom) currentRoom).getCurrentTaskIndex());
                System.out.println(currentTask.getDescription());
            }
            case COMPLETETASK -> {
                if (!currentRoom.getName().equals("fn room")) {
                    System.out.println("Not in FN room");
                    return false;
                }
                if (currentTask.isRequirementsMet(inventory)) {
                    ((FnRoom) currentRoom).completeTask(((FnRoom) currentRoom).getCurrentTaskIndex());
                    // maybe make additional signature for function that takes Item
                    inventory.removeItem(currentTask.getRequirement().getName(), currentTask.getRequirement().getQuantity());
                    inventory.addItem(currentTask.getReward().getName(), currentTask.getReward().getQuantity());
                    currentTask = null;
                    System.out.println("Well done! You have completed the task. Feel free to accept the next one!");
                } else {
                    System.out.println("Requirements not met");
                }
            }
            case QUIT -> wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander around at the university.\n");
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
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

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
}
