package com.apress.springbook.chapter01.test;

import com.apress.springbook.chapter01.TournamentMatchManager;
import com.apress.springbook.chapter01.Match;
import com.apress.springbook.chapter01.Player;
import com.apress.springbook.chapter01.UnknownMatchException;
import com.apress.springbook.chapter01.MatchIsFinishedException;
import com.apress.springbook.chapter01.PreviousMatchesNotFinishedException;
import com.apress.springbook.chapter01.MatchCannotBePlayedException;

public class StubTournamentMatchManager implements TournamentMatchManager {
  public Match startMatch(long matchId) throws
      UnknownMatchException, MatchIsFinishedException,
      PreviousMatchesNotFinishedException, MatchCannotBePlayedException {
    Player player1 = Player.femalePlayer ();
    player1.setName("Kim Clijsters");

    Player player2 = Player.femalePlayer();
    player2.setName("Justine Henin-Hardenne");

    return new Match(player1, player2);
  }
}
