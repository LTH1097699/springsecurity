package io.springsecurity6.service;


import io.springsecurity6.entity.ClientEntity;
import io.springsecurity6.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomClientService implements RegisteredClientRepository {

    private final ClientRepository clientRepository;

    @Override
    public void save(RegisteredClient registeredClient) {
        clientRepository.save(ClientEntity.toClientEntity(registeredClient));
    }

    @Override
    public RegisteredClient findById(String id) {
        var clientEntity = clientRepository.findById(Long.valueOf(id)).orElseThrow();
        return ClientEntity.toRegisteredClient(clientEntity);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        var clientEntity = clientRepository.findByClientId(clientId).orElseThrow();
        return ClientEntity.toRegisteredClient(clientEntity);
    }
}
