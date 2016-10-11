package com.apress.springbook.chapter03;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterTest implements AfterReturningAdvice {

  public void afterReturning(
    Object returnValue, Method method, Object[] args, Object target)
       throws Throwable {
      System.out.println("After method call.");
  }
}
