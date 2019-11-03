package com.beerasta.security;

import com.beerasta.domain.User;
import lombok.Data;

@Data
public class RegistrationForm {

    private String username;
    private String password;

    public User toUser() {
        return new User(username, password);
    }

}
