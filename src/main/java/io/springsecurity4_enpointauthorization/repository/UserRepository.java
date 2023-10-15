package io.springsecurity4_enpointauthorization.repository;

import io.springsecurity4_enpointauthorization.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserName(String username);
}
