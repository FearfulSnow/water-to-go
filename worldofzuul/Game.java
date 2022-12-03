package worldofzuul;

import java.util.HashMap;

public class Game {
    public Room currentRoom;

    private static Game game_instance = null;


    private Game() {
        createRooms();
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
        Room exploreRoom = new RoomExplore("Wilderness","You are now out exploring, looking for materials",10);

        home.setExits(new HashMap<>() {{
            put("Well", waterSource);
            put("United Nations", fnRoom);
            put("Wilderness", exploreRoom);
        }});

        waterSource.setExits(new HashMap<>() {{
            put("Village", home);
        }});

        fnRoom.setExits(new HashMap<>() {{
            put("Village", home);
        }});

        exploreRoom.setExits(new HashMap<>() {{
            put("Village",home);
        }});

        currentRoom = home;
    }

    public String welcomeString() {
        return """
            Welcome to the World of Zuul.
            You are currently in Togo on a mission from the United Nations.
            Visit them at their tent.""";
    }

    public void goToRoom(RoomName roomName) {
        if (currentRoom.getExit(RoomName.WATER.toString()) != null && Inventory.getItem("pipe") != null)
            ((WaterSource) currentRoom.getExit(RoomName.WATER.toString())).setWaterDiscount();
        Room nextRoom = currentRoom.getExit(roomName.toString());
        currentRoom = nextRoom;
        Inventory.setWater(Inventory.getWater() - nextRoom.getWaterCost());
    }
}
