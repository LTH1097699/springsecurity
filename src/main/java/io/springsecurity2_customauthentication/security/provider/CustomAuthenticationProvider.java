package io.springsecurity2_customauthentication.security.provider;

import io.springsecurity2_customauthentication.security.authentication.CustomAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${key.secret}")
    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        var customAuthentication = (CustomAuthentication) authentication;
        if (key.equals(customAuthentication.getKey())) {
            return new CustomAuthentication(null, true);
        }

        throw new BadCredentialsException("wrong key");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}
