package com.apress.springbook.chapter05;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewsletterSubscriptionDataAccess {

  private DataSource dataSource;

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void addNewsletterSubscription(int memberId, String emailAddress) 
    throws MyDataAccessException {

    Connection conn = null;
    PreparedStatement statement = null;
    try {
      conn = dataSource.getConnection();
      statement = conn.prepareStatement(
          "INSERT INTO t_newsletter_subscriptions (" +
          "(subscription_id, member_id, email_address) " +
          " VALUES (" + 
          "newsletter_subscription_seq.nextVal(), ?, ?)"
          );
      statement.setInt(1, memberId);
      statement.setString(2, emailAddress);
      statement.executeUpdate();
    } catch (SQLException e) {
      throw new MyDataAccessException(e);
    } finally {
      if (statement != null) {
        try {
          statement.close();
        } catch (java.sql.SQLException e) {
          // exception must be caught, can't do anything with it.
          e.printStackTrace();
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (java.sql.SQLException e) {
          // exception must be caught, can't do anything with it.
          e.printStackTrace();
        }
      }
    }
  }
}
