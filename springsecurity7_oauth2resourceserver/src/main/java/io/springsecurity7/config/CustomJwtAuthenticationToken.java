package io.springsecurity7.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;

public class CustomJwtAuthenticationToken extends JwtAuthenticationToken {

    private String something;

    public CustomJwtAuthenticationToken(Jwt jwt, Collection<? extends GrantedAuthority> grantedAuthorities) {
        super(jwt, grantedAuthorities);
        something = ":)";
    }
}
