/*
package com.apress.springbook.chapter04;

public class BusinessOperations {
   @Audit
   public void sensitiveOperation(long recordId) {
              System.out.println("Called sensitive");
}
}
*/
package com.apress.springbook.chapter04;

@Audit("top secret")
public class BusinessOperations {

  public void sensitiveOperation(long recordId) { }
}
