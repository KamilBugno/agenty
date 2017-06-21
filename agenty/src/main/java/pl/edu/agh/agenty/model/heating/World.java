package pl.edu.agh.agenty.model.heating;

import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

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
            energyChanges.put(connection.getRoom1(), energyChanges.get(connection.getRoom1()) + energyChange);
            energyChanges.put(connection.getRoom2(), energyChanges.get(connection.getRoom2()) - energyChange);
        });

        rooms.forEach(room -> energyChanges.put(room, energyChanges.get(room) + room.effectorsEnergyChange(dt)));
        energyChanges.forEach(Room::changeTempByEnergy);
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public Set<Connection> getConnections() {
        return connections;
    }

    public String getJsonStatus() {
        return rooms.stream()
                .map(room -> String.format(Locale.US, "%.1f", room.getTempCelsius()))
                .collect(Collectors.joining(", "));
    }

    public String getJsonRooms() {
        return rooms.stream()
                .map(room -> String.format(Locale.US, "{x: %.1f, y: %.1f, width: %.1f, height: %.1f},", room.getX(), room.getY(), room.getWidth(), room.getHeight()))
                .collect(Collectors.joining(", "));
    }

    public void printStatus() {
        System.out.println(rooms.stream()
                .map(Room::getStatus)
                .collect(Collectors.joining("; ")));
    }

}
