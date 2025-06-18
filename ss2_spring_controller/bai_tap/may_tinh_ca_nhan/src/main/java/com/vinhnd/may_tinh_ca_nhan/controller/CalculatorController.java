package com.vinhnd.may_tinh_ca_nhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    private String home() {
        return "calculator";
    }

    @PostMapping("/add")
    private String add(@RequestParam(value = "num1", required = false, defaultValue = "0") float num1,
                       @RequestParam(value = "num2", required = false, defaultValue = "0") float num2, RedirectAttributes attributes) {
        float result = num1 + num2;
        attributes.addFlashAttribute("result", result);
        attributes.addFlashAttribute("num1", num1);
        attributes.addFlashAttribute("num2", num2);
        return "redirect:/calculator";
    }

    @PostMapping("/sub")
    private String sub(@RequestParam(value = "num1", required = false, defaultValue = "0") float num1,
                       @RequestParam(value = "num2", required = false, defaultValue = "0") float num2, RedirectAttributes attributes) {
        float result = num1 - num2;
        attributes.addFlashAttribute("result", result);
        attributes.addFlashAttribute("num1", num1);
        attributes.addFlashAttribute("num2", num2);
        return "redirect:/calculator";
    }

    @PostMapping("/mul")
    private String mul(@RequestParam(value = "num1", required = false, defaultValue = "0") float num1,
                       @RequestParam(value = "num2", required = false, defaultValue = "0") float num2, RedirectAttributes attributes) {
        float result = num1 * num2;
        attributes.addFlashAttribute("result", result);
        attributes.addFlashAttribute("num1", num1);
        attributes.addFlashAttribute("num2", num2);
        return "redirect:/calculator";
    }

    @PostMapping("/div")
    private String div(@RequestParam(value = "num1", required = false, defaultValue = "0") float num1,
                       @RequestParam(value = "num2", required = false, defaultValue = "0") float num2, RedirectAttributes attributes) {
        if (num2 == 0) {
            attributes.addFlashAttribute("result", "Can not divide by 0");
        } else {
            float result = num1 / num2;
            attributes.addFlashAttribute("result", result);
        }
        attributes.addFlashAttribute("num1", num1);
        attributes.addFlashAttribute("num2", num2);
        return "redirect:/calculator";
    }
}
