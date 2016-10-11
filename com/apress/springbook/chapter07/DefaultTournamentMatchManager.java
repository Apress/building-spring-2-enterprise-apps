package com.apress.springbook.chapter07;

import org.springframework.transaction.annotation.Transactional;

public class DefaultTournamentMatchManager
     implements TournamentMatchManager {
  @Transactional
  public void endMatch(Match match) throws 
        UnknownMatchException, MatchIsFinishedException, 
        MatchCannotBePlayedException, PreviousMatchesNotFinishedException {
     // implementation ommitted
  }

  // other methods ommitted
}
