package io.springsecurity5_methodauthorization.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController5 {

    @GetMapping("/demo1")
    @PreAuthorize("hasAuthority('ADMIN')") // @hasAnyAuthority(), @hasAnyRole(), @hasRole(), you can use any in that for apply rule in authority
    @ResponseStatus(HttpStatus.OK)
    public String demo(){
        return "demo1";
    }

    @GetMapping("/demo2")
    @ResponseStatus(HttpStatus.OK)
    public String demo2(){
        return "demo2";
    }

    @PostMapping("/demo3/{value}")
    @PreAuthorize("#value == authentication.name")
    @ResponseStatus(HttpStatus.OK)
    public String demo2Post(@PathVariable("value") String value){
        return "demo2";
    }
}
