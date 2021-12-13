package com.example.FifthSpringFinal.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;


@Aspect
@Configuration
public class AspectConfig {

    private Logger log = LoggerFactory.getLogger(AspectConfig.class);

    @Before(value = "execution(* com.example.FifthSpringFinal.controllers.*.*(..))")
    public void logStatmentBefore(JoinPoint joinPoint) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("Executing {} By User {} ", joinPoint, auth.getName());
    }

    @After(value = "execution(* com.example.FifthSpringFinal.controllers.*.*(..))")
    public void logStatmentAfter(JoinPoint joinPoint) {
        log.info("Complete Executing of {}", joinPoint);
    }

//    @Around(value = "execution(* com.example.FifthSpringFinal.controllers.*.*(..))")
//    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        long startTime = System.currentTimeMillis();
//        System.out.println("logAround() is running!");
//        System.out.println("The method : " + joinPoint.getSignature().getName());
//        System.out.println("The arguments : " + Arrays.toString(joinPoint.getArgs()));
//
//        System.out.println("Around before is running!");
//        joinPoint.proceed(); //continue on the intercepted method
//        System.out.println("Around after is running!");
//
//        long timeTaken = System.currentTimeMillis() - startTime;
//        System.out.println("******");
//        log.info("Time Taken by {} is {}", joinPoint, timeTaken);
//    }

}

