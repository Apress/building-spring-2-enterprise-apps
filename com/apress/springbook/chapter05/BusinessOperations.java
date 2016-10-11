package com.apress.springbook.chapter05;

public class BusinessOperations {

    //private NewsletterSubscriptionDataAccess subscriptionDataAccess;
private NewsletterSubscriptionDataAccess subscriptionDataAccess;

public void subscribeMemberToNewsletter(Member member, String email) throws MyDataAccessException {
  subscriptionDataAccess.addNewsletterSubscription(member.getId(), email);
}


private MembershipDataAccess membershipDataAccess;

public void saveMembershipRegistrationDetails(
    MembershipRegistration details, 
    String emailForNewsletter) throws MyDataAccessException {

  int membershipId = 
     membershipDataAccess.saveMembershipRegistration(details);

  if (emailForNewsletter != null && emailForNewsletter.length() > 0) {
    subscriptionDataAccess
       .addNewsletterSubscription(membershipId, emailForNewsletter);
  }
}


}
