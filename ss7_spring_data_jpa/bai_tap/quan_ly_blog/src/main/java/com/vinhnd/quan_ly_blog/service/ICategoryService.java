package com.vinhnd.quan_ly_blog.service;

import com.vinhnd.quan_ly_blog.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);

    Category findById(Long id);

    void deleteById(Long id);
}
