package com.apress.springbook.chapter04.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemPointcutsAspect {
  @Pointcut("within(com.apress.springbook.chapter04..*)")
  public void inServiceLayer() {}
}
