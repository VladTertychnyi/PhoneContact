package com.chi.vtertychnyi.phone_contacts.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EMAILS")
public class Email implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private String email;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Email() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
