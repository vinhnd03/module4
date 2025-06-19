package com.vinhnd.hom_thu_dien_tu.repository;

import com.vinhnd.hom_thu_dien_tu.entity.Email;

import java.util.List;

public interface IEmailRepository {
    List<Email> findAll();

    void add(Email email);

    Email findById(int id);

    void edit(Email email);
}
