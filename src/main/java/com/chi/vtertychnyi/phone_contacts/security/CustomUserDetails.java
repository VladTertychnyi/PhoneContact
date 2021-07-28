package com.chi.vtertychnyi.phone_contacts.security;

import com.chi.vtertychnyi.phone_contacts.model.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private String login;
    private String password;

    public static CustomUserDetails fromEntityToCustomUserDetails(User user){

        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.login=user.getLogin();
        customUserDetails.password=user.getPassword();
        return customUserDetails;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
