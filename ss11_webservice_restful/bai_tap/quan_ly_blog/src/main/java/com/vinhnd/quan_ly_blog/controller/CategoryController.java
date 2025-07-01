package com.vinhnd.quan_ly_blog.controller;

import com.vinhnd.quan_ly_blog.entity.Blog;
import com.vinhnd.quan_ly_blog.entity.Category;
import com.vinhnd.quan_ly_blog.service.IBlogService;
import com.vinhnd.quan_ly_blog.service.ICategoryService;
import com.vinhnd.quan_ly_blog.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("categories")
public class CategoryController {

    private final IBlogService blogService;
    private final ICategoryService categoryService;
    private final IUserService userService;

    public CategoryController(IBlogService blogService, ICategoryService categoryService, IUserService userService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
        this.userService = userService;
    }
    @GetMapping("")
    public String list(Model model){
        model.addAttribute("categoryList", categoryService.findAll());
        return "category/index";
    }
    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute Category category){
        categoryService.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        model.addAttribute("isEdit", true);
        return "category/create";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("id") Long id) {
        categoryService.deleteById(id);
        return "redirect:/categories";
    }
}

