package com.beerasta.service;

import com.beerasta.domain.User;
import com.beerasta.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service("userRepositoryUserDetailsService")
public class UserRepositoryUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(username);
        if (user != null) {
            log.info(user.toString());
            return user;
        }
        log.info("User '" + username + "' not found");
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }

}
