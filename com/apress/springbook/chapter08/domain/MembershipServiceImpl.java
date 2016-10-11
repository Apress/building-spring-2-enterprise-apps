package com.apress.springbook.chapter08.domain;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public class MembershipServiceImpl implements MembershipService {
    
    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Transactional(readOnly=true)
    public List<Member> getAllMembers() {
        return memberDao.findAll();
    }

    @Transactional(readOnly=true)
    public int getNumberMembers() {
        return memberDao.getNumberMembers();
    }

    @Transactional(readOnly=true)
    public List<Member> getAllMembers(int begin, int pageLength,
            String sortOrder, String sortCriterion) {
        return memberDao.findAll(begin, pageLength, sortOrder, sortCriterion);
    }

    @Transactional
    public void saveMember(Member member) {
        memberDao.save(member);
    }

    public List<Member> findMembersByFirstOrLastName(String criteria) {
        return memberDao.findByFirstOrLastName(criteria);
    }

}
