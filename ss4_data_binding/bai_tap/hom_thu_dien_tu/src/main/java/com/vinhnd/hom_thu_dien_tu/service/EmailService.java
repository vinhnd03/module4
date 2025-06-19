package com.vinhnd.hom_thu_dien_tu.service;

import com.vinhnd.hom_thu_dien_tu.entity.Email;
import com.vinhnd.hom_thu_dien_tu.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService{
    @Autowired
    private IEmailRepository repository;

    @Override
    public List<Email> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(Email email) {
        repository.add(email);
    }

    @Override
    public Email findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void edit(Email email) {
        repository.edit(email);
    }
}
