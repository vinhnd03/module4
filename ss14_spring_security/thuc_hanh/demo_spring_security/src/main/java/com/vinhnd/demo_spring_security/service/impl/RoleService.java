package com.vinhnd.demo_spring_security.service.impl;

import com.vinhnd.demo_spring_security.repository.IRoleRepository;
import com.vinhnd.demo_spring_security.service.IRoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    private final IRoleRepository repository;

    public RoleService(IRoleRepository repository) {
        this.repository = repository;
    }
}
