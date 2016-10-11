package com.apress.springbook.chapter04.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.core.Ordered;

@Aspect
public class HappyMessagePrintingAspect implements Ordered {
  private int order = Integer.MAX_VALUE;

  public int getOrder() { return this.order; }

  public void setOrder(int order) { this.order = order; }

  @Before("com.apress.springbook.chapter04.aspects." +
          "TennisMatchEventsAspect.atMatchStart()")
  public void printHowExcitedWeAre() {
    System.out.println("Hurray for another tennis match!");
  }
}
