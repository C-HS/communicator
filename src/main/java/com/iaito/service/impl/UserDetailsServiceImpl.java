package com.iaito.service.impl;

import com.iaito.model.User;
import com.iaito.model.UserPrinciple;
import com.iaito.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user  = userRepository.findUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not Found");
        }
        log.info("loadUserByUsername() : {}",  username);
        return new UserPrinciple(user);
    }
}
