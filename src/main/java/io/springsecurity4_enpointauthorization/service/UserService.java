package io.springsecurity4_enpointauthorization.service;

import io.springsecurity4_enpointauthorization.entity.UserEntity;
import io.springsecurity4_enpointauthorization.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<UserEntity> getByUserName(final String username) {
        return userRepository.findByUserName(username);
    }
}
