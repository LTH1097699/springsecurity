package io.springsecurity6_oauthauthorizationserver.service;


import io.springsecurity6_oauthauthorizationserver.entity.UserEntity;
import io.springsecurity6_oauthauthorizationserver.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Optional<UserEntity> getByUserName(final String username) {
        return userRepository.findByUserName(username);
    }
}
