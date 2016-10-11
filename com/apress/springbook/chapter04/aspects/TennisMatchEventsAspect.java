package com.apress.springbook.chapter04.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TennisMatchEventsAspect {
  @Pointcut("execution(* startMatch(..))")
  public void atMatchStart() {}
}
