package com.example.taxibookingapplication.controller;


import com.example.taxibookingapplication.domain.jwt.JwtRequest;
import com.example.taxibookingapplication.domain.jwt.JwtResponse;
import com.example.taxibookingapplication.security.CustomUserDetailsService;
import com.example.taxibookingapplication.security.CustomerUserDetails;
import com.example.taxibookingapplication.security.jwt.JWTUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private JWTUtils jwtUtils;

    private AuthenticationManager authenticationManager;

    private CustomUserDetailsService userDetailsService;

    public LoginController(JWTUtils jwtUtils, AuthenticationManager authenticationManager, CustomUserDetailsService customerUserDetails) {
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = customerUserDetails;
    }

    @PostMapping("/user/login")
    public JwtResponse authenticateUser (@RequestBody JwtRequest jwtRequest) throws BadCredentialsException {
            try{
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                jwtRequest.getUsername(),
                                jwtRequest.getPassword()
                        )
                );
            }
            catch (BadCredentialsException e){
                throw  new BadCredentialsException("Invalid Credentials!!");
            }

            final UserDetails user = userDetailsService.loadUserByUsername(jwtRequest.getUsername());

            final String token = jwtUtils.generateToken(user);

            return new JwtResponse(token);
    }
}
