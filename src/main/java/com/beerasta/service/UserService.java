package com.beerasta.service;

import com.beerasta.domain.User;
import com.beerasta.repository.UsersRepository;
import com.beerasta.web.rest.errors.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    public User findByUsername(String userName) throws NotFoundException {
        return usersRepository.findByUsername(userName)
                .orElseThrow(() -> new NotFoundException("No user with username " + userName));
    }
}
