package com.vinhnd.quan_ly_blog.repository;

import com.vinhnd.quan_ly_blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
}
