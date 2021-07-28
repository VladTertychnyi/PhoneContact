package com.chi.vtertychnyi.phone_contacts.repository;

import com.chi.vtertychnyi.phone_contacts.model.entities.Contact;
import com.chi.vtertychnyi.phone_contacts.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin (String login);

}
