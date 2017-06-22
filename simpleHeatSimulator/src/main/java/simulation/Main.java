package simulation;

import simulation.heating.*;
import spark.ModelAndView;
import spark.Service;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static spark.Service.ignite;
import static spark.Spark.get;


public class Main {
    private int step = 60;
    private int stepCount = 0;
    private int timeSimulated = 0;
    Set<Room> rooms;
    Set<Connection> connections;
    Set<Effector> effectors;
    World world;
    Service http;

    public Main() {
        Room room0 = new Room(0, 0, 0, 4, 4, 40);
        Room room1 = new Room(1, 4,0,4,4, 25);
        Room room2 = new Room(2, 0,4,7,4, 5);
        Room room3 = new Room(3, 7,4,1,4, 35);

        Effector effector0 = new Effector(0, new AlwaysTemperatureChange(-0.1f));
        Effector effector1 = new Effector(1, new AlwaysTemperatureChange(-0.1f));

        room0.addEffector(effector0);
        room3.addEffector(effector1);

        effectors = new HashSet<>();
        effectors.add(effector0);
        effectors.add(effector1);

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
        get("/", (request, response) -> {
            return new ModelAndView(createConfigModel(), "config"); // located in resources/templates
        }, new ThymeleafTemplateEngine());
        get("/changeConfig", (req, res) -> {
            System.out.println("Nowy request!");
            System.out.println(req.queryParams("newSpeed"));
            Integer newSpeed = null;
            try {
                newSpeed = Integer.valueOf(req.queryParams("newSpeed"));
            } catch (NumberFormatException e) {
                System.out.println("Bad Number Format");
            }
            if (newSpeed != null) step = newSpeed;
            return new ModelAndView(createConfigModel(), "config"); // located in resources/templates
        }, new ThymeleafTemplateEngine());
    }

    private Map<String, Object> createConfigModel() {
        Map<String, Object> model = new HashMap<>();
        model.put("stepCount", stepCount);
        model.put("timeSimulated", timeSimulated);
        model.put("simulationSpeed", step);
        List<Object> roomsList = new ArrayList<>();
        rooms.forEach(room -> {
            Map<String, Object> roomModel = new HashMap<>();
            roomModel.put("id", room.getId());
            roomModel.put("temp", room.getTempCelsius());
            roomModel.put("x", room.getX());
            roomModel.put("y", room.getY());
            roomModel.put("width", room.getWidth());
            roomModel.put("height", room.getHeight());
            roomsList.add(roomModel);
        });
        model.put("rooms", roomsList);

        return model;
    }

    public void work() {
        while(true) {
            world.step(step);
            System.out.println("[" + world.getJsonStatus() + "],");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            stepCount++;
            timeSimulated += step;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        main.work();
    }
}
