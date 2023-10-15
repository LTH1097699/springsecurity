package io.springsecurity3_customfilterwithdefaultfilter.security.provider;

import io.springsecurity3_customfilterwithdefaultfilter.security.authentication.ApiKeyAuthentication;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;


@AllArgsConstructor
public class ApiKeyProvider implements AuthenticationProvider {

    private final String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var apiKeyAuthentication = (ApiKeyAuthentication) authentication;
        if (key.equals(apiKeyAuthentication.getKey())) {
            apiKeyAuthentication.setAuthenticated(true);
            return apiKeyAuthentication;
        }

        throw new BadCredentialsException("wrong key");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ApiKeyAuthentication.class.equals(authentication);
    }
}
