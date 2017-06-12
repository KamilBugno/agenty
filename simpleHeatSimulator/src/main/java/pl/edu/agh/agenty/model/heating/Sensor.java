package pl.edu.agh.agenty.model.heating;

/**
 * Created by Jakub Janusz on 12.06.2017.
 */
public class Sensor implements Device {
    private final int deviceId;
    private final String callback;

    public Sensor(int deviceId, String callback) {
        this.deviceId = deviceId;
        this.callback = callback;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public String getCallback() {
        return callback;
    }
}
