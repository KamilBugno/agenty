package simulation;

import simulation.heating.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by huber on 03.06.2017.
 */
public class ImmediateSimulation {

    public static void main(String[] args) throws FileNotFoundException {
        Room room0 = new Room(0, 0, 0, 4, 4, 40);
        Room room1 = new Room(1, 4,0,4,4, 25);
        Room room2 = new Room(2, 0,4,7,4, 5);
        Room room3 = new Room(3, 7,4,1,4, 35);
//        room0.addEffector(new TemperatureChanger(new AlwaysTemperatureChange(0.1f)));

        room0.addEffector(new TemperatureChanger(0, new AlwaysTemperatureChange(-0.1f)));
        room3.addEffector(new TemperatureChanger(1, new AlwaysTemperatureChange(0.05f)));

        Connection connection0 = new Connection(room0, room1, 4.0f);
        Connection connection1 = new Connection(room0, room2, 4.0f);
        Connection connection2 = new Connection(room1, room2, 3.0f);
        Connection connection3 = new Connection(room1, room3, 1.0f);
        Connection connection4 = new Connection(room2, room3, 4.0f);

//        Set<Room> rooms = new HashSet<>();
        Map<Integer, Room> rooms = new HashMap<>();
        rooms.put(0, room0);
        rooms.put(1, room1);
        rooms.put(2, room2);
        rooms.put(3, room3);

        Map<Integer, Connection> connections = new HashMap<>();
        connections.put(0, connection0);
        connections.put(1, connection1);
        connections.put(2, connection2);
        connections.put(3, connection3);
        connections.put(4, connection4);

        World world = new World(new HashSet<Room>(), new HashSet<Connection>());
//        World world = new World(rooms.entrySet(), connections.entrySet());
        world.printStatus();

        File dataFile = new File("./simpleHeatSimulator/visualization/data.js");
        PrintWriter datajs = new PrintWriter(dataFile);
        datajs.append("var world = [").append(world.getJsonRooms()).append("];\n");
        datajs.println("var steps = [");

        System.out.println("[" + world.getJsonStatus() + "],");
        datajs.println("[" + world.getJsonStatus() + "],");

        for(int i = 0; i<150;i++) {
            world.step(60);
            System.out.println("[" + world.getJsonStatus() + "],");
            datajs.println("[" + world.getJsonStatus() + "],");
        }

        datajs.println("];");
        datajs.close();
    }

}

