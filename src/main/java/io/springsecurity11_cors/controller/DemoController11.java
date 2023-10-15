package io.springsecurity11_cors.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController11 {

    @GetMapping("/demo")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin("http://localhost:8080") // or "*" not recommend in prod
    public String demo2(){
        return "index.html";
    }

}
