package com.example.taxibookingapplication.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Profile("test")
@Configuration
@EnableWebSecurity
public class TestSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity web) throws Exception {
        web.authorizeRequests().anyRequest().permitAll();
    }
}
