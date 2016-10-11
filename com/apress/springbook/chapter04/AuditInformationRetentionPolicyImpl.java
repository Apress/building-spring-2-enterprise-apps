package com.apress.springbook.chapter04;

public class AuditInformationRetentionPolicyImpl implements AuditInformationRetentionPolicy {
    public void retainMethodInvocationInformation(String currentUser, String methodDescription, Object[] arguments) {
	System.out.println("Audit: " + methodDescription);
    }
}
