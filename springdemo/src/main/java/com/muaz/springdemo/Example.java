package com.muaz.springdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class Example {

    @CrossOrigin
    @GetMapping("/")
    public String helloWorld() {
        return "Hi Muaz!\n";
    }
}
