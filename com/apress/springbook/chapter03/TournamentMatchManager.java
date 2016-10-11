package com.apress.springbook.chapter03;

public interface TournamentMatchManager {
   Match startMatch(long matchId) throws
         UnknownMatchException,
         MatchIsFinishedException,
         PreviousMatchesNotFinishedException,
         MatchCannotBePlayedException;

   void endMatch(Match match) throws
         UnknownMatchException,
         MatchIsFinishedException,
         PreviousMatchesNotFinishedException,
         MatchCannotBePlayedException;
}
