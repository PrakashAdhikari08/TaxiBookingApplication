package com.example.taxibookingapplication.security;

import com.example.taxibookingapplication.domain.User;
import com.example.taxibookingapplication.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);

        if(user == null)
            throw new UsernameNotFoundException("User not found");

        return new CustomerUserDetails(user);

    }
}
