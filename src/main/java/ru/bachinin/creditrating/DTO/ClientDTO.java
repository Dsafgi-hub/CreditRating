package ru.bachinin.creditrating.DTO;

import jakarta.xml.bind.annotation.XmlRootElement;
import javax.validation.constraints.NotBlank;


@XmlRootElement(name = "user")
public class ClientDTO {
    @NotBlank
    private String surname;

    @NotBlank
    private String firstName;

    @NotBlank
    private String secondName;

    public ClientDTO(String surname, String firstName, String secondName) {
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public ClientDTO() {
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}
