package com.apress.springbook.chapter03;

public class TournamentMatchManagerDecorator implements TournamentMatchManager {
    private MatchDao matchDao;

    public void setMatchDao(MatchDao matchDao) {
        this.matchDao = matchDao;
    }

  private TournamentMatchManager target;

  public void setTournamentMatchManager(TournamentMatchManager target) {
    this.target = target;
  }

  public void endMatch(Match match) throws
       UnknownMatchException, MatchIsFinishedException,
       MatchCannotBePlayedException, PreviousMatchesNotFinishedException {
    this.target.endMatch(match);
  }

    protected void verifyMatchExists(long matchId) throws
            UnknownMatchException {
        if (!this.matchDao.doesMatchExist(matchId)) {
            throw new UnknownMatchException();
        }
    }

    protected void verifyMatchIsNotFinished(long matchId) throws
            MatchIsFinishedException {
        if (this.matchDao.isMatchFinished(matchId)) {
            throw new MatchIsFinishedException();
        }
    }

  /* other methods omitted */

    public Match startMatch(long matchId) throws
            UnknownMatchException, MatchIsFinishedException,
            PreviousMatchesNotFinishedException, MatchCannotBePlayedException {
        verifyMatchExists(matchId);
        verifyMatchIsNotFinished(matchId);
        Players players = null;
        if (doesMatchDependOnPreviousMatches(matchId)) {
            players = findWinnersFromPreviousMatchesElseHandle(matchId);
        } else {
            players = findPlayersForMatch(matchId);
        }
        return new Match(players.getPlayer1(), players.getPlayer2());
    }


    protected boolean doesMatchDependOnPreviousMatches(long matchId) {
        return matchDao.isMatchDependantOnPreviousMatches(matchId);
    }

    protected Players findWinnersFromPreviousMatchesElseHandle(long matchId) throws MatchCannotBePlayedException, PreviousMatchesNotFinishedException {
        verifyIfPreviousMatchesAreFinished(matchId);
        Player player1 = findWinnerFromFirstPreviousMatch(matchId);
        Player player2 = findWinnerFromSecondPreviousMatch(matchId);

        if (player1 != null && player2 == null) {
            cancelMatchThisPlayerWins(matchId, player1, "Previous match was not played.");
            throw new MatchCannotBePlayedException();
        } else if (player1 == null && player2 != null) {
            cancelMatchThisPlayerWins(matchId, player2, "Previous match was not played.");
            throw new MatchCannotBePlayedException();
        } else if (player1 == null && player2 == null) {
            cancelMatchNoWinner(matchId, "Both previous matches were not played.");
            throw new MatchCannotBePlayedException();
        }

        return new Players(player1, player2);
    }

    protected Players findPlayersForMatch(long matchId) {
        Player player1 = findFirstPlayerForMatch(matchId);
        Player player2 = findSecondPlayerForMatch(matchId);

        return new Players(player1, player2);
    }

    protected void verifyIfPreviousMatchesAreFinished(long matchId) throws PreviousMatchesNotFinishedException {
        if (!matchDao.arePreviousMatchesFinished(matchId)) {
            throw new PreviousMatchesNotFinishedException();
        }
    }

    protected Player findWinnerFromFirstPreviousMatch(long matchId) {
        return matchDao.findWinnerFromFirstPreviousMatch(matchId);
    }

    protected Player findWinnerFromSecondPreviousMatch(long matchId) {
        return matchDao.findWinnerFromSecondPreviousMatch(matchId);
    }

    protected void cancelMatchThisPlayerWins(long matchId, Player player, String comment) {
        matchDao.cancelMatchWithWinner(matchId, player, comment);
    }

    protected void cancelMatchNoWinner(long matchId, String comment) {
        matchDao.cancelMatchNoWinner(matchId, comment);
    }

    protected Player findFirstPlayerForMatch(long matchId) {
        return matchDao.findFirstPlayerForMatch(matchId);
    }

    protected Player findSecondPlayerForMatch(long matchId) {
        return matchDao.findSecondPlayerForMatch(matchId);
    }
}
