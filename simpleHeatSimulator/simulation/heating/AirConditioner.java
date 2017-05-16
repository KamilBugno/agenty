package simulation.heating;

/**
 * Created by huber on 09.05.2017.
 */
public class AirConditioner implements TemperatureChanger {
    private float turnOnTemp;
    private float turnOffTemp;
    private float tempOn;

    private Room room;

    public AirConditioner(float turnOnTemp, float turnOffTemp, float tempOn, Room room) {
        if (turnOffTemp > turnOnTemp) {
            throw new RuntimeException();
        }

        this.turnOnTemp = turnOnTemp;
        this.turnOffTemp = turnOffTemp;
        this.tempOn = tempOn;
        this.room = room;
    }

    public void transferTemperature() {

    }
}
