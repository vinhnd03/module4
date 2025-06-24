package com.vinhnd.quan_ly_blog.service;

import com.vinhnd.quan_ly_blog.entity.User;
import com.vinhnd.quan_ly_blog.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    private final IUserRepository repository;

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
