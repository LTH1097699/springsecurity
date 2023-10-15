package io.springssecurity.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.authentication.JwtIssuerAuthenticationManagerResolver;
import org.springframework.security.oauth2.server.resource.authentication.OpaqueTokenAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
import org.springframework.security.oauth2.server.resource.introspection.SpringOpaqueTokenIntrospector;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.oauth2ResourceServer(
                it -> it.authenticationManagerResolver(
                        authenticationManagerResolver(jwtDecoder(), opaqueTokenIntrospector()))
        );

        return http.build();
    }

//    @Bean
//    public AuthenticationManagerResolver<HttpServletRequest> authenticationManagerResolver() {
//
////        AuthenticationManager authenticationManager = new ProviderManager(new JwtAuthenticationProvider(jwtDecoder));
////
////        return new AuthenticationManagerResolver<HttpServletRequest>() {
////            @Override
////            public AuthenticationManager resolve(HttpServletRequest context) {
////                return authenticationManager;
////            }
////        };
//
//        JwtIssuerAuthenticationManagerResolver jwtIssuerAuthenticationManagerResolver
//                = new JwtIssuerAuthenticationManagerResolver(
//                        "http://localhost:8080", "http://localhost:7070");
//        return jwtIssuerAuthenticationManagerResolver;
//    }

    @Bean
    public AuthenticationManagerResolver<HttpServletRequest> authenticationManagerResolver(
            JwtDecoder jwtDecoder, OpaqueTokenIntrospector opaqueTokenIntrospector
    ) {
        AuthenticationManager jwtAuth = new ProviderManager(
                new JwtAuthenticationProvider(jwtDecoder)
        );
        AuthenticationManager opaqueAuth = new ProviderManager(
                new OpaqueTokenAuthenticationProvider(opaqueTokenIntrospector)
        );

        return request -> {
            if ("jwt".equals(request.getHeader("type"))) {
                return jwtAuth;
            } else {
                return opaqueAuth;
            }
        };
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder
                .withJwkSetUri("http://localhost:8080/oauth2/jwks")
                .build();
    }

    @Bean
    public OpaqueTokenIntrospector opaqueTokenIntrospector() {
        return new SpringOpaqueTokenIntrospector(
                "http://localhost:8888/oauth2/introspect",
                "client",
                "secret");
    }
}
