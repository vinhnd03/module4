package com.vinhnd.demo_spring_security.repository;

import com.vinhnd.demo_spring_security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
}
