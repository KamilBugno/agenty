package pl.edu.agh.agents;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class Simulation {

    public static void main(String[] args) throws FileNotFoundException {
        pl.edu.agh.agents.simulation.Room room0 = new pl.edu.agh.agents.simulation.Room(0, 0, 0, 4, 4, 40);
        pl.edu.agh.agents.simulation.Room room1 = new pl.edu.agh.agents.simulation.Room(1, 4,0,4,4, 25);
        room1.addEffector(new pl.edu.agh.agents.simulation.TemperatureChanger(new pl.edu.agh.agents.simulation.AlwaysTemperatureChange(0.02f)));
        pl.edu.agh.agents.simulation.Room room2 = new pl.edu.agh.agents.simulation.Room(2, 0,4,7,4, 5);
        pl.edu.agh.agents.simulation.Room room3 = new pl.edu.agh.agents.simulation.Room(3, 7,4,1,4, 35);

        pl.edu.agh.agents.simulation.Connection connection0 = new pl.edu.agh.agents.simulation.Connection(room0, room1, 4.0f);
        pl.edu.agh.agents.simulation.Connection connection1 = new pl.edu.agh.agents.simulation.Connection(room0, room2, 4.0f);
        pl.edu.agh.agents.simulation.Connection connection2 = new pl.edu.agh.agents.simulation.Connection(room1, room2, 3.0f);
        pl.edu.agh.agents.simulation.Connection connection3 = new pl.edu.agh.agents.simulation.Connection(room1, room3, 1.0f);
        pl.edu.agh.agents.simulation.Connection connection4 = new pl.edu.agh.agents.simulation.Connection(room2, room3, 4.0f);

        Set<pl.edu.agh.agents.simulation.Room> rooms = new LinkedHashSet<>();
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        Set<pl.edu.agh.agents.simulation.Connection> connections = new HashSet<>();
        connections.add(connection0);
        connections.add(connection1);
        connections.add(connection2);
        connections.add(connection3);
        connections.add(connection4);

        pl.edu.agh.agents.simulation.World world = new pl.edu.agh.agents.simulation.World(rooms, connections);
        world.printStatus();

        String env_path = "./environment/";
        LinkedList<File> files = new LinkedList<>();
        LinkedList<pl.edu.agh.agents.simulation.Room> room_list = new LinkedList<>();
        room_list.add(room0);
        room_list.add(room1);
        room_list.add(room2);
        room_list.add(room3);

        for (int i = 0; i < rooms.size(); i++) {
            File f = new File(env_path + "room_" + i);
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            files.add(f);
        }


        for(int i = 0; i<100; i++) {
            world.step(60);
            for (int j = 0; j < rooms.size(); j++) {
                File file = files.get(j);
                PrintWriter printWriter = new PrintWriter(file);
                pl.edu.agh.agents.simulation.Room room = room_list.get(j);
                System.out.println("room " + j + " temp " + room.getValue());
                printWriter.write(room.getValue());
                printWriter.flush();
            }
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
