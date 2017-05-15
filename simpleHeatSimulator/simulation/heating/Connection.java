package heating;

import heating.Room;

/**
 * Created by huber on 25.04.2017.
 */
public class Connection {
    private float size;

    private Room room1;
    private Room room2;

    public Connection(Room room1, Room room2, float size) {
        this.room1 = room1;
        this.room2 = room2;
        this.size = size;

        room1.addConnection(this);
        room2.addConnection(this);
    }

    public void exchange(float dt) {
        if (Math.abs(room1.getTemperature() - room2.getTemperature()) > 0.03f) {
            if (room1.getTemperature() < room2.getTemperature()) {
                room1.transferTemperatureTo(room2, size);
            } else {
                room2.transferTemperatureTo(room1, size);
            }
        }
    }

//    public void printWho() {
//        System.out.println(room1.getId() + " " + room2.getId());
//    }
}
