package com.Hammasir.Mahtab.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class BasicAuthWebSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf( AbstractHttpConfigurer::disable );
        http.authorizeHttpRequests( request -> request
                .requestMatchers( HttpMethod.GET, "restaurant/**" ).permitAll()
                .requestMatchers( HttpMethod.GET, "food/**" ).permitAll()
                .requestMatchers( HttpMethod.POST, "restaurant/**" ).hasRole( "ADMIN" )
                .requestMatchers( HttpMethod.PUT, "restaurant/**" ).hasRole( "ADMIN" )
                .requestMatchers( HttpMethod.DELETE, "restaurant/**" ).hasRole( "ADMIN" )
                .requestMatchers( HttpMethod.POST, "food/**" ).hasRole( "ADMIN" )
                .requestMatchers( HttpMethod.PUT, "food/**" ).hasRole( "ADMIN" )
                .requestMatchers( HttpMethod.DELETE, "food/**" ).hasRole( "ADMIN" )
                .requestMatchers( "user/**" ).hasAnyRole( "ADMIN", "USER" )
                .anyRequest().authenticated() );
        http.httpBasic( Customizer.withDefaults() );
        return http.build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("mahtabmahdavi")
                .password(passwordEncoder().encode("1234admin"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("testuser")
                .password(passwordEncoder().encode("pass842word"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }
}
