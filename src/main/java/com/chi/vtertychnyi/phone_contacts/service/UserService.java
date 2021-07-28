package com.chi.vtertychnyi.phone_contacts.service;

import com.chi.vtertychnyi.phone_contacts.DTO.ContactDTO;
import com.chi.vtertychnyi.phone_contacts.model.entities.Contact;
import com.chi.vtertychnyi.phone_contacts.model.entities.User;

import java.util.List;

public interface UserService {

    User findByLogin(String login);

    User findByLoginAndPassword(String login, String password);

    User saveUser(User user);

    List<ContactDTO> contactList(String currentUserLogin);
}
