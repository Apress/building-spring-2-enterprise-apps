package com.apress.springbook.chapter02;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.DisposableBean;

public class DisposableBeanNumberClass implements DisposableBean {
   private List<String> numbers = new ArrayList<String>();

   public DisposableBeanNumberClass() {
      this.numbers.add("one");
      this.numbers.add("two");
      this.numbers.add("three");
   }

   public List<String> getNumbers() {
      return this.numbers;
   }

   public void destroy() throws Exception {
      this.numbers = null;
   }
}
