package com.vinhnd.quan_ly_blog.service;

import com.vinhnd.quan_ly_blog.entity.Category;
import com.vinhnd.quan_ly_blog.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    private final ICategoryRepository repository;

    public CategoryService(ICategoryRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Category category) {
        repository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
