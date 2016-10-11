package com.apress.springbook.chapter10;

public class RegularMembershipFeeCalculator implements MembershipFeeCalculator {
  public double calculateMembershipFee (PayingMember member) {
      double fee = 0;

      int age = member.getAge();

    // Member is under 14
      if (age < 14) {
	  if (member.isPaymentPerTrimester()) {
	      fee = 25;
	  } else {
	  fee = 90;
	  }
      }

    // Member is a between 14 and 18, or is over 50
      if ((age >= 14 && age < 18) || age > 50) {
	  if (member.isPaymentPerTrimester()) {
	      fee = 35;
	  } else {
	      fee = 126;
	  }
      }

    // Member is between 18 and 50
      if (age >= 18 && age <= 50) {
	  if (member.isPaymentPerTrimester()) {
	      fee = 50;
	  } else {
	  fee = 180;
	  }
      }

    // Reduce the fee if they are a member of the national federation
      if (member.isMemberOfNationalTennisFederation()) {
	  fee = fee * 0.75;
      }

      return fee;
      //throw new UnsupportedOperationException("not implemented yet!");
  }
}
