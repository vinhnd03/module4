package com.vinhnd.demo_spring_security.service.impl;

import com.vinhnd.demo_spring_security.repository.IUserRepository;
import com.vinhnd.demo_spring_security.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final IUserRepository repository;

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }
}
