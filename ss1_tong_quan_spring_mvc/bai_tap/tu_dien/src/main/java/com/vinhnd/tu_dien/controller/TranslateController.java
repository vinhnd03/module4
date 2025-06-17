package com.vinhnd.tu_dien.controller;

import com.vinhnd.tu_dien.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {
    @Autowired
    private IDictionaryService service;

    @GetMapping("/translate")
    private String home (){
        return "home";
    }

    @PostMapping("/translate")
    private String translate(Model model, @RequestParam("eng") String eng){
        String viet = service.findByWord(eng);
        if(viet != null){
            model.addAttribute("viet", viet);

        }else{
            model.addAttribute("message", "Từ không có trong từ điển");
        }
        model.addAttribute("eng", eng);
        return "home";
    }
}
