package io.springsecurity4_enpointauthorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.httpBasic()
                .and()
                .authorizeRequests()
//                .anyRequest().hasAnyRole("ADMIN") // must have role admin
//                .anyRequest().hasAuthority("ADMIN")  // must have authority is admin // role and authority can be same
//                .anyRequest().access("isAuthenticated() and hasAuthority('ADMIN')") //must authenticate and have role admin

                //.mvcMatchers(HttpMethod.GET,"/hello").authenticated()  // for more search ANT expression
                //.mvcMatchers(HttpMethod.GET,"/demo/**").hasAuthority("ADMIN")
                //authenticate in group /demo/[any] and type GET must have authority Admin
                // other user dont have authority Admin can call POST but not GET in /demo/**

                .anyRequest().authenticated()
                .and().csrf().disable() // dont recommend in real world
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        var p = new BCryptPasswordEncoder();
        System.out.println(p.encode("123456"));
        return p;
    }
}
