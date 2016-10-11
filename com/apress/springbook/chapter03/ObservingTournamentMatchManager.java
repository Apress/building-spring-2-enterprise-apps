package com.apress.springbook.chapter03;

public class ObservingTournamentMatchManager extends DefaultTournamentMatchManager {
  private MatchObserver[] matchEndsObservers;

  public void setMatchEndsObservers(MatchObserver[] matchEndsObservers) {
    this.matchEndsObservers = matchEndsObservers;
  }

  public void endMatch(Match match) throws
       UnknownMatchException, MatchIsFinishedException,
       MatchCannotBePlayedException, PreviousMatchesNotFinishedException {
    super.endMatch(match);
    for (MatchObserver observer : matchEndsObservers) {
      observer.onMatchEvent(match);
    }
  }
}
