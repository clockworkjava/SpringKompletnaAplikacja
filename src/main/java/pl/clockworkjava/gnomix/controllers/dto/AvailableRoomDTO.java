package pl.clockworkjava.gnomix.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.clockworkjava.gnomix.domain.room.BedType;
import pl.clockworkjava.gnomix.domain.room.Room;

import java.util.List;

public class AvailableRoomDTO {

    private final String number;
    private final long id;
    private final List<BedType> beds;
    private final int size;

    public AvailableRoomDTO(String number, long id, List<BedType> beds, int size) {
        this.number = number;
        this.id = id;
        this.beds = beds;
        this.size = size;
    }

    public AvailableRoomDTO(Room room) {
        this.number = room.getNumber();
        this.id = room.getId();
        this.beds = room.getBeds();
        this.size = room.getSize();
    }

    @JsonProperty("roomNumber")
    public String getNumber() {
        return number;
    }

    public long getId() {
        return id;
    }

    public List<BedType> getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }
}
