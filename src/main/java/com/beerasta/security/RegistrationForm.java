package com.beerasta.security;

import com.beerasta.domain.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@Data
public class RegistrationForm {

    private String username;
    private String password;

    public User toUser(PasswordEncoder passwordEncoder) {
        User user = new User(username, passwordEncoder.encode(password), true);
        user.setPersonalItems(new ArrayList<>());
        user.setBookedItems(new ArrayList<>());
        return user;
    }

}
