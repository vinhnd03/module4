package com.vinhnd.demo_spring_security;

import com.vinhnd.demo_spring_security.entity.Role;
import com.vinhnd.demo_spring_security.entity.User;
import com.vinhnd.demo_spring_security.entity.UserRole;
import com.vinhnd.demo_spring_security.repository.IRoleRepository;
import com.vinhnd.demo_spring_security.repository.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class DemoSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringSecurityApplication.class, args);
    }

}
