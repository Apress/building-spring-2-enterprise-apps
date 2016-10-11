package com.apress.springbook.chapter02;

import java.util.List;
import java.util.ArrayList;

public class ClassWithSharedMemberVariable {
   private List<String> numbers = new ArrayList<String>();

   public void initialize() {
      numbers.add("one");
      numbers.add("two");
      numbers.add("three");
   }
}
