package com.apress.springbook.chapter03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import org.springframework.util.StopWatch;

public class SimpleProfilingAroundAdvice implements MethodInterceptor {
  public Object invoke(MethodInvocation invocation) throws Throwable {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();

    try {
      return invocation.proceed();
    } finally {
      stopWatch.stop();
      System.out.println(stopWatch.prettyPrint());
    }
  }
}
