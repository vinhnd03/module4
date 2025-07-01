package com.vinhnd.quan_ly_blog.rest_controller;

import com.vinhnd.quan_ly_blog.entity.Blog;
import com.vinhnd.quan_ly_blog.service.IBlogService;
import com.vinhnd.quan_ly_blog.service.ICategoryService;
import com.vinhnd.quan_ly_blog.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/blogs")
public class RestBlogController {
    private final IBlogService blogService;
    private final ICategoryService categoryService;
    private final IUserService userService;

    public RestBlogController(IBlogService blogService, ICategoryService categoryService, IUserService userService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
        this.userService = userService;
    }


//    @GetMapping()
//    public ResponseEntity<List<Blog>> getAll(@PageableDefault(size = 5, page = 0) Pageable pageable){
//        Page<Blog> blogPage = blogService.findAll(pageable);
//        if(blogPage.getContent().isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity(blogPage.getContent(), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getOne(@PathVariable("id") Long id){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Blog> add(@RequestBody Blog blog){
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            Blog savedBlog =  blogService.save(blog);
            return new ResponseEntity<>(savedBlog, HttpStatus.CREATED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> put(@PathVariable("id") Long id, @RequestBody Blog editedBlog){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            editedBlog.setId(id);
            return new ResponseEntity<>(blogService.save(editedBlog), HttpStatus.OK);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Blog> patch(@PathVariable("id") Long id,@RequestBody Map<String, Object> update){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(update.containsKey("title")){
            blog.setTitle((String) update.get("title"));
        } else if (update.containsKey("content")) {
            blog.setContent((String) update.get("title"));
        } else if (update.containsKey("date")) {
            blog.setDate((LocalDate) update.get("date"));
        }

        Blog updatedBlog = blogService.save(blog);
        return new ResponseEntity<>(updatedBlog, HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") Long id){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            blogService.deleteById(id);
            return new ResponseEntity<>(blog, HttpStatus.OK);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Blog>> findAll(@RequestParam(name = "categoryId",required = false, defaultValue = "0") Long cid,
                                                     @RequestParam(required = false, defaultValue = "") String title,
                                                     @PageableDefault(size = 5, page = 0) Pageable pageable){
        Page<Blog> blogs = blogService.findByTitleAndCategory(title, cid, pageable);
        if(blogs.getContent().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(blogs.getContent(), HttpStatus.OK);
        }
    }


}
