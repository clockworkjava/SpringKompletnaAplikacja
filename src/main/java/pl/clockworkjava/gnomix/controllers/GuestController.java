package pl.clockworkjava.gnomix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.clockworkjava.gnomix.controllers.dto.GuestCreationDTO;
import pl.clockworkjava.gnomix.domain.guest.GuestService;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/guests")
public class GuestController {

    private GuestService guestService;

    @Autowired
    public GuestController(GuestService service) {
        this.guestService = service;
    }

    @GetMapping
    public String guests(Model model) {
        model.addAttribute("guests", this.guestService.findAll());
        return "guests";
    }

        @GetMapping("/create")
    public String createNewGuest() {
        return "createNewGuest";
    }

    @PostMapping
    public String handleCreateNewGuest(GuestCreationDTO dto) {

        this.guestService.createNewGuest(dto);

        return "redirect:/guests";
    }

    @GetMapping("/delete/{id}")
    public String removeGuest(@PathVariable long id) {

        this.guestService.removeById(id);

        return "redirect:/guests";
    }

}