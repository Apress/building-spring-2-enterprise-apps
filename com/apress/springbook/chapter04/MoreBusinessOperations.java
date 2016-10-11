/*
package com.apress.springbook.chapter04;

@Audit
public class MoreBusinessOperations {
  public void someSensitiveOperation(long recordId) {
    // do some work
    someOtherSensitiveOperation(recordId);
  }

  public void someOtherSensitiveOperation(long recordId) {
   // work with sensistive data
  }
}
*/
package com.apress.springbook.chapter04;

@Audit("top secret")
public class MoreBusinessOperations {
  public void someSensitiveOperation(long recordId) {
    // do some work
    someOtherSensitiveOperation(recordId);
  }

  public void someOtherSensitiveOperation(long recordId) {
    // work with sensistive data
  }
}
