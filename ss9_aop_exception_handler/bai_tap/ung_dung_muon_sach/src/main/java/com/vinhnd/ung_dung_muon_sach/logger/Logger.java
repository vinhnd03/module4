package com.vinhnd.ung_dung_muon_sach.logger;

import com.vinhnd.ung_dung_muon_sach.entity.Book;
import com.vinhnd.ung_dung_muon_sach.util.WriteFileUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class Logger {
    private String currentTime = LocalDateTime.now().toString();
    @AfterReturning("execution(* com.vinhnd.ung_dung_muon_sach.service.BookService.borrowBook(..))")
    public void borrowSuccess(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature());
        WriteFileUtil.writeFile(currentTime + ": Mượn sách thành công");
    }

    @AfterThrowing("execution(* com.vinhnd.ung_dung_muon_sach.service.BookService.borrowBook(..))")
    public void borrowFailed(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature());
        WriteFileUtil.writeFile(currentTime + ": Mượn sách thất bại");
    }

    @AfterReturning("execution(* com.vinhnd.ung_dung_muon_sach.service.BookService.returnBook(..))")
    public void returnSuccess(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature());
        WriteFileUtil.writeFile(currentTime + ": Trả sách thành công");
    }

    @AfterThrowing("execution(* com.vinhnd.ung_dung_muon_sach.service.BookService.returnBook(..))")
    public void returnFailed(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature());
        WriteFileUtil.writeFile(currentTime + ": Trả sách thất bại");
    }
}
