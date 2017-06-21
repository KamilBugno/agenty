package simulation.heating;

/**
 * Created by huber on 21.06.2017.
 */
public abstract class Device {
    public Device(int id) {
        startServer(id);
        registerDevice();
    }

    protected abstract void registerDevice();

    protected abstract void startServer(int id);
}
