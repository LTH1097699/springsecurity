package io.springsecurity4_enpointauthorization.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController4V2 {

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String hello(){
        return "hello";
    }
}
