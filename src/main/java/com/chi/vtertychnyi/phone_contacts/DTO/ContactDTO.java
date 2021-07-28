package com.chi.vtertychnyi.phone_contacts.DTO;

import com.chi.vtertychnyi.phone_contacts.model.entities.User;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class ContactDTO {

    private Long id;
    @NotEmpty
    @Size(min = 3, message = "contact name should have at least 2 characters")
    private String name;
    private List<@Email @NotEmpty String> emails;
    private List< @NotEmpty @Pattern(regexp = "((\\+38)?\\(?\\d{3}\\)?[\\s\\.-]?(\\d{7}))") String> numbers;
    private User user;

    public ContactDTO() {
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

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
