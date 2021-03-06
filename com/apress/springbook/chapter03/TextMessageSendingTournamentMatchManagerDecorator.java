package com.apress.springbook.chapter03;

public class TextMessageSendingTournamentMatchManagerDecorator
   extends TournamentMatchManagerDecorator {
  private MessageSender messageSender;

  public void setMessageSender(MessageSender messageSender) {
    this.messageSender = messageSender;
  }

  public void endMatch(Match match) throws
       UnknownMatchException, MatchIsFinishedException,
       MatchCannotBePlayedException, PreviousMatchesNotFinishedException {
    super.endMatch(match);
    this.messageSender.notifyEndOfMatch(match);
  }
}
