package pl.clockworkjava.gnomix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.clockworkjava.gnomix.domain.reservation.ReservationService;
import pl.clockworkjava.gnomix.domain.room.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String reservations(Model m) {
        m.addAttribute("reservations", this.reservationService.getAll());
        return "reservations";
    }

    @GetMapping("/create/stepone")
    public String beginCreationWizard() {
        return "reservationStepOne";
    }

    @PostMapping("/create/steptwo")
    public String creationWizardStepTwo(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
            int size,
            Model m) {

        List<String> errors = new ArrayList<>();

        if(size<0 || size>10) {
            errors.add("Nieprawidłowa ilość osób, pokoje (apartamenty) mieszczą maksymalnie 10 osób.");
        }

        if(fromDate.isEqual(toDate) || toDate.isBefore(fromDate)) {
            errors.add("Nieprawidłowe daty rezeracji.");
        }

        if(errors.isEmpty()) {
            List<Room> rooms = this.reservationService.getAvaiableRooms(fromDate, toDate, size);
            m.addAttribute("rooms", rooms);
            m.addAttribute("fromDate", fromDate);
            m.addAttribute("toDate", toDate);
            return "reservationStepTwo";
        } else {
            m.addAttribute("errors", errors);
            return "reservationStepOne";
        }


    }



}