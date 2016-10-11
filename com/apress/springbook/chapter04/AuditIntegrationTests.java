package com.apress.springbook.chapter04;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class AuditIntegrationTests extends
      AbstractDependencyInjectionSpringContextTests {
   
  protected String[] getConfigLocations() {
    return new String[] {
      "classpath:com/apress/springbook/chapter04/" +
        "audit.xml"
    };
  }

  private BusinessOperations businessOperations;

  public void setBusinessOperations (
           BusinessOperations businessOperations ) {
    this.businessOperations = businessOperations;
  }

  public void testSensitive() throws Exception {
 
    System.out.println("=== GOING TO CALL METHOD " + 
            "ON NEWLY CREATED OBJECT ===");
      
    this.businessOperations.sensitiveOperation(1);

    System.out.println("=== FINISHED CALLING METHOD " + 
            "ON NEWLY CREATED OBJECT ===");
  }
}
