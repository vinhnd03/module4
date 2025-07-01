package com.vinhnd.quan_ly_blog.repository;

import com.vinhnd.quan_ly_blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
