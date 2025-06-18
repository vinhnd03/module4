package com.vinhnd.gia_vi_sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SandwichController {
    @GetMapping("/sandwich")
    private String index (){
        return "condiment";
    }

    @PostMapping("/add")
    private String add (@RequestParam(required = false) String[] condiments, RedirectAttributes attributes){
        if(condiments != null && condiments.length > 0){
            attributes.addFlashAttribute("condiments", condiments);
        }
        return "redirect:/sandwich";
    }
}
