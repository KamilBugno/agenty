package simulation.heating;

/**
 * Created by huber on 21.06.2017.
 */
public abstract class Device {
    public Device(int id) {
        startServer(id);
        registerDevice(id, id);
    }

    public Device(int deviceId, int locationId) {
        startServer(deviceId);
        registerDevice(deviceId, locationId);
    }

    protected abstract void registerDevice(int deviceId, int locationId);

    protected abstract void startServer(int id);
}
