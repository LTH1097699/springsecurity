package io.springsecurity7.config;


import org.springframework.core.convert.converter.Converter;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.List;

public class CustomJwtAuthenticationTokenConverter implements Converter<Jwt, JwtAuthenticationToken> {

    @Override
    public CustomJwtAuthenticationToken convert(Jwt source) {
        List<String> grantedAuthorityList = (List<String>) source.getClaims().get("authorities");

        CustomJwtAuthenticationToken jwtToken = new CustomJwtAuthenticationToken(source,
                grantedAuthorityList.stream().map(SimpleGrantedAuthority::new).toList());

        return jwtToken;
    }
}
