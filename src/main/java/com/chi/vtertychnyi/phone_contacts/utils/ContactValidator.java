package com.chi.vtertychnyi.phone_contacts.utils;

import com.chi.vtertychnyi.phone_contacts.DTO.ContactDTO;
import com.chi.vtertychnyi.phone_contacts.security.SecurityUtils;
import com.chi.vtertychnyi.phone_contacts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.ArrayList;
import java.util.List;

@Component
public class ContactValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return ContactDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ContactDTO contactDTO = (ContactDTO) o;
        List<ContactDTO> contacts = userService.contactList(SecurityUtils.getUserCurrentLogin());
        String contactName = contactDTO.getName();
        List<String> allUserContactsNames = new ArrayList<>();
        for (ContactDTO c:
             contacts) {
            allUserContactsNames.add(c.getName());
        }
        if(allUserContactsNames.contains(contactName)){
            errors.reject("Invalid contact name");
        }
    }
}


