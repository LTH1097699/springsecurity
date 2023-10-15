package io.springsecurity10_csrf.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController10 {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String demo2(){
        return "index.html";
    }

}
