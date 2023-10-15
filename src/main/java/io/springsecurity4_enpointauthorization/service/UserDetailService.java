package io.springsecurity4_enpointauthorization.service;

import io.springsecurity4_enpointauthorization.security.UserDetailImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userService.getByUserName(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found %s".formatted(username));
        }
        return new UserDetailImpl(user.get());
    }
}
