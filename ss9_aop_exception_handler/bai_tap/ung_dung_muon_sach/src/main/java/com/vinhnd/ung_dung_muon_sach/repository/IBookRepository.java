package com.vinhnd.ung_dung_muon_sach.repository;

import com.vinhnd.ung_dung_muon_sach.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
