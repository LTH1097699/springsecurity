package io.springsecurity3_customfilterwithdefaultfilter.security.manager;

import io.springsecurity3_customfilterwithdefaultfilter.security.provider.ApiKeyProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private final String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var apiKeyProvider = new ApiKeyProvider(key);
        if (apiKeyProvider.supports(authentication.getClass())) {
            return apiKeyProvider.authenticate(authentication);
        }

        throw new BadCredentialsException("wrong key");
    }
}
