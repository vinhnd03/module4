package com.vinhnd.quan_ly_blog.controller;

import com.vinhnd.quan_ly_blog.entity.Blog;
import com.vinhnd.quan_ly_blog.entity.Category;
import com.vinhnd.quan_ly_blog.entity.User;
import com.vinhnd.quan_ly_blog.service.IBlogService;
import com.vinhnd.quan_ly_blog.service.ICategoryService;
import com.vinhnd.quan_ly_blog.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Arrays;
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
    public List<User> getAllUser() {
        return userService.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategory() {
        return categoryService.findAll();
    }

    @ModelAttribute("sizeList")
    public List<Integer> getAllSize() {
        return Arrays.asList(1, 2, 3, 5, 7, 10);
    }

    @GetMapping
    public String list(Model model,
                       @RequestParam(required = false, defaultValue = "2") int size,
                       @RequestParam(required = false, defaultValue = "0") int page,
                       @RequestParam(required = false, defaultValue = "") String searchTitle,
                       @RequestParam(required = false, defaultValue = "0") Long searchCategory,
                       @RequestParam(required = false, defaultValue = "false") Boolean sortDate
    ) {
        Sort sort;
        if(sortDate){
            sort = Sort.by(Sort.Direction.ASC, "date").and(Sort.by(Sort.DEFAULT_DIRECTION, "title"));
        }else {
            sort = Sort.by(Sort.Direction.DESC, "date").and(Sort.by(Sort.DEFAULT_DIRECTION, "title"));
        }
        Pageable pageable = PageRequest.of(page, size, sort);
//        Page<Blog> blogPage = blogService.findAll(pageable);
//        Page<Blog> blogPage = blogService.findByTitle(searchTitle, pageable);
        Page<Blog> blogPage = blogService.findByTitleAndCategory(searchTitle, searchCategory, pageable);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("searchTitle", searchTitle);
        model.addAttribute("searchCategory", searchCategory);
        model.addAttribute("size", size);
        model.addAttribute("sortDate", sortDate);
        return "blog/index";
    }

    //    @GetMapping
//    public String list(Model model, @PageableDefault(size = 2, page = 0) Pageable pageable){
//        Page<Blog> blogPage = blogService.findAll(pageable);
//        model.addAttribute("blogPage", blogPage);
//        return "blog/index";
//    }
    @GetMapping("/new")
    public String create(Model model) {
        Blog blog = new Blog();
        blog.setDate(LocalDate.now());
        model.addAttribute("blog", blog);
        return "blog/create";
    }

    @PostMapping("/new")
    public String save(@ModelAttribute Blog blog, RedirectAttributes attributes) {
        blogService.save(blog);
        attributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/blogs";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        model.addAttribute("isEdit", true);
        return "blog/create";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model) {
        blogService.deleteById(id);
        return "redirect:/blogs";
    }
}
