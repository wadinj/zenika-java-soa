package com.wadinj.blog.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @RequestMapping("/")
    public String get() {
        return "Greetings from Spring Boot!";
    }
}
