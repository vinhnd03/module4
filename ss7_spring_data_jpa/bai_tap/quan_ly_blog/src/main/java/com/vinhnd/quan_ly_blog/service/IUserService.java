package com.vinhnd.quan_ly_blog.service;

import com.vinhnd.quan_ly_blog.entity.MyUser;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<MyUser> findAll();
}
