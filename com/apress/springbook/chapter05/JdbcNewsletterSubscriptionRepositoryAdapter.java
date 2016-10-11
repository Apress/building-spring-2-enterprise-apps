package com.apress.springbook.chapter05;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcNewsletterSubscriptionRepositoryAdapter 
  extends JdbcDaoSupport 
  implements NewsletterSubscriptionRepositoryAdapter {

  public void addNewsletterSubscription(int memberId, String emailAdress) {
    getJdbcTemplate().update(
       "INSERT INTO t_newsletter_subscriptions (" +
       "(subscription_id, member_id, email_address) " +
       " VALUES (" +
       "newsletter_subscription_seq.nextVal(), ?, ?",
       new Object[] { new Integer(memberId), emailAdress }
    );
  }
}
