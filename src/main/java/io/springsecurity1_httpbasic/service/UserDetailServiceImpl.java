package io.springsecurity1_httpbasic.service;

import io.springsecurity1_httpbasic.repository.UserRepository;
import io.springsecurity1_httpbasic.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var users = userRepository.findAll();
        var user = userRepository.findByUserName(username);
        return user.map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("not found %s".formatted(username)));
    }
}
