package com.vinhnd.demo_spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String homePage(){
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // login.html
    }
}
