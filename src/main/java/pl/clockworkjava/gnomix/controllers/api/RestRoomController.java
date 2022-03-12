package pl.clockworkjava.gnomix.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.clockworkjava.gnomix.controllers.dto.AvailableRoomDTO;
import pl.clockworkjava.gnomix.domain.reservation.ReservationService;
import pl.clockworkjava.gnomix.domain.room.Room;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestRoomController {

    private final ReservationService reservationService;

    @Autowired
    public RestRoomController(ReservationService service) {
        this.reservationService = service;
    }

    @GetMapping("api/getFreeRooms")
    public List<AvailableRoomDTO> getAvailableRooms(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
            int size
    ) {
        List<Room> result = reservationService.getAvailableRooms(from, to, size);
        return result.stream().map(AvailableRoomDTO::new).collect(Collectors.toList());
    }


}
