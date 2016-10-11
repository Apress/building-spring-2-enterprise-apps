package com.apress.springbook.chapter02;

public class ConstructorTestBean {
   private boolean constructor1Used = false;
   private boolean constructor2Used = false;

   public ConstructorTestBean(String name, Integer id) {
      this.constructor1Used = true;
   }

   public ConstructorTestBean(String firstName, String lastName) {
      this.constructor2Used = true;
   }

   public boolean isConstructor1Used() {
      return this.constructor1Used;
   }

   public boolean isConstructor2Used() {
      return this.constructor2Used;
   }
}
