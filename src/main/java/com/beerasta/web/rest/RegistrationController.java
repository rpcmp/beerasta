package com.beerasta.web.rest;

import com.beerasta.domain.User;
import com.beerasta.security.RegistrationForm;
import com.beerasta.service.UserService;
import com.beerasta.web.rest.errors.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@AllArgsConstructor
public class RegistrationController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    @PostMapping("/registration")
    public ResponseEntity<Object> registration(@RequestBody RegistrationForm form) {
        User user = form.toUser(passwordEncoder);
        log.info(user.toString());
        try {
            userService.findByUsername(user.getUsername());
            return ResponseEntity.badRequest().build();
        } catch (NotFoundException e) {
            User save = userService.save(user);
            log.info(save.toString());
            return ResponseEntity.ok(save);
        }

    }

//    @PostMapping("/login")
    public ResponseEntity<User> loadUserByUsername(String username) throws NotFoundException {
        User user = userService.findByUsername(username);
        log.info(user.toString());
        return ResponseEntity.ok(user);
    }
}
