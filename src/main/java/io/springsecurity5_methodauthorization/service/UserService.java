package io.springsecurity5_methodauthorization.service;


import io.springsecurity5_methodauthorization.entity.UserEntity;
import io.springsecurity5_methodauthorization.repository.UserRepository;
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
