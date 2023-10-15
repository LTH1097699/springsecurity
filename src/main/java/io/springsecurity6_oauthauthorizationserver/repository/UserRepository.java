package io.springsecurity6_oauthauthorizationserver.repository;

import io.springsecurity6_oauthauthorizationserver.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserName(String username);
}
