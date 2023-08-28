package com.Hammasir.Mahtab.service;

import com.Hammasir.Mahtab.model.User;
import static com.Hammasir.Mahtab.repository.DataBase.readUsers;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class CustomFileUserDetailsService implements UserDetailsService {
    private final List<User> users;

    public CustomFileUserDetailsService() {
        this.users = readUsers("input/user.txt");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
        User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return User.builder()
                .username(user.getUsername())
                .password(passwordEncoder().encode(user.getPassword()))
                .roles(user.getRoles())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
}
