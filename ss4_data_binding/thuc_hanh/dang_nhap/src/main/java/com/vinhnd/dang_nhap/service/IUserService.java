package com.vinhnd.dang_nhap.service;

import com.vinhnd.dang_nhap.entity.Login;
import com.vinhnd.dang_nhap.entity.User;

public interface IUserService {
    User checkLogin(Login login);
}
