package pl.edu.agh.agenty.model;

import pl.edu.agh.agenty.model.heating.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Room room0 = new Room(0, 0, 0, 4, 4, 40);
        Room room1 = new Room(1, 4, 0, 4, 4, 25);
        Room room2 = new Room(2, 0, 4, 7, 4, 5);
        Room room3 = new Room(3, 7, 4, 1, 4, 35);
//        room0.addEffector(new Effector(new AlwaysTemperatureChange(0.1f)));

        room0.addEffector(new Effector(0, null, new AlwaysTemperatureChange(-0.1f)));
        room3.addEffector(new Effector(0, null, new AlwaysTemperatureChange(0.05f)));

        Connection connection0 = new Connection(room0, room1, 4.0f);
        Connection connection1 = new Connection(room0, room2, 4.0f);
        Connection connection2 = new Connection(room1, room2, 3.0f);
        Connection connection3 = new Connection(room1, room3, 1.0f);
        Connection connection4 = new Connection(room2, room3, 4.0f);

        Set<Room> rooms = new HashSet<>();
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        Set<Connection> connections = new HashSet<>();
        connections.add(connection0);
        connections.add(connection1);
        connections.add(connection2);
        connections.add(connection3);
        connections.add(connection4);

        World world = new World(rooms, connections);
        world.printStatus();

        File dataFile = new File("./simpleHeatSimulator/src/main/visualization/data.js");
        PrintWriter datajs = new PrintWriter(dataFile);
        datajs.append("var world = [").append(world.getJsonRooms()).append("];\n");
        datajs.println("var steps = [");

        System.out.println("[" + world.getJsonStatus() + "],");
        datajs.println("[" + world.getJsonStatus() + "],");

        for (int i = 0; i < 150; i++) {
            world.step(60);
            System.out.println("[" + world.getJsonStatus() + "],");
            datajs.println("[" + world.getJsonStatus() + "],");
        }

        datajs.println("];");
        datajs.close();
    }
}
