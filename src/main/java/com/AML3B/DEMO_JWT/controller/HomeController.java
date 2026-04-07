package com.AML3B.DEMO_JWT.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "DEMOJWT is running. Use /api/hello or /api/login";
    }
}
