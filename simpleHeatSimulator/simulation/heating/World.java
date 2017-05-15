package heating;

import java.util.Locale;
import java.util.Set;

/**
 * Created by huber on 25.04.2017.
 */
public class World {

    private Set<Room> rooms;
    private Set<Connection> connections;

    public World(Set<Room> rooms, Set<Connection> connections) {
        this.rooms = rooms;
        this.connections = connections;
    }

    public void step(float dt) {
        connections.forEach(connection -> {
//            connection.printWho();
            connection.exchange(dt);
        });
        rooms.forEach(room -> {
            room.applyTempSystem();
        });
    }

    public String getJsonStatus() {
        StringBuilder sb = new StringBuilder();
        rooms.forEach(room -> sb.append(String.format(Locale.US, "%.1f, ", room.getTemperature())));
        return sb.toString();
    }

    public String getJsonRooms() {
        StringBuilder sb = new StringBuilder();
        rooms.forEach(room -> sb.append(String.format(Locale.US, "{x: %.1f, y: %.1f, width: %.1f, height: %.1f},", room.getX(), room.getY(), room.getWidth(), room.getHeight())));
        return sb.toString();
    }

    public void printStatus() {
        StringBuilder sb = new StringBuilder();
        rooms.forEach(room -> sb.append(room.getStatus() + "; "));
        System.out.println(sb);
    }

}
