package simulation.heating;

import java.util.HashMap;
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
        HashMap<Room, Float> energyChanges = new HashMap<>();
        rooms.forEach(room -> energyChanges.put(room, 0.0f));

        connections.forEach(connection -> {
            float energyChange = connection.energyToExchange(dt);
//            System.out.printf("energy change between %d and %d: %f%n", connection.getRoom1().getId(), connection.getRoom2().getId(), energyChange);
            energyChanges.put(connection.getRoom1(), energyChanges.get(connection.getRoom1()) + energyChange);
            energyChanges.put(connection.getRoom2(), energyChanges.get(connection.getRoom2()) - energyChange);
        });
//        System.out.println(energyChanges);
        energyChanges.forEach((room, change) -> room.changeTempByEnergy(change));
    }

    public String getJsonStatus() {
        StringBuilder sb = new StringBuilder();
        rooms.forEach(room -> sb.append(String.format(Locale.US, "%.1f, ", room.getTempCelsius())));
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
//        System.out.println(sb);
    }

}
