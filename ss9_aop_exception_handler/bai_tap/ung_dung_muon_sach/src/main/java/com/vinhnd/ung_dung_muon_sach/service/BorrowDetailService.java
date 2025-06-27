package com.vinhnd.ung_dung_muon_sach.service;

import com.vinhnd.ung_dung_muon_sach.entity.BorrowDetail;
import com.vinhnd.ung_dung_muon_sach.repository.IBorrowDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowDetailService implements IBorrowDetailService{
    private final IBorrowDetailRepository repository;

    public BorrowDetailService(IBorrowDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(BorrowDetail borrowDetail) {
        repository.save(borrowDetail);
    }

    @Override
    public BorrowDetail findById(Long bookCode) {
        return repository.findById(bookCode).orElse(null);
    }

    @Override
    public List<BorrowDetail> findAll() {
        return repository.findAll();
    }
}
