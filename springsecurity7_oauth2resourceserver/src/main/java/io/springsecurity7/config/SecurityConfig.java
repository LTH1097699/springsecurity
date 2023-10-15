package io.springsecurity7.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${jwt-key.jwt-uri}")
    private String jwksUri;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // use oauth2ResourceServer make this application acts like resource server
        http.oauth2ResourceServer(
                // config this resource server use jwt
                // give resource server access public port to get public key for validate token
                r ->
//                        r.jwt().jwkSetUri(jwksUri)
//                        .jwtAuthenticationConverter(new CustomJwtAuthenticationTokenConverter())

                        // config resource server for opaque token
                        r.opaqueToken()
                                // when resource receive opaque will call introspect to validate that token
                                .introspectionUri("http://localhost:8080/oauth2/introspect")
                                .introspectionClientCredentials("client", "secret")

        );

        // make all the requests required authentication
        http.authorizeHttpRequests().anyRequest().authenticated();

        return http.build();
    }
}
