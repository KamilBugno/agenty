package pl.edu.agh.agenty.model.heating;

/**
 * Created by huber on 25.04.2017.
 */
public class Connection {

    private float connector; // length of connection * height of room / thickness of wall
    private Room room1;
    private Room room2;

    public Connection(Room room1, Room room2, float lengthOfConnection) {
        this.room1 = room1;
        this.room2 = room2;
        this.connector = Consts.K * lengthOfConnection * Consts.HEIGHT / Consts.D;

        room1.addConnection(this);
        room2.addConnection(this);
    }

    public Room getRoom1() {
        return room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public float energyToExchange(float dt) {
        float de = dt * connector * (room2.getTempKelvin() - room1.getTempKelvin());
        return de;
    }
}
