package simulation.heating;

import simulation.SendHttpUtils;
import spark.Service;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import static spark.Service.ignite;

/**
 * Created by huber on 21.06.2017.
 */
public class Sensor extends Device {
    private Room room;
    private Service http;

    public Sensor(Room room) {
        super(room.getId());
        this.room = room;
        registerDevice(room.getId(), room.getId());
    }

    @Override
    protected void registerDevice(int deviceId, int locationId) {
        try {
            SendHttpUtils.register("S", Inet4Address.getLocalHost().getHostAddress(), deviceId, locationId);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void startServer(int id) {
        http = ignite();
        http.port(7000 + id);
        http.get("/", (req, res) -> {
            String hello = "Hi, i'm sensor from room with id: " + this.room.getId();
            return hello;
        });
        http.get("/tempCelsius", (req, res) -> this.room.getTempCelsius());
        http.get("/tempKelvin", (req, res) -> this.room.getTempKelvin());
        System.out.println("Room - id: " + id + ". On port: " + (http.port()));
    }
}
