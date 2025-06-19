package com.vinhnd.dang_nhap.repository;

import com.vinhnd.dang_nhap.entity.Login;
import com.vinhnd.dang_nhap.entity.User;

public interface IUserRepository {
    User checkLogin(Login login);
}
