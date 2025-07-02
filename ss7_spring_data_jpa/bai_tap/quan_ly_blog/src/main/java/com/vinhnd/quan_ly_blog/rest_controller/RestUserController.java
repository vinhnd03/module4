package com.vinhnd.quan_ly_blog.rest_controller;

import com.vinhnd.quan_ly_blog.entity.Category;
import com.vinhnd.quan_ly_blog.entity.User;
import com.vinhnd.quan_ly_blog.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/users")
public class RestUserController {
    private final IUserService userService;

    public RestUserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();
        if(users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }
}
