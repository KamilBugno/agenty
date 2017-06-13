package simulation;

import simulation.heating.*;
import spark.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static spark.Service.ignite;
import static spark.Spark.*;

public class Main {
    private int step = 60;
    Set<Room> rooms;
    Set<Connection> connections;
    Set<TemperatureChanger> tempChangers;
    World world;
    Service http;

    public Main() {
        Room room0 = new Room(0, 0, 0, 4, 4, 40);
        Room room1 = new Room(1, 4,0,4,4, 25);
        Room room2 = new Room(2, 0,4,7,4, 5);
        Room room3 = new Room(3, 7,4,1,4, 35);

        TemperatureChanger tch0 = new TemperatureChanger(0, new AlwaysTemperatureChange(-0.1f));
        TemperatureChanger tch1 = new TemperatureChanger(1, new AlwaysTemperatureChange(-0.1f));

        room0.addEffector(tch0);
        room3.addEffector(tch1);

        tempChangers = new HashSet<>();
        tempChangers.add(tch0);
        tempChangers.add(tch1);

        Connection connection0 = new Connection(room0, room1, 4.0f);
        Connection connection1 = new Connection(room0, room2, 4.0f);
        Connection connection2 = new Connection(room1, room2, 3.0f);
        Connection connection3 = new Connection(room1, room3, 1.0f);
        Connection connection4 = new Connection(room2, room3, 4.0f);

        rooms = new HashSet<>();
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        connections = new HashSet<>();
        connections.add(connection0);
        connections.add(connection1);
        connections.add(connection2);
        connections.add(connection3);
        connections.add(connection4);

        world = new World(rooms, connections);
        world.printStatus();

        http = ignite().port(4567);
        staticFiles.location("/");
        get("/", (res, req) -> "Hello");
    }

    public void work() {
//        while(true) {
//            world.step(step);
//            System.out.println("[" + world.getJsonStatus() + "],");
//
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        main.work();

//        room0.addEffector(new TemperatureChanger(new AlwaysTemperatureChange(0.1f)));
    }
}
