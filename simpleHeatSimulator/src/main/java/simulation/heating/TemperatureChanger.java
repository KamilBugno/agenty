package simulation.heating;

import simulation.TempUtils;
import spark.Service;

import java.util.Arrays;

import static spark.Service.*;
import static spark.Spark.*;

/**
 * Created by huber on 09.05.2017.
 */
public class TemperatureChanger {
    private int id;
    private ITemperatureAdjustingBehaviour behaviour;
    private Service http;

    public TemperatureChanger(int id, ITemperatureAdjustingBehaviour behaviour) {
        this.id = id;
        this.behaviour = behaviour;

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

        System.out.println("TempChanger - id: " + this.id + ". On port: " + (http.port()));
    }

    public float getEnergyChange(float dt) {
        return behaviour.getEnergyChange(dt);
    }
}
