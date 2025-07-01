package com.vinhnd.validate_form_dang_ky.repository;

import com.vinhnd.validate_form_dang_ky.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

}
