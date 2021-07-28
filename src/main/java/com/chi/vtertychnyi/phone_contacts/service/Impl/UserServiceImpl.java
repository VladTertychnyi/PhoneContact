package com.chi.vtertychnyi.phone_contacts.service.Impl;

import com.chi.vtertychnyi.phone_contacts.DTO.ContactDTO;
import com.chi.vtertychnyi.phone_contacts.model.entities.Contact;
import com.chi.vtertychnyi.phone_contacts.model.entities.Email;
import com.chi.vtertychnyi.phone_contacts.model.entities.Number;
import com.chi.vtertychnyi.phone_contacts.model.entities.User;
import com.chi.vtertychnyi.phone_contacts.repository.ContactRepository;
import com.chi.vtertychnyi.phone_contacts.repository.UserRepository;
import com.chi.vtertychnyi.phone_contacts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private ContactRepository contactRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.contactRepository = contactRepository;
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        User user = findByLogin(login);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return user;
    }

    @Override
    public List<ContactDTO> contactList(String currentUserLogin) {
        User user = userRepository.findByLogin(currentUserLogin);
        List<Contact> contacts = user.getContacts();
        List<ContactDTO> contactDTOS = new ArrayList<>();
        for (Contact contact :
                contacts) {
            ContactDTO contactDTO = new ContactDTO();
            contactDTO.setName(contact.getName());
            List<String> emails = contact.getEmails().stream().map(Email::getEmail).collect(Collectors.toList());
            List<String> numbers = contact.getNumbers().stream().map(Number::getNumber).collect(Collectors.toList());
            contactDTO.setEmails(emails);
            contactDTO.setNumbers(numbers);
            contactDTOS.add(contactDTO);
        }
        return contactDTOS;
    }
}

