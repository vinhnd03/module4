package com.vinhnd.quan_ly_blog.service;

import com.vinhnd.quan_ly_blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog save(Blog blog);

    Blog findById(Long id);

    void deleteById(Long id);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findByTitle(String title, Pageable pageable);

    Page<Blog> findByTitleAndCategory(@Param("title") String title, @Param("cid") Long categoryId, Pageable pageable);
}
