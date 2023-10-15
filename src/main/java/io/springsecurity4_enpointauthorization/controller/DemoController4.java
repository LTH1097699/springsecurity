package io.springsecurity4_enpointauthorization.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController4 {

    @GetMapping("/demo1")
    @ResponseStatus(HttpStatus.OK)
    public String demo(){
        return "demo1";
    }

    @GetMapping("/demo2")
    @ResponseStatus(HttpStatus.OK)
    public String demo2(){
        return "demo2";
    }

    @PostMapping("/demo3")
    @ResponseStatus(HttpStatus.OK)
    public String demo2Post(){
        return "demo2";
    }
}
