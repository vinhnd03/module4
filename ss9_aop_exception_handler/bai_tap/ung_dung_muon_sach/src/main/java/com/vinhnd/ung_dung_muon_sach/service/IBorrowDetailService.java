package com.vinhnd.ung_dung_muon_sach.service;

import com.vinhnd.ung_dung_muon_sach.entity.BorrowDetail;

import java.util.List;

public interface IBorrowDetailService {
    void add(BorrowDetail borrowDetail);

    BorrowDetail findById(Long bookCode);

    List<BorrowDetail> findAll();
}
