package com.apress.springbook.chapter06;

import java.io.InputStream;
import java.io.OutputStream;

import java.util.List;

public interface MemberDao {
  int getTotalNumberOfMembers();

    Member load(Integer id);
  void add(Member member);
  void delete(Member member);

    void updateAge(Integer memberId, Integer age);

      long getTotalAge();
      long getAverageAge();
      long getOldestAge();
      long getYoungestAge();

      List getMembersForLastNameAndAge(String lastName, Integer age);
    //  void addImageForMember(Integer memberId, InputStream in);
      void getImage(Integer id, OutputStream out);
      void importMembers(List<Member> members);
  List loadAll();
}
