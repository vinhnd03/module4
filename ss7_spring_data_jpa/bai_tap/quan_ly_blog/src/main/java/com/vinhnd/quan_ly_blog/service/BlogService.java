package com.vinhnd.quan_ly_blog.service;

import com.vinhnd.quan_ly_blog.entity.Blog;
import com.vinhnd.quan_ly_blog.repository.IBlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    private final IBlogRepository repository;

    public BlogService(IBlogRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Blog> findByTitle(String title, Pageable pageable) {
        return repository.findByTitle(title, pageable);
    }

    @Override
    public Page<Blog> findByTitleAndCategory(String title, Long categoryId, Pageable pageable) {
        return repository.findByTitleAndCategory(title, categoryId, pageable);
    }
}
