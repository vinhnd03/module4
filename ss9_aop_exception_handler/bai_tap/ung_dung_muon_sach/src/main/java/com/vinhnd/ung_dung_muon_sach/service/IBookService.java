package com.vinhnd.ung_dung_muon_sach.service;

import com.vinhnd.ung_dung_muon_sach.entity.Book;
import com.vinhnd.ung_dung_muon_sach.exception.BookOutOfStockException;
import com.vinhnd.ung_dung_muon_sach.exception.WrongBookCodeException;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(Long id);

    Long borrowBook(Long id) throws BookOutOfStockException;

    void returnBook(Long code) throws WrongBookCodeException;


}
