package com.apress.springbook.chapter02;

import org.junit.runner.notification.Failure;
import java.util.Iterator;

public class RunTests {
    public static void main(String[] args) {
	
	/*
	java.util.List<Failure> failures = 
	    org.junit.runner.JUnitCore.runClasses(com.apress.springbook.chapter02.ConstructorTestBeanIntegrationTests.class).getFailures();

	for (Iterator it=failures.iterator(); it.hasNext(); ) {
	    Failure failure = (Failure)it.next();
	    System.out.println(failure.getMessage());
	}
	*/
	
	/*
	java.util.List<Failure> failures = org.junit.runner.JUnitCore.runClasses(com.apress.springbook.chapter02.PropertyEditorTestBeanIntegrationTests.class).getFailures();
	
	for (Iterator it=failures.iterator(); it.hasNext(); ) {
	    Failure failure = (Failure)it.next();
	    System.out.println(failure);
	}
	*/

	/*
	java.util.List<Failure> failures = org.junit.runner.JUnitCore.runClasses(com.apress.springbook.chapter02.PrototypeIntegrationTests.class).getFailures();
	
	for (Iterator it=failures.iterator(); it.hasNext(); ) {
	    Failure failure = (Failure)it.next();
	    System.out.println(failure);
	}
	*/

	/*
	java.util.List<Failure> failures = org.junit.runner.JUnitCore.runClasses(com.apress.springbook.chapter02.BeanFactoryPreInstantiateSingletonsIntegrationTests.class).getFailures();
	
	for (Iterator it=failures.iterator(); it.hasNext(); ) {
	    Failure failure = (Failure)it.next();
	    System.out.println(failure);
	}
	*/

	/*
	java.util.List<Failure> failures = org.junit.runner.JUnitCore.runClasses(com.apress.springbook.chapter02.InitializingBeanNameClassIntegrationTests.class).getFailures();
	
	for (Iterator it=failures.iterator(); it.hasNext(); ) {
	    Failure failure = (Failure)it.next();
	    System.out.println(failure);
	}
	*/

	/*
	java.util.List<Failure> failures = org.junit.runner.JUnitCore.runClasses(com.apress.springbook.chapter02.InitializingBeanNumberClassIntegrationTests.class).getFailures();
	
	for (Iterator it=failures.iterator(); it.hasNext(); ) {
	    Failure failure = (Failure)it.next();
	    System.out.println(failure);
	}
	*/

	/*
	java.util.List<Failure> failures = org.junit.runner.JUnitCore.runClasses(com.apress.springbook.chapter02.CustomDestroyMethodNumberClassIntegrationTests.class).getFailures();
	
	for (Iterator it=failures.iterator(); it.hasNext(); ) {
	    Failure failure = (Failure)it.next();
	    System.out.println(failure);
	}
	*/

	/*
	java.util.List<Failure> failures = org.junit.runner.JUnitCore.runClasses(com.apress.springbook.chapter02.FactoryMethodIntegrationTests.class).getFailures();
	
	for (Iterator it=failures.iterator(); it.hasNext(); ) {
	    Failure failure = (Failure)it.next();
	    System.out.println(failure);
	}
	*/

	java.util.List<Failure> failures = org.junit.runner.JUnitCore.runClasses(com.apress.springbook.chapter02.FactoryObjectIntegrationTests.class).getFailures();
	
	for (Iterator it=failures.iterator(); it.hasNext(); ) {
	    Failure failure = (Failure)it.next();
	    System.out.println(failure);
	}
    }
}
