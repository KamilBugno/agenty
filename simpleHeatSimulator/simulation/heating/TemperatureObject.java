package heating;

/**
 * Created by huber on 25.04.2017.
 */
public interface TemperatureObject {

    public void setTurnOnTemp(float temp);
    public void setTurnOffTemp(float temp);
    public void transformTemperature(Room room);
}
