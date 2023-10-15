package io.springsecurity6_oauthauthorizationserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Principal;

@Controller
public class DemoController6 {

//    @GetMapping("/demo")
//    @ResponseStatus(HttpStatus.OK)
//    public String demo() throws UnsupportedEncodingException {
//
//        return "redirect:https://localhost:8080/oauth2/token?response_type=token&state=6c2bb162-0f26-4caa-abbe-b65f7e5c6a2e&client_id=client&redirect_uri=" + URLEncoder.encode(redirect_uri, "UTF-8");
//    }

    @GetMapping("/login1")
    public String login() throws UnsupportedEncodingException {
            var redirect_uri = "https://springone.io/authorize";
            var s = "redirect:http://localhost:8080/oauth2/token?client_id=client" +
                    "&redirect_uri=" + URLEncoder.encode(redirect_uri, StandardCharsets.UTF_8)+
                    "&grant_type=authorization_code&code=Ebg_QPntbMym5bo3eLsPqmuxJ2OLAr3H3EUBDg3MujU";

            return s;

    }

}
