package com.vinhnd.quan_ly_blog.repository;

import com.vinhnd.quan_ly_blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
