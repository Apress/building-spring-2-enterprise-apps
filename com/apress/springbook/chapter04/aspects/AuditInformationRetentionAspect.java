/*
package com.apress.springbook.chapter04.aspects;

import com.apress.springbook.chapter04.CurrentUserInformation;
import com.apress.springbook.chapter04.AuditInformationRetentionPolicy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.aspectj.lang.JoinPoint;

@Aspect
public class AuditInformationRetentionAspect {

  private AuditInformationRetentionPolicy auditInformationRetentionPolicy;
  private CurrentUserInformation currentUserInformation;

  public void setAuditInformationRetentionPolicy(
    AuditInformationRetentionPolicy auditInformationRetentionPolicy
  ) {
    this.auditInformationRetentionPolicy = auditInformationRetentionPolicy;
  }

  public void setCurrentUserInformation
  (
    CurrentUserInformation currentUserInformation
  ) {
    this.currentUserInformation = currentUserInformation;
  }

  public void init() {
    if (this.auditInformationRetentionPolicy == null) {
      throw new IllegalStateException("AuditInformationRetentionPolicy " +
          "object is not set!");
    }
    if (this.currentUserInformation == null) {
      throw new IllegalStateException("CurrentUserInformation " +
          "object is not set!");
    }
  }

  @Before("com.apress.springbook.chapter04.aspects." +
          "SystemPointcutsAspect.auditableMethods()")
  public void retainMethodInvocationInformation(JoinPoint joinPoint) {
    String currentUser = this.currentUserInformation.getUsername();
    String methodDescription = joinPoint.getSignature().toLongString();
    Object[] arguments = joinPoint.getArgs();

    this.auditInformationRetentionPolicy.retainMethodInvocationInformation(
       currentUser, methodDescription, arguments);
  }
}
*/

package com.apress.springbook.chapter04.aspects;

import com.apress.springbook.chapter04.Audit;
import com.apress.springbook.chapter04.CurrentUserInformation;
import com.apress.springbook.chapter04.AuditInformationRetentionPolicy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.aspectj.lang.JoinPoint;

@Aspect
public class AuditInformationRetentionAspect {
  private AuditInformationRetentionPolicy auditInformationRetentionPolicy;
  private CurrentUserInformation currentUserInformation;

  public void setAuditInformationRetentionPolicy(
       AuditInformationRetentionPolicy auditInformationRetentionPolicy) {
    this.auditInformationRetentionPolicy = auditInformationRetentionPolicy;
  }

  public void setCurrentUserInformation(
       CurrentUserInformation currentUserInformation) {
    this.currentUserInformation = currentUserInformation;
  }

  public void init() {
    if (this.auditInformationRetentionPolicy == null) {
      throw new IllegalStateException("AuditInformationRetentionPolicy " +
          "object is not set!");
    }

    if (this.currentUserInformation == null) {
      throw new IllegalStateException("CurrentUserInformation " +
          "object is not set!");
    }
  }

  @Before("com.apress.springbook.chapter04.aspects." +
          "SystemPointcutsAspect.auditableMethods(audit)")
  public void retainMethodInvocationInformation(JoinPoint joinPoint, Audit audit) {
    String currentUser = this.currentUserInformation.getUsername();
    String methodDescription = audit.value() + ":" + 
            joinPoint.getSignature().toLongString();
    Object[] arguments = joinPoint.getArgs();

    this.auditInformationRetentionPolicy.retainMethodInvocationInformation(
       currentUser, methodDescription, arguments);
  }
}
