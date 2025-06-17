package com.vinhnd.quan_ly_khach_hang.controller;

import com.vinhnd.quan_ly_khach_hang.entity.Customer;
import com.vinhnd.quan_ly_khach_hang.service.CustomerService;
import com.vinhnd.quan_ly_khach_hang.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customer")
    private String list(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customerList", customers);
        return "list";
    }
}
