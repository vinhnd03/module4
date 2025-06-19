package com.vinhnd.dang_nhap.service;

import com.vinhnd.dang_nhap.entity.Login;
import com.vinhnd.dang_nhap.entity.User;
import com.vinhnd.dang_nhap.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository repository;


    @Override
    public User checkLogin(Login login) {
        return repository.checkLogin(login);
    }
}
