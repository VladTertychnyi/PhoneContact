package com.chi.vtertychnyi.phone_contacts.DTO;

import com.chi.vtertychnyi.phone_contacts.model.entities.Contact;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class UserDTO {

    @NotEmpty
    private String login;
    @Size(min = 3,max = 10)
    private String password;
    private List<Contact> contacts;
    public UserDTO() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
