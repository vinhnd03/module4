package com.vinhnd.quan_ly_blog.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/user/home")
    public String user(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        return "user";
    }

    @GetMapping("/admin/home")
    public String admin(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<String> roles =  authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        model.addAttribute("username", username);
        model.addAttribute("roles", roles);
        return "admin";
    }

    @GetMapping("/login")
    public String login(){
        return "custom_login";
    }
}
