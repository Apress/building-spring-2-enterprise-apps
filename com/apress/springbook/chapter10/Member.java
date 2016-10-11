package com.apress.springbook.chapter10;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Member {
  private Integer id;
  private Name name = new Name();
  private Integer age;
  private Sex sex;
  private Address address = new Address();
  private List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

  public Member() { }

  public Member(String firstName, String lastName) {
    this.getName().setFirst(firstName);
    this.getName().setLast(lastName);
  }

  void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public Address getAddress() {
    return address;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Name getName() {
    return name;
  }

  public List<PhoneNumber> getPhoneNumbers() {
    return Collections.unmodifiableList(phoneNumbers);
  }

  public void addPhoneNumber(PhoneNumber phoneNumber) {
    this.phoneNumbers.add(phoneNumber);
  }

  public void removePhoneNumber(PhoneNumber phoneNumber) {
    this.phoneNumbers.remove(phoneNumber);
  }

  public void removePhoneNumber(int index) {
    this.phoneNumbers.remove(index);
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }
}
