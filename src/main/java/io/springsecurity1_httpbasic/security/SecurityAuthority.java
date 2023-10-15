package io.springsecurity1_httpbasic.security;

import io.springsecurity1_httpbasic.entities.AuthorEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final AuthorEntity authorEntity;

    @Override
    public String getAuthority() {
        return authorEntity.getName();
    }
}
