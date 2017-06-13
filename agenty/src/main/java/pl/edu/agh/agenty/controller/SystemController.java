package pl.edu.agh.agenty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.edu.agh.agenty.model.heating.*;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * Created by Jakub Janusz on 12.06.2017.
 */
@Controller
public class SystemController {

    private World world;

    @PostConstruct
    private void postConstruct() {
        createWorld();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getTempFromSensors();
            }
        }, 0, 60 * 1000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                simulateWorld();
            }
        }, 0, 1000);
    }

    @RequestMapping(value = "/registerDevice", method = RequestMethod.POST)
    // returns null if ok, else error message
    public @ResponseBody
    String registerDevice(@RequestParam String type,
                          @RequestParam(required = false) Float stepChange,
                          @RequestParam int deviceId,
                          @RequestParam int locationId,
                          @RequestParam String callback) {
        try {
            Device device;
            switch (type) {
                case "S":
                    device = new Sensor(deviceId, callback);
                    world.getRooms().stream()
                            .filter(room -> room.getId() == locationId).findFirst().ifPresent(room -> room.addSensor((Sensor) device));
                    break;
                case "E":
                    device = new Effector(deviceId, callback, new AlwaysTemperatureChange(stepChange));
                    world.getRooms().stream()
                            .filter(room -> room.getId() == locationId).findFirst().ifPresent(room -> room.addEffector((Effector) device));
                    break;
                default:
                    return "Unknown device type: " + type;
            }
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/temperature", method = RequestMethod.POST)
    public void setTemperature(@RequestParam int deviceId,
                               @RequestParam float temperature) {
        world.getRooms().forEach(room -> {
            Optional<Sensor> sensor = room.getSensors().stream()
                    .filter(s -> s.getDeviceId() == deviceId)
                    .findFirst();
            if (sensor.isPresent()) {
                room.setTempKelvin(temperature);
            }
        });
    }

    private void createWorld() {
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

        world = new World(rooms, connections);
    }

    private void getTempFromSensors() {
        world.getRooms().forEach(room -> {
            int sensorsAmount = room.getSensors().size();
            if (sensorsAmount > 0) {
                final int[] tempTotal = {0};
                room.getSensors().forEach(sensor -> tempTotal[0] += getTempFromSensor(sensor));
                room.setTempKelvin(tempTotal[0] / sensorsAmount);
            }
        });
    }

    private float getTempFromSensor(Sensor sensor) {
        try {
            String callback = sensor.getCallback();
            String Url = String.format("%s:%d/temp", callback, 7000 + sensor.getDeviceId());
            URL url = new URL(Url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return Float.valueOf(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    private void simulateWorld() {
        try {
            world.step(60);
            world.printStatus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
