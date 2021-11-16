package ru.bachinin.creditrating.DTO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import javax.validation.constraints.NotBlank;

@XmlRootElement(name = "user")
public class ClientDTO {
    @NotBlank
    @XmlElement(name = "surname")
    private String surname;

    @NotBlank
    @XmlElement(name = "firstName")
    private String firstName;

    @NotBlank
    @XmlElement(name = "secondName")
    private String secondName;


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

    @Override
    public String toString() {
        return "ClientDTO { " +
                " surname'" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
