package simulation.heating;

/**
 * Created by huber on 09.05.2017.
 */
public class Heater implements TemperatureChanger {
    private float turnOnTemp;
    private float turnOffTemp;
    private float tempOn;

    private Room room;

    public Heater(float turnOnTemp, float turnOffTemp, float tempOn, Room room) {
        if (turnOnTemp > turnOffTemp) {
            throw new RuntimeException();
        }
        this.turnOnTemp = turnOnTemp;
        this.turnOffTemp = turnOffTemp;
        this.tempOn = tempOn;
        this.room = room;
    }

    @Override
    public void transferTemperature() {

    }
}
