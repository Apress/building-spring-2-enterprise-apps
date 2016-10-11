package com.apress.springbook.chapter04;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

public class SecurityEnforcer {
  public void denyAccessToAll() {
    throw new IllegalStateException("This system has been compromised. " + 
           "Access is denied to all!");
  }
}
