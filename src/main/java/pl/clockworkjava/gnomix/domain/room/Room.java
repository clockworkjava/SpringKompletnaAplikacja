package pl.clockworkjava.gnomix.domain.room;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {
    private final String number;
    private final List<BedType> beds;
    private final int size;

    public Room(String number, List<BedType> beds) {

        if (beds == null) {
            throw new IllegalArgumentException("Beds list can not be null");
        }

        this.number = number;

        List<BedType> bedsField = new ArrayList<>(beds);
        this.beds = bedsField;

        this.size = this.beds.stream().mapToInt(BedType::getSize).sum();
    }
}
