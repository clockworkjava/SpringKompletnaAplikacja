package pl.clockworkjava.gnomix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.clockworkjava.gnomix.domain.room.Room;

@Controller
public class RoomController {

    @GetMapping("/rooms")
    public String getRooms(Model model) {
        Room room = new Room("1408");
        model.addAttribute("room", room);
        return "rooms";
    }
}
