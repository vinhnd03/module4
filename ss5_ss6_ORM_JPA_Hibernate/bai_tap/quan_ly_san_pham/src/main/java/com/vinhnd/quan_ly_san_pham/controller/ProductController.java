package com.vinhnd.quan_ly_san_pham.controller;

import com.vinhnd.quan_ly_san_pham.entity.Product;
import com.vinhnd.quan_ly_san_pham.service.IProductService;
import com.vinhnd.quan_ly_san_pham.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }

    @GetMapping("")
    private String home(Model model, @RequestParam(value = "searchName", required = false, defaultValue = "") String searchName){
        model.addAttribute("products", service.findByName(searchName));
        model.addAttribute("searchName", searchName);
        return "index";
    }

    @GetMapping("/create")
    private String create(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    private String create(Product product, RedirectAttributes attributes){
        service.add(new Product(product.getName(), product.getPrice(), product.getDescription(), product.getBrand()));
        attributes.addFlashAttribute("success", "Thêm mới thành công");
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    private String update(@PathVariable int id, Model model){
        Product product = service.findById(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/update")
    private String update(Product product, RedirectAttributes attributes){
        service.updateById(product.getId(), product);
        attributes.addFlashAttribute("success", "Cập nhật thành công");
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    private String update(@PathVariable int id, RedirectAttributes attributes){
        service.deleteById(id);
        attributes.addFlashAttribute("success", "Xóa thành công");
        return "redirect:/products";
    }

    @GetMapping("/{id}/view")
    private String view(@PathVariable int id, Model model){
        Product product = service.findById(id);
        model.addAttribute("product", product);
        return "view";
    }
}
