package com.chi.vtertychnyi.phone_contacts.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "login")
    private String name;


    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL)
    private List<Email> emails;

    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL)
    private List<Number> numbers;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Contact() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
