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

    public User findByUsername(String userName) {
        return usersRepository.findByUsername(userName);
    }

    public User findById(Long id) throws NotFoundException {
        return usersRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No user with id " + id));
    }
}
