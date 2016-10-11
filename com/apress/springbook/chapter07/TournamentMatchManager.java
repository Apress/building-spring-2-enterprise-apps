/*
package com.apress.springbook.chapter07;

import org.springframework.transaction.annotation.Transactional;

//@Transactional
public interface TournamentMatchManager {
  @Transactional
  public void endMatch(Match match) throws 
        UnknownMatchException, MatchIsFinishedException, 
        MatchCannotBePlayedException, PreviousMatchesNotFinishedException;

  // other methods ommitted
}
*/

/*
package com.apress.springbook.chapter07;

import org.springframework.transaction.annotation.Transactional;

@Transactional(
  rollbackFor = { 
        UnknownMatchException.class,
        MatchIsFinishedException.class,
        MatchCannotBePlayedException.class,
        PreviousMatchesNotFinishedException.class
  }
)

public interface TournamentMatchManager {
  public void endMatch(Match match) throws 
        UnknownMatchException, MatchIsFinishedException, 
        MatchCannotBePlayedException, PreviousMatchesNotFinishedException;

  // other methods ommitted
}
*/
package com.apress.springbook.chapter07;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

@Transactional(
  rollbackFor = { 
        UnknownMatchException.class,
        MatchIsFinishedException.class,
        MatchCannotBePlayedException.class,
        PreviousMatchesNotFinishedException.class
  },
  propagation = Propagation.REQUIRED
)

public interface TournamentMatchManager {
  public void endMatch(Match match) throws 
        UnknownMatchException, MatchIsFinishedException, 
        MatchCannotBePlayedException, PreviousMatchesNotFinishedException;

  // other methods ommitted
}

