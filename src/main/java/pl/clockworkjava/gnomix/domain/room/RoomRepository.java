package pl.clockworkjava.gnomix.domain.room;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class RoomRepository {

    List<Room> rooms = new ArrayList<>();

    public RoomRepository() {
        Room room = new Room("1408", Arrays.asList(BedType.SINGLE));
        Room r = new Room("1409", Arrays.asList(BedType.DOUBLE));

        this.rooms.add(room);
        this.rooms.add(r);
    }

    public List<Room> findAll() {

        return this.rooms;

    }

    public Room createNewRoom(String roomNumber, List<BedType> beds) {
        Room r = new Room(roomNumber, beds);
        this.rooms.add(r);
        return r;
    }
}
