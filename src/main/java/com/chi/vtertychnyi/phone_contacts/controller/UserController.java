package com.chi.vtertychnyi.phone_contacts.controller;

import com.chi.vtertychnyi.phone_contacts.model.entities.User;
import com.chi.vtertychnyi.phone_contacts.security.jwt.JwtProvider;
import com.chi.vtertychnyi.phone_contacts.DTO.UserDTO;
import com.chi.vtertychnyi.phone_contacts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping(value="/authorization")
public class UserController {


    private UserService userService;
    private JwtProvider jwtProvider;

    @Autowired
    public UserController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/registration")
    public String registerUser(@RequestBody @Valid UserDTO userDTO) {
        User u = new User();
        u.setPassword(userDTO.getPassword());
        u.setLogin(userDTO.getLogin());
        userService.saveUser(u);
        return "OK";
    }

    @PostMapping("/auth")
    public String auth(@RequestBody UserDTO userDTO) {
        User user = userService.findByLoginAndPassword(userDTO.getLogin(), userDTO.getPassword());
        String token = jwtProvider.generateToken(user.getLogin());
        return token;
    }
}
