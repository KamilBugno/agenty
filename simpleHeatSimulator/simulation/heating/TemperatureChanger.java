package simulation.heating;

/**
 * Created by huber on 09.05.2017.
 */
public class TemperatureChanger {
    private ITemperatureAdjustingBehaviour behaviour;
    private Room room;

    public TemperatureChanger(Room room, ITemperatureAdjustingBehaviour behaviour) {
        this.behaviour = behaviour;
        this.room = room;
    }

    public float getEnergyChange() {
        return behaviour.getEnergyChange();
    }
}
