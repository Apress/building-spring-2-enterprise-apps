package com.apress.springbook.chapter03;

public interface MatchDao {
    boolean doesMatchExist(long matchId);

    boolean isMatchFinished(long matchId);

    boolean isMatchDependantOnPreviousMatches(long matchId);

    boolean arePreviousMatchesFinished(long matchId);

    Player findWinnerFromFirstPreviousMatch(long matchId);

    Player findWinnerFromSecondPreviousMatch(long matchId);

    void cancelMatchWithWinner(long matchId, Player player, String comment);

    void cancelMatchNoWinner(long matchId, String comment);

    Player findFirstPlayerForMatch(long matchId);

    Player findSecondPlayerForMatch(long matchId);
}
