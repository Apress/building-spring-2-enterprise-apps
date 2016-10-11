package com.apress.springbook.chapter01;

public interface TournamentMatchManager {
  Match startMatch(long matchId) throws
    UnknownMatchException,
    MatchIsFinishedException,
    PreviousMatchesNotFinishedException,
    MatchCannotBePlayedException;
}

/*
package com.apress.springbook.chapter01;

public interface TournamentMatchManager {
   Match startMatch(long matchId) throws
         UnknownMatchException,
         MatchIsFinishedException,
         PreviousMatchesNotFinishedException,
         MatchCannotBePlayedException;
}
*/
