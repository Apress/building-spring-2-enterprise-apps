package com.apress.springbook.chapter04.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MySimpleAtAspectJAspect {
   @Before("execution(* relax(..))")
   public void beforeRelaxingMethod() {
      System.out.println("relax() method is about to be executed!");
   }
}
