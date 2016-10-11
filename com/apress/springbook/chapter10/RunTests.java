package com.apress.springbook.chapter10;

import org.junit.runner.notification.Failure;
import java.util.Iterator;

public class RunTests {
    public static void main(String[] args) {

	/*
	java.util.List<Failure> failures = org.junit.runner.JUnitCore.runClasses(com.apress.springbook.chapter10.RegularMembershipFeeCalculatorTests.class).getFailures();
	
	for (Iterator it=failures.iterator(); it.hasNext(); ) {
	    Failure failure = (Failure)it.next();
	    System.out.println(failure);
	}
    
	*/

	/*
	java.util.List<Failure> failures = org.junit.runner.JUnitCore.runClasses(com.apress.springbook.chapter10.DefaultCurrencyConverterTests.class).getFailures();
	
	for (Iterator it=failures.iterator(); it.hasNext(); ) {
	    Failure failure = (Failure)it.next();
	    System.out.println(failure);
	    }*/

	java.util.List<Failure> failures = org.junit.runner.JUnitCore.runClasses(com.apress.springbook.chapter10.CurrencyConverterIntegrationTests.class).getFailures();
	
	for (Iterator it=failures.iterator(); it.hasNext(); ) {
	    Failure failure = (Failure)it.next();
	    System.out.println(failure);
	    }

    }
	

}
