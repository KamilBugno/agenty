package simulation.heating;

/**
 * Created by huber on 16.05.2017.
 */
public class AlwaysTemperatureChange implements ITemperatureAdjustingBehaviour {

    private String type = "ConstantTemperatureChange";
    private float energyChange;

    public AlwaysTemperatureChange(float energyChange) {
        this.energyChange = energyChange;
    }

    @Override
    public float getEnergyChange(float dt) {
        return energyChange * dt;
    }

    @Override
    public String getType() {
        return this.type;
    }

    public void setEnergyChangePerHour(float energyChangePerHour) {
        this.energyChange = energyChangePerHour/60;
    }
}
