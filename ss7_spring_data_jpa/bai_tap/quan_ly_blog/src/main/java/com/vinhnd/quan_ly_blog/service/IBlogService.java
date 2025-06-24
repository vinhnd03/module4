package com.vinhnd.quan_ly_blog.service;

import com.vinhnd.quan_ly_blog.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Long id);

    void deleteById(Long id);
}
