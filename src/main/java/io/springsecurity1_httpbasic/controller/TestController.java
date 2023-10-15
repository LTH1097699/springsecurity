package io.springsecurity1_httpbasic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/demo")
    @ResponseStatus(HttpStatus.OK)
    public String test(){
        var u = SecurityContextHolder.getContext().getAuthentication();

       u.getAuthorities().forEach(it -> {
           System.out.println(it.getAuthority());
       });

        return "demo";
    }
}
