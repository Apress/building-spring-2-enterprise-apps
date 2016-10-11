package com.apress.springbook.chapter08.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;

import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.mvc.AbstractController;

import org.displaytag.pagination.PaginatedList;

import org.displaytag.properties.SortOrderEnum;

import com.apress.springbook.chapter08.domain.Member;
import com.apress.springbook.chapter08.domain.MembershipService;

public class PaginatedAllMembersController extends AbstractController {

  private MembershipService membership;
  private static final int PAGE_LENGTH = 5;
  private int pageLength = PAGE_LENGTH;
    
  public PaginatedAllMembersController() {
    setSupportedMethods(new String[]{"GET"});
  }
    
  public void setPageLength(int pageLength) {
    this.pageLength = pageLength;
  }

  public void setMembershipService(MembershipService membershipService) {
    this.membership = membershipService;
  }

  @Override
  protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    final int pageNumber = ServletRequestUtils.getIntParameter(request, "page", 1);
    final String sortOrder = ServletRequestUtils.getStringParameter(request, "dir", "asc");
    final String sortCriterion = 
      ServletRequestUtils.getStringParameter(request, "sort", null);
        
    final List<Member> members = membership.getAllMembers(
                (pageNumber-1)*pageLength,
                pageLength, sortOrder, sortCriterion);
    final int numberMembers = membership.getNumberMembers();
        
    ModelAndView mav = new ModelAndView();
    mav.addObject("memberList", new PaginatedList() {

      public List getList() {
        return members;
      }

      public int getPageNumber() {
        return pageNumber;
      }

      public int getObjectsPerPage() {
        return pageLength;
      }

      public int getFullListSize() {
        return numberMembers;
      }

      public String getSortCriterion() {
        return sortCriterion;
      }

      public SortOrderEnum getSortDirection() {
        return sortOrder.equals("asc") ? SortOrderEnum.ASCENDING :
          SortOrderEnum.DESCENDING;
      }

      public String getSearchId() {
        return null;
      }
            
    });
    return mav;
  }
}
