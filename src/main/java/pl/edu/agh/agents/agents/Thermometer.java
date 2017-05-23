package pl.edu.agh.agents.agents;

public class Thermometer extends Sensor {


    public Thermometer(String filePath) {
        this.connector = new LowLevelConnector(filePath);
    }

    public double getTemperature() {
        return this.connector.getState();
    }

}
