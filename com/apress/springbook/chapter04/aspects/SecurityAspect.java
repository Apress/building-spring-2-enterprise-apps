package com.apress.springbook.chapter04.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SecurityAspect {
  @Before("com.apress.springbook.chapter04.aspects." +
         "SystemPointcutsAspect.inServiceLayer()")
  public void denyAccessToAll() {
    throw new IllegalStateException("This system has been compromised. " + 
           "Access is denied to all!");
  }
}
