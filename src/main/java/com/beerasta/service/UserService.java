package com.beerasta.service;

import com.beerasta.domain.User;
import com.beerasta.repository.UsersRepository;
import com.beerasta.web.rest.errors.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;
    private final ItemService itemService;

    public User findByUsername(String userName) throws NotFoundException {
        return usersRepository.findByUsername(userName)
                .orElseThrow(() -> new NotFoundException("No user with username " + userName));
    }

    public User save(User user) {
        return usersRepository.save(user);
    }

}
