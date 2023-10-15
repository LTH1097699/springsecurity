package io.springsecurity2_customauthentication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController2 {

    @GetMapping("/demo")
    @ResponseStatus(HttpStatus.OK)
    public String demo(){
        return "demo";
    }
}
