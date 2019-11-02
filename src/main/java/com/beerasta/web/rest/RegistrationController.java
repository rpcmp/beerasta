package com.beerasta.web.rest;

import com.beerasta.domain.User;
import com.beerasta.security.RegistrationForm;
import com.beerasta.service.UserService;
import com.beerasta.web.rest.errors.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Controller
@CrossOrigin
@AllArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<Object> registration(@RequestBody RegistrationForm form) {
        User user = form.toUser();
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

    @GetMapping("/login")
    public ResponseEntity<Object> login() {
        return ResponseEntity.ok().build();
    }

}
