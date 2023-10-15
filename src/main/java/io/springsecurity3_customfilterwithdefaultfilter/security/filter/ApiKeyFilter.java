package io.springsecurity3_customfilterwithdefaultfilter.security.filter;

import io.springsecurity3_customfilterwithdefaultfilter.security.authentication.ApiKeyAuthentication;
import io.springsecurity3_customfilterwithdefaultfilter.security.manager.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequiredArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

    private final String key;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        CustomAuthenticationManager customAuthenticationManager = new CustomAuthenticationManager(key);
        var newA = new ApiKeyAuthentication(String.valueOf(request.getHeader("key")));

        if ("null".equals(request.getHeader("key")) || request.getHeader("key") == null) {
            filterChain.doFilter(request,response);
        }

        try {
            var a = customAuthenticationManager.authenticate(newA);
            if (a.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(a);
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } catch (AuthenticationException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }


    }
}
