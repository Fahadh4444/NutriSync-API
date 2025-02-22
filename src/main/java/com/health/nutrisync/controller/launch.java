package com.health.nutrisync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/launch")
public class launch {
    @GetMapping(path = "/hello")
    public String hello(){
        return "Hello All!!!";
    }
}
