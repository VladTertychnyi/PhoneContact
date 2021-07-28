package com.chi.vtertychnyi.phone_contacts.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(name = "login", unique = true)
    private String login;


    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Contact> contacts;


    public User() {
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String name) {
        this.login = name;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
