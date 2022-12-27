package ru.eugene.mvcfirst.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello-world")
    public String hello(){
        System.out.println("hello");
        return "hello_world";
    }
}
