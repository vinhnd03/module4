package com.vinhnd.validate_form_dang_ky.controller;

import com.vinhnd.validate_form_dang_ky.dto.UserRequestDto;
import com.vinhnd.validate_form_dang_ky.entity.User;
import com.vinhnd.validate_form_dang_ky.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.beans.BeanProperty;

@Controller
public class RegisterController {
    private final IUserService userService;

    public RegisterController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String form(Model model){
        model.addAttribute("user", new UserRequestDto());
        return "register/form";
    }

    @PostMapping("/register")
    public String submit(Model model, @Valid @ModelAttribute("user") UserRequestDto userRequestDto, BindingResult result){
        new UserRequestDto().validate(userRequestDto, result);
        if(result.hasErrors()){
            return "register/form";
        }
        User user = new User();
        BeanUtils.copyProperties(userRequestDto, user);
        userService.save(user);
        model.addAttribute("user", new UserRequestDto());
        return "register/result";
    }

}
