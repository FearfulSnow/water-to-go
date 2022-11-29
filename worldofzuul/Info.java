package worldofzuul;
import java.lang.Math;

public class Info {
    private String description;
    private final int id;
    private int infoPoint;

    public Info(int id, int infoPoints, String description) {
        this.description = description;
        this.id = id;
        this.infoPoint = infoPoints;
    }

    @Override
    public String toString() {
        return "Did you know... " + description;
    }
}
