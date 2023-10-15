package io.springsecurity11_cors.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().anyRequest().permitAll();

        http.cors().configurationSource(request -> {
            CorsConfiguration cros = new CorsConfiguration();
            cros.setAllowedOrigins(List.of("*"));
            return cros;
        });
        return http.build();
    }
}
