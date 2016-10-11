package com.apress.springbook.chapter03;

import org.springframework.beans.factory.InitializingBean;

public class InitializingBeanNameClass {
   private String firstName;

   public String getFirstName() {
      return this.firstName;
   }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public void showValues() {
	System.out.println("First name: " + this.firstName);
    }
}


