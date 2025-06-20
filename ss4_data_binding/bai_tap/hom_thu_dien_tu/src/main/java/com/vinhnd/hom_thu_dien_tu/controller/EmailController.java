package com.vinhnd.hom_thu_dien_tu.controller;

import com.vinhnd.hom_thu_dien_tu.entity.Email;
import com.vinhnd.hom_thu_dien_tu.service.IEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
public class EmailController {
    private final IEmailService emailService;
    private EmailController(IEmailService emailService){
        this.emailService = emailService;
    }


    @GetMapping("/email")
    private String home(Model model, @ModelAttribute("email") Email selectingEmail){

        if (selectingEmail != null) {
            model.addAttribute("email", selectingEmail); // dữ liệu để hiển thị lại trong form
        } else {
            model.addAttribute("email", new Email()); // form trống nếu không chọn gì
        }

        model.addAttribute("languages", Arrays.asList("English", "Vietnamese", "Japanese", "China"));
        model.addAttribute("sizes", Arrays.asList(5,10,15,25,50,100));
        model.addAttribute("emails", emailService.findAll());
        return "home";
    }

    @PostMapping("/add")
    private String add(@ModelAttribute Email email){
        Email newEmail = new Email(
                email.getLanguage(),
                email.getPageSize(),
                email.isFilter(),
                email.getSignature()
        );
        emailService.add(newEmail);
        return "redirect:/email";
    }

    @PostMapping("/edit")
    private String edit(@ModelAttribute Email email){
        emailService.edit(email);
        return "redirect:/email";
    }

    @GetMapping("/email/{id}")
    private String search(@PathVariable int id, RedirectAttributes attributes){
        Email email = emailService.findById(id);

        attributes.addFlashAttribute("email", email);
        attributes.addFlashAttribute("isUpdate", true);
        return "redirect:/email";
    }
}
