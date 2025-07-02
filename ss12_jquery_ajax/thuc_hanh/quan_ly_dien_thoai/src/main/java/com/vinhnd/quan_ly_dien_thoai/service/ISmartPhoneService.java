package com.vinhnd.quan_ly_dien_thoai.service;

import com.vinhnd.quan_ly_dien_thoai.entity.SmartPhone;

import java.util.List;
import java.util.Optional;

public interface ISmartPhoneService {
    List<SmartPhone> findAll();

    Optional<SmartPhone> findById(Long id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(Long id);
}
