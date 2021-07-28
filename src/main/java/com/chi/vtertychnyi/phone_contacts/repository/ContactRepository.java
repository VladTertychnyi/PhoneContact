package com.chi.vtertychnyi.phone_contacts.repository;

import com.chi.vtertychnyi.phone_contacts.model.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findAll();

}
