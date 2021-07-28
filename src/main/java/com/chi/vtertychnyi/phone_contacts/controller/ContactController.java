package com.chi.vtertychnyi.phone_contacts.controller;

import com.chi.vtertychnyi.phone_contacts.DTO.ContactDTO;
import com.chi.vtertychnyi.phone_contacts.security.SecurityUtils;
import com.chi.vtertychnyi.phone_contacts.service.ContactService;
import com.chi.vtertychnyi.phone_contacts.service.UserService;
import com.chi.vtertychnyi.phone_contacts.utils.ContactValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@Validated
@RestController
@RequestMapping(value = "/phone/contacts")
public class ContactController {

    private UserService userService;
    private ContactService contactService;
    private ContactValidator contactValidator;

    @Autowired
    public ContactController(ContactService contactService, UserService userService, ContactValidator contactValidator) {
        this.contactService = contactService;
        this.userService = userService;
        this.contactValidator = contactValidator;
    }

    @PostMapping
    public void createContact(@Validated @RequestBody ContactDTO contactDTO, BindingResult result, HttpServletResponse httpServletResponse) throws IOException {
        contactValidator.validate(contactDTO, result);
        if (result.hasErrors())
            httpServletResponse.sendError(400);
        String currentUserLogin;
        currentUserLogin = SecurityUtils.getUserCurrentLogin();
        contactService.createContact(contactDTO, currentUserLogin);
    }

    @PutMapping
    @RequestMapping("/update/{id}")
    public void updateContact(@RequestBody ContactDTO contactDTO, @PathVariable Long id) {
        contactService.updateContact(contactDTO, id);
    }

    @GetMapping
    public List<ContactDTO> contactList() {
        String currentUserLogin;
        currentUserLogin = SecurityUtils.getUserCurrentLogin();
        return userService.contactList(currentUserLogin);
    }

    @DeleteMapping
    @RequestMapping("/{id}")
    public void deleteContact(@PathVariable("id") Long id) {
        contactService.deleteContact(id);
    }
}
