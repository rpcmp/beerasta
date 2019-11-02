package com.beerasta.web.rest;

import com.beerasta.domain.User;
import com.beerasta.security.RegistrationForm;
import com.beerasta.service.UserService;
import com.beerasta.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Controller
@CrossOrigin
public class RegistrationController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserService userService,
                                  @Lazy PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/registration")
    public ResponseEntity<Object> registration(@RequestBody RegistrationForm form) {
        User user = form.toUser(passwordEncoder);
        log.info(user.toString());
        try {
            userService.findByUsername(user.getUsername());
            return ResponseEntity.badRequest().build();
        }
        catch (NotFoundException e) {
            User save = userService.save(user);
            log.info(save.toString());
            return ResponseEntity.ok(save);
        }

    }

}
