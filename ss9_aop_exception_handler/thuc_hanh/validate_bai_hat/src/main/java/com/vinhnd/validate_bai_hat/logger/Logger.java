package com.vinhnd.validate_bai_hat.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Logger {
    @AfterThrowing(pointcut = "execution(public * com.vinhnd.validate_bai_hat.service.SongService.findAll(..))", throwing = "e")
    public void logMethod(Exception e) {
        System.out.println("[CMS] co loi xay ra: " + e.getMessage());
    }

    @AfterThrowing(pointcut = "execution(public * com.vinhnd.validate_bai_hat.service.SongService.*(..))", throwing = "e")
    public void logClass(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.printf("[CMS] co loi xay ra: %s.%s%s: %s%n", className, method, args, e.getMessage());
    }

    @Around("execution(* com.vinhnd.validate_bai_hat.controller.SongController.save(..))")
    public Object TestAroundAOP(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("===========BEFORE===========");
        System.out.println(joinPoint.getSignature());
        Object object = joinPoint.proceed();
        System.out.println("===========AFTER============");
        return object;
    }
}
