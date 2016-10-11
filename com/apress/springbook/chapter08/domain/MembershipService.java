package com.apress.springbook.chapter08.domain;

import java.util.List;


public interface MembershipService {

    List<Member> getAllMembers();

    int getNumberMembers();

    List<Member> getAllMembers(int start, int pageLength, String sortOrder,
            String sortCriterion);

    void saveMember(Member member);

    List<Member> findMembersByFirstOrLastName(String criteria);
    
}
