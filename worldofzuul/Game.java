package worldofzuul;

import java.util.HashMap;

public class Game {
    private final Parser parser;
    public Room currentRoom;
    public Task currentTask;

    private static Game game_instance = null;


    private Game() {
        createRooms();
        parser = new Parser();
        Inventory.getInstance();
    }

    public static Game getInstance() {
        if (game_instance == null)
            game_instance = new Game();

        return game_instance;
    }


    private void createRooms() {
        Room home = new Room("Togonese Village", "You are now in the village", 10);
        Room waterSource = new WaterSource("Well", "You are now by the water source. Here you can refill your water bottle", 30);
        Room fnRoom = new FnRoom("United Nation Tent", "You are now in the FN-room. Here you can accept or complete tasks", 10);
        Room exploreRoom = new RoomExplore("Wilderness","You are now out exploring, looking for materials",20);

        home.setExits(new HashMap<>() {{
            put("water", waterSource);
            put("fn", fnRoom);
            put("explore", exploreRoom);
        }});

        waterSource.setExits(new HashMap<>() {{
            put("home", home);
        }});

        fnRoom.setExits(new HashMap<>() {{
            put("home", home);
        }});

        exploreRoom.setExits(new HashMap<>() {{
            put("home",home);
        }});

        currentRoom = home;
    }

    public void play() {
        printWelcome();


        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
            if (Inventory.getWater() == 0 && !currentRoom.getName().equals("Well") && !canMove()) {
                break;
            }
            if (FnRoom.isAllTasksDone()){
                youWin();
                break;
            }
        }
        System.out.println("Thank you for playing. Goodbye.");
    }

    private boolean canMove() {
        boolean canMove = true;
        for (Room room : currentRoom.getExits().values()) {
            canMove = room.getWaterCost() <= Inventory.getWater();
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
                if (Inventory.getItems().isEmpty()) {
                    System.out.println("Your inventory is empty.");
                } else {
                    System.out.println("Your inventory contains the following items:");
                    Inventory.itemsToString();
                }
            }
            case SEARCH -> {
                if (!currentRoom.getName().equals("Wilderness")) {
                    System.out.println("You can't search in here");
                } else {
                    ((RoomExplore)currentRoom).collectItem();
                }
            }
            case GIVE -> {
                // For testing purposes
                if (command.hasSecondWord()) {
                    Inventory.addItem(command.getSecondWord(), 1);
                } else {
                    System.out.println("Missing 2nd argument");
                }
            }
            case REMOVE -> {
                // For testing purposes
                if (command.hasSecondWord()) {
                    Inventory.removeItem(command.getSecondWord(), 1);
                } else {
                    System.out.println("Missing 2nd argument");
                }
            }
            case TASK -> {
                if (currentTask == null) System.out.println("You have no task");
                else System.out.println(currentTask);
            }
            case ACCEPTTASK -> {
                if (!currentRoom.getName().equals("United Nation Tent")) {
                    System.out.println("Not in FN room");
                    return false;
                }
                ((FnRoom) currentRoom).giveTask();
                System.out.println(((FnRoom) currentRoom).currentTask.getDescription());
            }
            case COMPLETETASK -> {
                if (!currentRoom.getName().equals("United Nation Tent")) {
                    System.out.println("Not in FN room");
                    return false;
                }
                if (((FnRoom) currentRoom).currentTask.completeTask()) currentTask = null;
            }
            case FILL -> {
                if (!currentRoom.getName().equals("Well")) {
                    System.out.println("Not by a water source");
                    return false;
                } else {
                    System.out.println("You fill your water bottle.");
                    Inventory.setWater(100);
                }
            }
            case QUIT -> wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander around Togo.\n");
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
            if (currentRoom.getExit("water") != null && Inventory.getItem("pipe") != null)
                ((WaterSource) currentRoom.getExit("water")).setWaterDiscount();
            Inventory.setWater(Inventory.getWater() - nextRoom.getWaterCost());
            if (Inventory.getWater() == 0 && !currentRoom.getName().equals("Well")) {
                youLose();
                return;
            }
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private void youLose() {
        System.out.println("\nYou have run out of water and can no longer continue. Try again.");
    }

    private void youWin(){
        System.out.println("\nYou have won the game");
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
