package com.vinhnd.validate_form_dang_ky.service;

import com.vinhnd.validate_form_dang_ky.entity.User;
import com.vinhnd.validate_form_dang_ky.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    private final IUserRepository repository;

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
