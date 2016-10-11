package com.apress.springbook.chapter02;

import java.util.List;
import java.util.ArrayList;

public class CustomInitializationMethodNumberClass {
   private List<String> numbers = new ArrayList<String>();

   public List<String> getNumbers() {
      return this.numbers;
   }

   public void initialize() throws Exception {
       if (this.numbers.size() < 3) {
	   numbers.add("one");
	   numbers.add("two");
	   numbers.add("three");
       }
   } 
}

