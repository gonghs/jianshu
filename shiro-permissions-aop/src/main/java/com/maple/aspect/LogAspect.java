//package com.maple.aspect;
//
//import com.maple.anno.Log;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
///**
// * 日志切面
// *
// * @author maple
// * @version 1.0
// * @since 2020-02-24 17:00
// */
//@Aspect
//@Component
//public class LogAspect {
//
//    @Around("@annotation(logAnnotation)")
//    public Object printLog(ProceedingJoinPoint joinPoint, Log logAnnotation) throws Throwable {
//        return joinPoint.proceed();
//    }
//}
//
