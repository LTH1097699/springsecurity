package io.springsecurity2_customauthentication.security.filter;

import io.springsecurity2_customauthentication.security.authentication.CustomAuthentication;
import io.springsecurity2_customauthentication.security.manager.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter  {

    private final CustomAuthenticationManager customAuthenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {


        var key = String.valueOf(request.getHeader("key"));
        var authentication = customAuthenticationManager.authenticate(new CustomAuthentication(key, false));


        if (authentication.isAuthenticated()) {

            SecurityContextHolder.getContext().setAuthentication(authentication);
            // propagate to the next filter
            // only when authentication worked
            filterChain.doFilter(request, response);
        }
    }
}
