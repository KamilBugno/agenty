package pl.edu.agh.agenty.model.heating;

/**
 * Created by huber on 09.05.2017.
 */
public class Effector implements Device {
    private final int deviceId;
    private final String callback;
    private ITemperatureAdjustingBehaviour behaviour;

    public Effector(int deviceId, String callback, ITemperatureAdjustingBehaviour behaviour) {
        this.deviceId = deviceId;
        this.callback = callback;
        this.behaviour = behaviour;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public String getCallback() {
        return callback;
    }

    public float getEnergyChange(float dt) {
        return behaviour.getEnergyChange(dt);
    }
}
