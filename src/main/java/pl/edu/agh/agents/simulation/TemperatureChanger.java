package pl.edu.agh.agents.simulation;

/**
 * Created by huber on 09.05.2017.
 */
public class TemperatureChanger {
    private ITemperatureAdjustingBehaviour behaviour;

    public TemperatureChanger(ITemperatureAdjustingBehaviour behaviour) {
        this.behaviour = behaviour;
    }

    public float getEnergyChange(float dt) {
        return behaviour.getEnergyChange(dt);
    }
}
