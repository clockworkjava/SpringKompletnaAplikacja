package pl.clockworkjava.gnomix.domain.room;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class RoomRepository {

    public List<Room> findAll() {

        Room room = new Room("1408", Arrays.asList(BedType.SINGLE));
        Room r = new Room("1409", Arrays.asList(BedType.DOUBLE));

        return Arrays.asList(room, r);
    }
}
