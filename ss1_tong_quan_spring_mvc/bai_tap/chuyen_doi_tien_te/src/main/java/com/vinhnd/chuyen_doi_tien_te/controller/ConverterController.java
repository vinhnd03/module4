package com.vinhnd.chuyen_doi_tien_te.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
    @GetMapping("/converter")
    private String home(){
        return "home";
    }

    @PostMapping("/converter")
    private String convert(Model model, @RequestParam("usd") Integer usd){
        Integer vnd = usd * 24000;
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", usd);
        return "home";
    }
}
