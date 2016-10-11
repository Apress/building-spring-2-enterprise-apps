package com.apress.springbook.chapter10;

import junit.framework.TestCase;

public class RegularMembershipFeeCalculatorTests
     extends TestCase {

  public void testLessThan14YearsOldPerTrimesterNoNTFMember() {
    MembershipFeeCalculator mfc = new RegularMembershipFeeCalculator();
      
    PayingMember payingMember = new TestPayingMember(13, true, false);

    double result = mfc.calculateMembershipFee(payingMember);

    assertEquals((double)25, result);
  }

  public void testLessThan14YearsOldPerAnnumNoNTFMember() {
    MembershipFeeCalculator mfc = new RegularMembershipFeeCalculator();
      
    PayingMember payingMember = new TestPayingMember(13, false, false);

    double result = mfc.calculateMembershipFee(payingMember);

    assertEquals((double)90, result);
  }

  public void testLessThan14YearsOldPerTrimesterNTFMember() {
    MembershipFeeCalculator mfc = new RegularMembershipFeeCalculator();
      
    PayingMember payingMember = new TestPayingMember(13, true, true);

    double result = mfc.calculateMembershipFee(payingMember);

    assertEquals((double)25 * 0.75, result);
  }

  public void testLessThan14YearsOldPerAnnumNTFMember() {
    MembershipFeeCalculator mfc = new RegularMembershipFeeCalculator();
      
    PayingMember payingMember = new TestPayingMember(13, false, true);

    double result = mfc.calculateMembershipFee(payingMember);

    assertEquals((double)90 * 0.75, result);
  }

  public void testAdultPerAnnumNTFMember() {
    MembershipFeeCalculator mfc = new RegularMembershipFeeCalculator();
      
    PayingMember payingMember = new TestPayingMember(23, false, true);

    double result = mfc.calculateMembershipFee(payingMember);

    assertEquals((double)180 * 0.75, result);
  }

  public void testAdultPerTrimesterNTFMember() {
    MembershipFeeCalculator mfc = new RegularMembershipFeeCalculator();
      
    PayingMember payingMember = new TestPayingMember(23, true, true);

    double result = mfc.calculateMembershipFee(payingMember);

    assertEquals((double)50 * 0.75, result);
  }

  public void testAdultPerAnnumNoNTFMember() {
    MembershipFeeCalculator mfc = new RegularMembershipFeeCalculator();
      
    PayingMember payingMember = new TestPayingMember(23, false, false);

    double result = mfc.calculateMembershipFee(payingMember);

    assertEquals((double)180, result);
  }

  public void testAdultPerTrimesterNoNTFMember() {
    MembershipFeeCalculator mfc = new RegularMembershipFeeCalculator();
      
    PayingMember payingMember = new TestPayingMember(23, true, false);

    double result = mfc.calculateMembershipFee(payingMember);

    assertEquals((double)50, result);
  }

  public void testTeenPerAnnumNTFMember() {
    MembershipFeeCalculator mfc = new RegularMembershipFeeCalculator();
      
    PayingMember payingMember = new TestPayingMember(15, false, true);

    double result = mfc.calculateMembershipFee(payingMember);

    assertEquals((double)126 * 0.75, result);
  }

  public void testTeenPerTrimesterNTFMember() {
    MembershipFeeCalculator mfc = new RegularMembershipFeeCalculator();
      
    PayingMember payingMember = new TestPayingMember(15, true, true);

    double result = mfc.calculateMembershipFee(payingMember);

    assertEquals((double)35 * 0.75, result);
  }

  public void testTeenPerAnnumNoNTFMember() {
    MembershipFeeCalculator mfc = new RegularMembershipFeeCalculator();
      
    PayingMember payingMember = new TestPayingMember(15, false, false);

    double result = mfc.calculateMembershipFee(payingMember);

    assertEquals((double)126, result);
  }

  public void testTeenPerTrimesterNoNTFMember() {
    MembershipFeeCalculator mfc = new RegularMembershipFeeCalculator();
      
    PayingMember payingMember = new TestPayingMember(15, true, false);

    double result = mfc.calculateMembershipFee(payingMember);

    assertEquals((double)35, result);
  }

  public void testOAPPerAnnumNTFMember() {
    MembershipFeeCalculator mfc = new RegularMembershipFeeCalculator();
      
    PayingMember payingMember = new TestPayingMember(65, false, true);

    double result = mfc.calculateMembershipFee(payingMember);

    assertEquals((double)126 * 0.75, result);
  }

  public void testOAPPerTrimesterNTFMember() {
    MembershipFeeCalculator mfc = new RegularMembershipFeeCalculator();
      
    PayingMember payingMember = new TestPayingMember(65, true, true);

    double result = mfc.calculateMembershipFee(payingMember);

    assertEquals((double)35 * 0.75, result);
  }

  public void testOAPPerAnnumNoNTFMember() {
    MembershipFeeCalculator mfc = new RegularMembershipFeeCalculator();
      
    PayingMember payingMember = new TestPayingMember(65, false, false);

    double result = mfc.calculateMembershipFee(payingMember);

    assertEquals((double)126, result);
  }

  public void testOAPPerTrimesterNoNTFMember() {
    MembershipFeeCalculator mfc = new RegularMembershipFeeCalculator();
      
    PayingMember payingMember = new TestPayingMember(65, true, false);

    double result = mfc.calculateMembershipFee(payingMember);

    assertEquals((double)35, result);
  }

  private class TestPayingMember implements PayingMember {
    private int age;
    private boolean paymentPerTrimester;
    private boolean memberOfNationalTennisFederation;

    private TestPayingMember(
            int age, 
            boolean paymentPerTrimester,
            boolean memberOfNationalTennisFederation) {
      this.age = age;
      this.paymentPerTrimester = paymentPerTrimester;
      this.memberOfNationalTennisFederation = memberOfNationalTennisFederation;
    }

    public int getAge() {
      return age;
    }

    public boolean isPaymentPerTrimester() {
      return paymentPerTrimester;
    }

    public boolean isMemberOfNationalTennisFederation() {
      return memberOfNationalTennisFederation;
    }
  }
}
