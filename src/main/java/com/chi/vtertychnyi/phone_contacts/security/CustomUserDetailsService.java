package com.chi.vtertychnyi.phone_contacts.security;

import com.chi.vtertychnyi.phone_contacts.model.entities.User;
import com.chi.vtertychnyi.phone_contacts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findByLogin(s);
        return CustomUserDetails.fromEntityToCustomUserDetails(user);
    }
}
