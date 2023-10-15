package io.springsecurity6.repository;

import io.springsecurity6.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    Optional<ClientEntity> findByClientId(String clientId);
}
