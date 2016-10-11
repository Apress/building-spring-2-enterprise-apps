package com.apress.springbook.chapter04;

public interface AuditInformationRetentionPolicy {
  public void retainMethodInvocationInformation(
     String currentUser, String methodDescription, Object[] arguments);
}
