package simulation.heating;

/**
 * Created by huber on 21.06.2017.
 */
public abstract class Device {

    public Device(int deviceId) {
        startServer(deviceId);
    }

    protected abstract void registerDevice(int deviceId, int locationId);

    protected abstract void startServer(int id);
}
