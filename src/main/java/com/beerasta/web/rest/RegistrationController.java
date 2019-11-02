package com.beerasta.web.rest;

import com.beerasta.domain.User;
import com.beerasta.security.RegistrationForm;
import com.beerasta.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@AllArgsConstructor
@Controller
@CrossOrigin
public class RegistrationController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/registration")
    public String registration(@RequestBody RegistrationForm form) {
        User user = form.toUser(passwordEncoder);
        log.info(user.toString());
        if (userService.findByUsername(user.getUsername()) != null) {
            return "redirect:/registration";
        }
        return "redirect:/login";
    }

}
