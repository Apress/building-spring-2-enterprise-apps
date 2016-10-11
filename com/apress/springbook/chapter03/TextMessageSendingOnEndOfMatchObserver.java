package com.apress.springbook.chapter03;

public class TextMessageSendingOnEndOfMatchObserver implements MatchObserver {
  private MessageSender messageSender;

  public void setMessageSender(MessageSender messageSender) {
    this.messageSender = messageSender;
  }

  public void onMatchEvent(Match match) {
    this.messageSender.notifyEndOfMatch(match);
  }
}
