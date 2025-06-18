package com.vinhnd.quan_ly_khach_hang.controller;

import com.vinhnd.quan_ly_khach_hang.entity.Customer;
import com.vinhnd.quan_ly_khach_hang.service.CustomerService;
import com.vinhnd.quan_ly_khach_hang.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    private String list(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customerList", customers);
        return "list";
    }

    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("info");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping
    public String updateCustomer(@RequestParam int id,
                                 @RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String address) {
        Customer customer = new Customer(id, name, email, address);
        customerService.save(customer);
        return "redirect:/customer";
    }
}
