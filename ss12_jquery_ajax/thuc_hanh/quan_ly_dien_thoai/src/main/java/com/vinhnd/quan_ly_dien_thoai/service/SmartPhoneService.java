package com.vinhnd.quan_ly_dien_thoai.service;

import com.vinhnd.quan_ly_dien_thoai.entity.SmartPhone;
import com.vinhnd.quan_ly_dien_thoai.repository.ISmartPhoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmartPhoneService implements ISmartPhoneService{
    private final ISmartPhoneRepository repository;

    public SmartPhoneService(ISmartPhoneRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SmartPhone> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return repository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
