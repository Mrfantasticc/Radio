package com.india.radio.config;

import com.india.radio.Repositories.UserRepository;
import com.india.radio.entaties.UsersDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsersDetails user = userRepository.findByEmail(username);
        System.out.println(user);

        if (user==null){
            throw new UsernameNotFoundException("User not fount !!");
        }else {
            return new CustomUser(user);
        }

    }
}
