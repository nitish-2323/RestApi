package com.ram.RESTapi.Configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class Configure {
    @Bean
    public UserDetailsService getUserDetailsService(){
        List<UserDetails> obj =new ArrayList<>();
        UserDetails userDetails = User.withDefaultPasswordEncoder().username("ram").password("ram")
                .roles("USER").build();
        obj.add(userDetails);
        return new InMemoryUserDetailsManager(obj);
    }
}
