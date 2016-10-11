package com.apress.springbook.chapter04.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnoyedMessagePrintingAspect {
  @Before("com.apress.springbook.chapter04.aspects." +
          "TennisMatchEventsAspect.atMatchStart()")
  public void printHowAnnoyedWeAre() {
    System.out.println("Leave it out! Another tennis match!?");
  }
}
