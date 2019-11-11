package com.beerasta.service;

import com.beerasta.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserDetailService implements UserDetailsService {
    private final UsersRepository usersRepository;

    public UserDetailService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info(s);
        UserDetails result = usersRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        log.info(result.toString());
        return result;
    }
}
