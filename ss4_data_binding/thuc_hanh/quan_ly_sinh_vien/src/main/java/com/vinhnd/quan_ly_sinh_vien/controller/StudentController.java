package com.vinhnd.quan_ly_sinh_vien.controller;

import com.vinhnd.quan_ly_sinh_vien.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/students")
public class StudentController {
    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("student", new Student());
        return "student/create";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String submit(@ModelAttribute("student") Student student, ModelMap model) {
        model.addAttribute("name", student.getName());
        model.addAttribute("contactNumber", student.getContactNumber());
        model.addAttribute("id", student.getId());
        return "student/info";
    }
}
