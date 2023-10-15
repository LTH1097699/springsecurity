package io.springsecurity6.entity;

import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import jakarta.persistence.*;
import java.sql.SQLType;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Entity
@Table(name = "clients", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "secret")
    private String secret;

    @Column(name = "scope")
    private List<String> scope;

    @Column(name = "auth_method")
    private String authMethod;

    @Column(name = "grant_type")
    @JdbcTypeCode(SqlTypes.ARRAY)
    private List<String> grantType;

    @Column(name = "redirect_uri")
    @JdbcTypeCode(SqlTypes.ARRAY)
    private List<String> redirectUris;

    public static RegisteredClient toRegisteredClient(ClientEntity entity) {
        return RegisteredClient.withId(entity.getId().toString())
                .clientId(entity.getClientId())
                .clientSecret(entity.getSecret())
                .clientAuthenticationMethods(it -> it.addAll(new HashSet<>(Set.of(new ClientAuthenticationMethod(entity.getAuthMethod())))))
                .authorizationGrantTypes(it -> it.addAll(new HashSet<>(entity.getGrantType().stream()
                        .map(AuthorizationGrantType::new).collect(Collectors.toSet()))))
                .redirectUris(it -> it.addAll(new HashSet<>(entity.getRedirectUris())))
                .scopes(it -> it.addAll(new HashSet<>(entity.getScope())))
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .tokenSettings(
                        TokenSettings.builder()
                                // default is none-opaque
                                //.accessTokenFormat(OAuth2TokenFormat.REFERENCE) // opaque
                                .accessTokenTimeToLive(Duration.ofDays(2))
                                .build()
                )
                .build();
    }

    public static ClientEntity toClientEntity(RegisteredClient registeredClient) {
        return ClientEntity.builder()
                .clientId(registeredClient.getClientId())
                .secret(registeredClient.getClientSecret())
                .authMethod(String.valueOf(registeredClient.getClientAuthenticationMethods().stream().findAny().orElse(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)))
                .grantType(registeredClient.getAuthorizationGrantTypes().stream().map(Object::toString).toList())
                .redirectUris(registeredClient.getRedirectUris().stream().toList())
                .scope(registeredClient.getScopes().stream().toList())
                .build();
    }

}

