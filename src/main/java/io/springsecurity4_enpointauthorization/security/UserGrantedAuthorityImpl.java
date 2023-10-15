package io.springsecurity4_enpointauthorization.security;

import io.springsecurity4_enpointauthorization.entity.UserPrivilegeEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class UserGrantedAuthorityImpl implements GrantedAuthority {

    private final UserPrivilegeEntity privilege;
    @Override
    public String getAuthority() {
        return privilege.getRole().name();
    }
}
