package io.springsecurity2_customauthentication.security.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomAuthentication implements Authentication {
    private final String key;

    @Builder.Default
    private boolean isAuthenticate = Boolean.FALSE;

    @Override
    public boolean isAuthenticated() {
        return this.isAuthenticate;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.isAuthenticate = isAuthenticated;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
