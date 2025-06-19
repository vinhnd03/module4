package com.vinhnd.hom_thu_dien_tu.service;

import com.vinhnd.hom_thu_dien_tu.entity.Email;

import java.util.List;

public interface IEmailService {
    List<Email> findAll();

    void add(Email email);

    Email findById(int id);

    void edit(Email email);
}
