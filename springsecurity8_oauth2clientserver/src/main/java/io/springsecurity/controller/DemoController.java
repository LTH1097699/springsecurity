package io.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;

    @GetMapping("/token")
    @ResponseStatus(HttpStatus.OK)
    public String demo(Authentication a) {
        var request = OAuth2AuthorizeRequest
                .withClientRegistrationId("1")
                .principal("client")
                .build();

        var client = oAuth2AuthorizedClientManager.authorize(request);
        assert client != null;
        return client.getAccessToken().getTokenValue();
    }
}
