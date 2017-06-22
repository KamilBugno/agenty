package simulation.heating;

import simulation.SendHttpUtils;
import simulation.TempUtils;
import spark.Service;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Arrays;

import static spark.Service.*;
import static spark.Spark.*;

/**
 * Created by huber on 09.05.2017.
 */
public class Effector extends Device{
    private int id;
    private ITemperatureAdjustingBehaviour behaviour;
    private Service http;
    private Room room;

    public Effector(int id, ITemperatureAdjustingBehaviour behaviour) {
        super(id);
        this.id = id;
        this.behaviour = behaviour;

        System.out.println("TempChanger - id: " + this.id + ". On port: " + (http.port()));
    }

    @Override
    protected void registerDevice(int deviceId, int locationId) {
        try {
            SendHttpUtils.register("E", Inet4Address.getLocalHost().getHostAddress(), deviceId, locationId);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void startServer(int id) {
        http = ignite();
        http.port(6000 + id);
        http.get("/", (req, res) -> {
            String hello = "Hi, i'm effector with id: " + this.id;
            return hello;
        });
        http.get("/energyChangePerHour", (req, res) -> behaviour.getEnergyChange(3600));
        http.get("/effectorType", (req, res) -> behaviour.getType());
        http.get("/setConstantEnergyChangePerHour", (req, res) -> {
            float newVal = Float.parseFloat(req.queryParams("energy"));

            if (this.behaviour instanceof AlwaysTemperatureChange) {
                AlwaysTemperatureChange b = (AlwaysTemperatureChange) this.behaviour;
                b.setEnergyChangePerHour(newVal);
            } else {
                this.behaviour = new AlwaysTemperatureChange(newVal);
            }

            return "EnergyChangePerHour changed";
        });
    }

    public float getEnergyChange(float dt) {
        return behaviour.getEnergyChange(dt);
    }

    public void addRoom(Room room) {
        this.room = room;
        registerDevice(id, room.getId());
    }
}
