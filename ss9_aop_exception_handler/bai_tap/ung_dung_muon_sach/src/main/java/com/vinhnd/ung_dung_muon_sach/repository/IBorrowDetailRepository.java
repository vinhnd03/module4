package com.vinhnd.ung_dung_muon_sach.repository;

import com.vinhnd.ung_dung_muon_sach.entity.BorrowDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowDetailRepository extends JpaRepository<BorrowDetail, Long> {
}
