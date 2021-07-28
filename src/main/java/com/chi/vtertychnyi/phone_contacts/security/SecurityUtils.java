package com.chi.vtertychnyi.phone_contacts.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SecurityUtils {

    public static String getUserCurrentLogin(){
        String currentUserLogin;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserDetails) {
            currentUserLogin = ((CustomUserDetails)principal).getLogin();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
        return currentUserLogin;
    }
}
