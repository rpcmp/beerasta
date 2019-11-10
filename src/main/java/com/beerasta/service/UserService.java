package com.beerasta.service;

import com.beerasta.domain.User;
import com.beerasta.repository.UsersRepository;
import com.beerasta.web.rest.errors.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    public User findByUsername(String userName) throws NotFoundException {
        return usersRepository.findByUsername(userName)
                .orElseThrow(() -> new NotFoundException("No user with username " + userName));
    }

    public User save(User user) {
        User userFromBD = usersRepository.findByUsername(user.getUsername()).orElse(null);
        if (userFromBD != null) {
            throw new IllegalArgumentException("User with username " + userFromBD.getUsername() + " already exist");
        }
        log.info(user.toString());
        return usersRepository.save(user);
    }

}
