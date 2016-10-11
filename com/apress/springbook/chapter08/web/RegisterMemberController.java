package com.apress.springbook.chapter08.web;

import java.util.Map;
import java.util.HashMap;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomNumberEditor;

import org.springframework.web.bind.ServletRequestDataBinder;

import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.mvc.SimpleFormController;

import com.apress.springbook.chapter08.domain.Member;
import com.apress.springbook.chapter08.domain.PhoneNumber;
import com.apress.springbook.chapter08.domain.MembershipService;

public class RegisterMemberController extends SimpleFormController  {
    
  private MembershipService membership;

  public RegisterMemberController() {
    setCommandClass(Member.class);
    setCommandName("member");
    setValidator(new MemberValidator());
    setSessionForm(true);
    setFormView("registerMember");
    setSuccessView("redirect:successRegisterMember");
  }
    
  public void setMembershipService(MembershipService membership) {
    this.membership = membership;
  }

  @Override
  protected void initBinder(HttpServletRequest request,
          ServletRequestDataBinder binder) throws Exception {
    binder.registerCustomEditor(Integer.class,
                                new CustomNumberEditor(Integer.class, true));
  }

  @Override
  protected boolean isFormChangeRequest(HttpServletRequest request) {
      return isAddPhoneNumberRequest(request) ||
             isRemovePhoneNumberRequest(request);
  }
    
  private Integer getPhoneNumberIndex(HttpServletRequest request) {
    Integer index = null;
    for (Enumeration e = request.getParameterNames(); e.hasMoreElements(); ) {
      String paramName = (String) e.nextElement();
      if (paramName.startsWith("action_removePhoneNumber_")) {
        index = Integer.valueOf(paramName.substring(
                        "action_removePhoneNumber_".length()));
        }
      }
      return index;
    }

  private boolean isRemovePhoneNumberRequest(HttpServletRequest request) {
    return (getPhoneNumberIndex(request) != null);
  }

  private boolean isAddPhoneNumberRequest(HttpServletRequest request) {
    return (request.getParameter("action_addPhoneNumber") != null);
  }

  @Override
  protected Object formBackingObject (HttpServletRequest request)
        throws Exception {
    Member member = new Member();
    member.addPhoneNumber(new PhoneNumber());
    return member;
  }

  @Override
  protected void onFormChange(HttpServletRequest request,
        HttpServletResponse response, Object command) throws Exception {
    Member member = (Member) command;
    if (isAddPhoneNumberRequest(request)) {
      member.addPhoneNumber(new PhoneNumber());
    } else if (isRemovePhoneNumberRequest(request)) {
      member.removePhoneNumber(getPhoneNumberIndex(request));
    }
  }
    
  @SuppressWarnings("unchecked")
  @Override
  protected Map referenceData(HttpServletRequest request) throws Exception {
    Map data = new HashMap();
    data.put("phoneNumberTypes", PhoneNumber.Type.values());
    return data;
  }

  @Override
  protected ModelAndView onSubmit(Object command) throws Exception {
    Member member = (Member) command;
    membership.saveMember(member);
    ModelAndView mav = new ModelAndView(getSuccessView());
    mav.addObject("memberName", member.getName().getFirst());
    mav.addObject("memberId", member.getId());
    return mav;
  }    
}
