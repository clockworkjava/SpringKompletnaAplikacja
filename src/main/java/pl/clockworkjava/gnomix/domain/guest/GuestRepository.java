package pl.clockworkjava.gnomix.domain.guest;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GuestRepository {

    List<Guest> guests = new ArrayList<>();

    public GuestRepository() {
        Guest guest = new Guest("Paweł", "Cwik", LocalDate.of(1986, 11, 13), Gender.MALE);
        Guest gabriel = new Guest("Gabriel", "Cwik", LocalDate.of(2016, 12, 13), Gender.MALE);
        this.guests.add(guest);
        this.guests.add(gabriel);
    }

    public List<Guest> findAll() {
        return this.guests;
    }

    public void createNewGuest(String firstName, String lastName, LocalDate dateOfBirth, Gender gender) {
        Guest newOne = new Guest(firstName, lastName, dateOfBirth, gender);
        this.guests.add(newOne);
    }

    public void removeById(long id) {

        Guest guestToBeDelete = this.guests.stream()
                .filter(guest -> guest.getId() == id)
                .findFirst()
                .orElseThrow();

        this.guests.remove(guestToBeDelete);
    }
}
