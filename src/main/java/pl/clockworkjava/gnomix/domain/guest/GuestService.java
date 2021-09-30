package pl.clockworkjava.gnomix.domain.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.clockworkjava.gnomix.controllers.dto.GuestCreationDTO;
import pl.clockworkjava.gnomix.controllers.dto.GuestUpdateDTO;

import java.time.LocalDate;
import java.util.List;

@Service
public class GuestService {

    private GuestRepository repository;

    @Autowired
    public GuestService(GuestRepository repository) {
        this.repository = repository;
    }

    public List<Guest> findAll() {
        return this.repository.findAll();
    }

    public void createNewGuest(GuestCreationDTO dto) {
        this.repository.createNewGuest(dto.getFirstName(), dto.getLastName(), dto.getDateOfBirth(), dto.getGender());
    }

    public void removeById(long id) {
        this.repository.removeById(id);
    }

    public Guest getById(long id) {
        return this.repository.getById(id);
    }

    public void update(GuestUpdateDTO updatedGuest) {
        Guest byId = this.repository.getById(updatedGuest.getId());
        byId.update(
                updatedGuest.getFirstName(),
                updatedGuest.getLastName(),
                updatedGuest.getDateOfBirth(),
                updatedGuest.getGender()
        );
        this.repository.update(byId);
    }
}
