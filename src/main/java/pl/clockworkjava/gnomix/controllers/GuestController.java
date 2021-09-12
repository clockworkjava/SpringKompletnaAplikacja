package pl.clockworkjava.gnomix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.clockworkjava.gnomix.domain.guest.GuestService;

@Controller
public class GuestController {

    private GuestService guestService;

    @Autowired
    public GuestController(GuestService service) {
        this.guestService = service;
    }

    @GetMapping("/guests")
    public String guests(Model model) {
        model.addAttribute("guests", this.guestService.findAll());
        return "guests";
    }

    @GetMapping("/createNewGuest")
    public String createNewGuest() {
        return "createNewGuest";
    }

    @PostMapping("/createNewGuest")
    public String handleCreateNewGuest(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String dateOfBirth) {

        this.guestService.createNewGuest(firstName, lastName, dateOfBirth);

        return "redirect:guests";
    }

}