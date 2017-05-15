package heating;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by huber on 25.04.2017.
 */
public class Room {
    private int id;
    private float temperature;
    private float capacity;
    private float x;
    private float y;
    private float width;
    private float height;

    private Set<Connection> connectionSet;
    private Set<TemperatureChanger> tempChangers;

    public Room(int id, float x, float y, float width, float height, float temperature) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.temperature = temperature;
        this.capacity = width*height;

        this.connectionSet = new HashSet<>();
        this.tempChangers = new HashSet<>();
    }

    public String getStatus() {
        return String.format("%d. %.1f", id, temperature);
    }

    public void printStatus() {
        System.out.println(getStatus());
    }

    protected void addConnection(Connection connection) {
        connectionSet.add(connection);
    }

    protected void transferTemperatureTo(Room otherRoom, float wallSize) {
//        System.out.format("BEFORE. this temp: %f, other temp: %f%n", temperature, otherRoom.getTemperature());
        float diff = 0.02f*wallSize;
//        System.out.format("diff: %f%n", diff);
        setTemperature(temperature+diff);
        otherRoom.setTemperature(otherRoom.getTemperature()-diff);
//        System.out.format("AFTER. this temp: %f, other temp: %f%n", temperature, otherRoom.getTemperature());
    }

    public void applyTempSystem() {
        tempChangers.forEach(TemperatureChanger::transferTemperature);
    }

    public int getId() {
        return id;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
