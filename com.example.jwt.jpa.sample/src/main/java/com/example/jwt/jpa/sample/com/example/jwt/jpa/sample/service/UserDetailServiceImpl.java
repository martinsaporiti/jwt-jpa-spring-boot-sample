package com.example.jwt.jpa.sample.com.example.jwt.jpa.sample.service;

import com.example.jwt.jpa.sample.com.example.jwt.jpa.sample.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


/**
 * @author: martinsaporiti
 * @date: 29/09/2020
 */
@Service()
public class UserDetailServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.jwt.jpa.sample.com.example.jwt.jpa.sample.entity.User systemUser =
                this.userRepository.findByUsername(username);

        if(systemUser == null){
            throw new UsernameNotFoundException(username);
        }

        return new User(systemUser.getUsername(), systemUser.getPassword(), Collections.emptyList());
    }

}
