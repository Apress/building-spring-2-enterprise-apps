package com.apress.springbook.chapter10;

import java.util.Date;

public class PayingMemberAdapterForMember {
  private Member member;
  private Date calculationDate;

  public PayingMemberAdapterForMember(Member member, Date calculationDate) {
    this.member = member;
    this.calculationDate = calculationDate;
  }
  public int getAge() {
    // calculate age at calculation date based on member
    // birth date.
      return 1;
  }
  public boolean isPaymentPerTrimester() {
    // get payment option for member and return
      return true;
  }
  boolean isMemberOfNationalTennisFederation() {
    // get membership details of member at the calculation date
      return true;
  }
}
