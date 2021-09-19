package pl.clockworkjava.gnomix.domain.guest;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Guest {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final Gender gender;

    public Guest(String firstName, String lastName, LocalDate birthDate, Gender gender) {

        this.id = System.currentTimeMillis();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;

    }
}
