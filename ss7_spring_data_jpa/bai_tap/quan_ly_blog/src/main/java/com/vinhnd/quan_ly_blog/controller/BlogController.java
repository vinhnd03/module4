package com.vinhnd.quan_ly_blog.controller;

import com.vinhnd.quan_ly_blog.entity.Blog;
import com.vinhnd.quan_ly_blog.entity.Category;
import com.vinhnd.quan_ly_blog.entity.User;
import com.vinhnd.quan_ly_blog.service.IBlogService;
import com.vinhnd.quan_ly_blog.service.ICategoryService;
import com.vinhnd.quan_ly_blog.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    private final IBlogService blogService;
    private final ICategoryService categoryService;
    private final IUserService userService;

    public BlogController(IBlogService blogService, ICategoryService categoryService, IUserService userService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @ModelAttribute("users")
    public List<User> getAllUser(){
        return userService.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategory(){
        return categoryService.findAll();
    }

    @GetMapping
    public String list(Model model){
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "blog/index";
    }

    @GetMapping("/new")
    public String create(Model model){
        Blog blog = new Blog();
        blog.setDate(LocalDate.now());
        model.addAttribute("blog", blog);
        return "blog/create";
    }

    @PostMapping("/new")
    public String save(@ModelAttribute Blog blog, RedirectAttributes attributes){
        blogService.save(blog);
        attributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/blogs";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") Long id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") Long id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        model.addAttribute("isEdit", true);
        return "blog/create";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model){
        blogService.deleteById(id);
        return "redirect:/blogs";
    }
}
