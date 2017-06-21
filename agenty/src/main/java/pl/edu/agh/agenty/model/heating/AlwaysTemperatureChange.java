package pl.edu.agh.agenty.model.heating;

/**
 * Created by huber on 16.05.2017.
 */
public class AlwaysTemperatureChange implements ITemperatureAdjustingBehaviour {

    private float energyChange;

    public AlwaysTemperatureChange(float energyChange) {
        this.energyChange = energyChange;
    }

    @Override
    public float getEnergyChange(float dt) {
        return energyChange * dt;
    }
}
