package com.chi.vtertychnyi.phone_contacts.service.Impl;

import com.chi.vtertychnyi.phone_contacts.DTO.ContactDTO;
import com.chi.vtertychnyi.phone_contacts.model.entities.Contact;
import com.chi.vtertychnyi.phone_contacts.model.entities.Email;
import com.chi.vtertychnyi.phone_contacts.model.entities.Number;
import com.chi.vtertychnyi.phone_contacts.model.entities.User;
import com.chi.vtertychnyi.phone_contacts.repository.ContactRepository;
import com.chi.vtertychnyi.phone_contacts.service.ContactService;
import com.chi.vtertychnyi.phone_contacts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserService userService;


    @Override
    public void updateContact(ContactDTO updateContact, Long id) {
        Contact contact = contactRepository.findById(id).orElseThrow(() -> new RuntimeException());
        contact.setName(updateContact.getName());
        contact.setNumbers(mapFromNumberToString(updateContact, contact));
        contact.setEmails(mapFromEmailToString(updateContact, contact));
        contactRepository.save(contact);
    }

    @Override
    public void createContact(ContactDTO contactDTO, String currentUserLogin) {
        User byLogin = userService.findByLogin(currentUserLogin);
        Contact contact = new Contact();
        contact.setName(contactDTO.getName());
        contact.setUser(byLogin);

        contact.setEmails(mapFromEmailToString(contactDTO, contact));
        contact.setNumbers(mapFromNumberToString(contactDTO, contact));
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);

    }

    public static List<Number> mapFromNumberToString(ContactDTO contactDTO, Contact contact) {
        List<Number> numbers = contactDTO.getNumbers().stream().map(numberDTO -> {
            Number number = new Number();
            number.setNumber(numberDTO);
            number.setContact(contact);
            return number;
        }).collect(Collectors.toList());
        return numbers;
    }

    public static List<Email> mapFromEmailToString(ContactDTO contactDTO, Contact contact) {
        List<Email> emails = contactDTO.getEmails().stream().map(emailDTO -> {
            Email email = new Email();
            email.setEmail(emailDTO);
            email.setContact(contact);
            return email;
        }).collect(Collectors.toList());
        return emails;
    }
}
