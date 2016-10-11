package com.apress.springbook.chapter08.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.mvc.AbstractController;

import com.apress.springbook.chapter08.domain.Member;
import com.apress.springbook.chapter08.domain.MembershipService;

public class SearchForMembersController extends AbstractController {
    
  private MembershipService membership;
  private String searchForMemberResultViewName = "allmembers";

  public void setMembershipService(MembershipService membership) {
    this.membership = membership;
  }

  @Override
  protected ModelAndView handleRequestInternal(HttpServletRequest request,
          HttpServletResponse response) throws Exception {
    List<Member> members = 
      membership.findMembersByFirstOrLastName(request.getParameter("q"));
    ModelAndView mav = new ModelAndView(searchForMemberResultViewName);
    mav.addObject(members);
    return mav;
  }
}
