package com.apress.springbook.chapter02;

import java.util.List;
import java.util.ArrayList;

public class CustomDestroyMethodNumberClass {
   private List<String> numbers = new ArrayList<String>();

   public CustomDestroyMethodNumberClass() {
      this.numbers.add("one");
      this.numbers.add("two");
      this.numbers.add("three");
   }

   public List<String> getNumbers() {
      return this.numbers;
   }

   public void close() throws Exception {
      this.numbers = null;
   }
}
