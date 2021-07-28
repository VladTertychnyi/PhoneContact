package com.chi.vtertychnyi.phone_contacts.service;
import com.chi.vtertychnyi.phone_contacts.DTO.ContactDTO;


public interface ContactService {

    void updateContact(ContactDTO contact, Long id);

    void createContact(ContactDTO contact, String currentUserLogin);

    void deleteContact(Long id);


}
