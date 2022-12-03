package worldofzuul;

public enum RoomName {
    HOME("Village"), FN("United Nations"), EXPLORE("Wilderness"), WATER("Well");
    private final String roomName;
    RoomName(String roomName) {
        this.roomName = roomName;
    }

    public String toString() {
        return roomName;
    }
}
