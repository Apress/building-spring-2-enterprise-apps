package com.apress.springbook.chapter02;

public interface TournamentMatchManager {
   Match startMatch(long matchId) throws
         UnknownMatchException,
         MatchIsFinishedException,
         PreviousMatchesNotFinishedException,
         MatchCannotBePlayedException;
}
