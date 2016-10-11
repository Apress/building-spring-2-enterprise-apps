package com.apress.springbook.chapter04;

import org.junit.runner.notification.Failure;
import java.util.Iterator;

public class RunTests {
    public static void main(String[] args) {
	
	/*
	java.util.List<Failure> failures = org.junit.runner.JUnitCore.runClasses(com.apress.springbook.chapter04.MessagePrintingAspectIntegrationTests.class).getFailures();
	
	for (Iterator it=failures.iterator(); it.hasNext(); ) {
	    Failure failure = (Failure)it.next();
	    System.out.println(failure);
	}
	*/

	/*
	java.util.List<Failure> failures = org.junit.runner.JUnitCore.runClasses(com.apress.springbook.chapter04.MessagePrintingXmlAspectIntegrationTests.class).getFailures();
	
	for (Iterator it=failures.iterator(); it.hasNext(); ) {
	    Failure failure = (Failure)it.next();
	    System.out.println(failure);
	
	    }
	*/
	
	java.util.List<Failure> failures = org.junit.runner.JUnitCore.runClasses(com.apress.springbook.chapter04.AuditIntegrationTests.class).getFailures();
	
	for (Iterator it=failures.iterator(); it.hasNext(); ) {
	    Failure failure = (Failure)it.next();
	    System.out.println(failure);
	}
	
    }
}
