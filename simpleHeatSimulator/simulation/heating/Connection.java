package simulation.heating;

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
        this.connector = lengthOfConnection * Consts.HEIGHT / Consts.D;

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
//        System.out.printf("AAAenergy change between %d and %d: %f%n", room1.getId(), room2.getId(), de);
//        System.out.printf("%f = %f * %f * (%f - %f)%n", de, dt, connector, room2.getTempKelvin(), room1.getTempKelvin());
        return de;
    }
}
