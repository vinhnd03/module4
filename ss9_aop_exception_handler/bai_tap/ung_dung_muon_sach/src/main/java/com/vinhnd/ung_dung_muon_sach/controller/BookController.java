package com.vinhnd.ung_dung_muon_sach.controller;

import com.vinhnd.ung_dung_muon_sach.entity.Book;
import com.vinhnd.ung_dung_muon_sach.exception.BookOutOfStockException;
import com.vinhnd.ung_dung_muon_sach.exception.WrongBookCodeException;
import com.vinhnd.ung_dung_muon_sach.service.IBookService;
import com.vinhnd.ung_dung_muon_sach.service.IBorrowDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
public class BookController {
    private final IBookService bookService;
    private final IBorrowDetailService detailService;

    public BookController(IBookService bookService, IBorrowDetailService detailService) {
        this.bookService = bookService;
        this.detailService = detailService;
    }

    @GetMapping("")
    public String bookList(Model model){
        model.addAttribute("books", bookService.findAll());
        return "book/list";
    }

    @GetMapping("{id}/detail")
    public String detail(@PathVariable("id") Long id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book/detail";
    }

    @GetMapping("/success")
    public String success(){
        return "book/success";
    }

    @GetMapping("/rent")
    public String rent(@RequestParam("id") Long id, RedirectAttributes attributes) throws BookOutOfStockException {
        Long code = bookService.borrowBook(id);
        attributes.addFlashAttribute("code", code);
        return "redirect:/books/success";
    }

    @GetMapping("/borrowList")
    public String borrowList(Model model){
        model.addAttribute("borrowList", detailService.findAll());
        return "book/borrow-list";
    }

    @GetMapping("/return")
    public String returnBook() {
        return "/book/return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam("code") Long code) throws WrongBookCodeException {
        bookService.returnBook(code);
        return "redirect:/books/borrowList";
    }

    @ExceptionHandler(BookOutOfStockException.class)
    public String showOutOfBookError() {
        return "error/out-of-stock";
    }

    @ExceptionHandler(WrongBookCodeException.class)
    public String showInputNotAcceptable(RedirectAttributes attributes) {
        attributes.addFlashAttribute("error", "Mã trả sách không đúng");
        return "redirect:/books/return";
    }
}
