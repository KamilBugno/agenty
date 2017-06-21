package simulation.heating;

import spark.Service;

import java.util.HashSet;
import java.util.Set;

import static spark.Service.*;

/**
 * Created by huber on 25.04.2017.
 */
public class Room {
    private int id;
    private float tempKelvin;
    private float x;
    private float y;
    private float width;
    private float height;
    private float capacity;
    private Sensor sensor;


    private Set<Connection> connectionSet;
    private Set<TemperatureChanger> tempChangers;

    public Room(int id, float x, float y, float width, float height, float tempCelsius) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.tempKelvin = celsiusToKelvin(tempCelsius);
        this.capacity = width * height * Consts.HEIGHT;

        this.connectionSet = new HashSet<>();
        this.tempChangers = new HashSet<>();
        this.sensor = new Sensor(this);
    }

    public String getStatus() {
        return String.format("%d. %.1f", id, kelvinToCelsius(tempKelvin));
    }

    protected void addConnection(Connection connection) {
        connectionSet.add(connection);
    }

    public int getId() {
        return id;
    }

    public float getTempCelsius() {
        return kelvinToCelsius(tempKelvin);
    }

    public void setTempCelsius(float tempCelsius) {
        this.tempKelvin = celsiusToKelvin(tempCelsius);
    }

    public float getTempKelvin() {
        return tempKelvin;
    }

    public void setTempKelvin(float tempKelvin) {
        this.tempKelvin = tempKelvin;
    }

    public void changeTempByEnergy(float deltaEnergy) {
        double energy = capacity * Consts.TRANSFER_CONSTANT * tempKelvin;
        double newEnergy = energy + deltaEnergy;
        double newTemp = newEnergy / (capacity * Consts.TRANSFER_CONSTANT);
//        System.out.format("delta energy: %f, capacity: %f%n old energy: %f, newEnergy: %f%n old temp: %f, new temp: %f%n", deltaEnergy, capacity, energy, newEnergy, tempKelvin, newTemp);
        this.tempKelvin = (float) newTemp;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getCapacity() {
        return capacity;
    }

    private float celsiusToKelvin(float tempCelsius) {
        return tempCelsius + 274.15f;
    }

    private float kelvinToCelsius(float tempKelvin) {
        return tempKelvin - 274.15f;
    }

    public void addEffector(TemperatureChanger temperatureChanger) {
        tempChangers.add(temperatureChanger);
    }

    public float effectorsEnergyChange(float dt) {
        float change = 0.0f;
        for (TemperatureChanger tCh : tempChangers) {
            change += tCh.getEnergyChange(dt);
        }
        return change;
    }
}
