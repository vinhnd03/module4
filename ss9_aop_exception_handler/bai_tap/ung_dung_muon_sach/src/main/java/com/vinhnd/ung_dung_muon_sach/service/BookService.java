package com.vinhnd.ung_dung_muon_sach.service;

import com.vinhnd.ung_dung_muon_sach.entity.Book;
import com.vinhnd.ung_dung_muon_sach.entity.BorrowDetail;
import com.vinhnd.ung_dung_muon_sach.exception.BookOutOfStockException;
import com.vinhnd.ung_dung_muon_sach.exception.WrongBookCodeException;
import com.vinhnd.ung_dung_muon_sach.repository.IBookRepository;
import com.vinhnd.ung_dung_muon_sach.repository.IBorrowDetailRepository;
import com.vinhnd.ung_dung_muon_sach.util.GenerateCodeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService implements IBookService {
    private final IBookRepository repository;
    private final IBorrowDetailService detailService;

    public BookService(IBookRepository repository, IBorrowDetailService detailService) {
        this.repository = repository;
        this.detailService = detailService;
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Long borrowBook(Long id) throws BookOutOfStockException {
        Book book = findById(id);
        if ((book.getQuantity() - 1) < 0) {
            throw new BookOutOfStockException("Sách đã hết");
        }
        Long bookCode = GenerateCodeUtil.getCode();

        while (detailService.findById(bookCode) != null) {
            bookCode = GenerateCodeUtil.getCode();
        }

        detailService.add(new BorrowDetail(bookCode, LocalDate.now(), true, book));
        book.setQuantity(book.getQuantity() - 1);
        repository.save(book);

        return bookCode;
    }

    @Override
    @Transactional
    public void returnBook(Long code) throws WrongBookCodeException {
        BorrowDetail borrowDetail = detailService.findById(code);
        if (borrowDetail == null || !borrowDetail.getStatus()) {
            throw new WrongBookCodeException("Mã trả sách không đúng");
        }

        Book book = borrowDetail.getBook();
        borrowDetail.setStatus(false);
        book.setQuantity(book.getQuantity() + 1);

        detailService.add(borrowDetail);
        repository.save(book);
    }
}
