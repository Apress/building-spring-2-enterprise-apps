package com.apress.springbook.chapter02;

import org.springframework.beans.factory.InitializingBean;

public class InitializingBeanNameClass implements InitializingBean {
   private String firstName;

   public String getFirstName() {
      return this.firstName;
   }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

   public void afterPropertiesSet() throws Exception {
       if (this.firstName == null) {
	   throw new RequiredPropertyNotSetException("firstName property is required.");

       }
   }

  private class RequiredPropertyNotSetException extends Exception {
      private RequiredPropertyNotSetException(String msg) {
	  super(msg);
      }
  }
}


