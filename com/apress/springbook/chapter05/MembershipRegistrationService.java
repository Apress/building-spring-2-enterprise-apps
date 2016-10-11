package com.apress.springbook.chapter05;

public class MembershipRegistrationService {
  private NewsletterSubscriptionRepositoryAdapter subscriptionRepositoryAdapter;
  private MembershipRepositoryAdapter membershipRepositoryAdapter;

  public MembershipRegistrationService(
    NewsletterSubscriptionRepositoryAdapter subscriptionRepositoryAdapter,
    MembershipRepositoryAdapter membershipRepositoryAdapter) {

    this.subscriptionRepositoryAdapter = subscriptionRepositoryAdapter;
    this.membershipRepositoryAdapter = membershipRepositoryAdapter;
  }

  public void saveMembershipRegistrationDetails(
        MembershipRegistration details, 
        String emailForNewsletter) {

    int membershipId = 
       membershipRepositoryAdapter.saveMembershipRegistration(details);

    if (emailForNewsletter != null && emailForNewsletter.length() > 0) {
       subscriptionRepositoryAdapter
          .addNewsletterSubscription(membershipId, emailForNewsletter);
    }
  }
}
