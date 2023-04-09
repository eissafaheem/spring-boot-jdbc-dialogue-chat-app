package com.dialogue.dialogue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    @GetMapping("/health")
    public String health(){
        return "Application is running.";
    }
}
