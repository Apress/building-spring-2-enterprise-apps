package com.apress.springbook.chapter03;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class TextMessageSendingAdvice implements AfterReturningAdvice {
  private MessageSender messageSender;

  public void setMessageSender(MessageSender messageSender) {
    this.messageSender = messageSender;
  }

  public void afterReturning(
    Object returnValue, Method method, Object[] args, Object target)
       throws Throwable {
    Match match = (Match)args[0];
    this.messageSender.notifyEndOfMatch(match);
  }
}
