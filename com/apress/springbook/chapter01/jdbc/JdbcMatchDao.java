package com.apress.springbook.chapter01.jdbc;

import javax.sql.DataSource;

import com.apress.springbook.chapter01.MatchDao;
import com.apress.springbook.chapter01.Player;
import com.apress.springbook.chapter01.Sex;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcMatchDao implements MatchDao {
  private JdbcTemplate jdbcTemplate;

  public void setDataSource(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public boolean doesMatchExist(long matchId) {
    return 1 == jdbcTemplate.queryForInt(
      "SELECT COUNT(0) FROM T_MATCHES WHERE MATCH_ID = ?",
      new Object[] { new Long(matchId) }
    );
  }
  /* other methods omitted for brevity */

  public boolean isMatchFinished(long matchId) { return true; };

  public boolean isMatchDependantOnPreviousMatches(long matchId) { return true; };

  public boolean arePreviousMatchesFinished(long matchId) { return true; };

  public Player findWinnerFromFirstPreviousMatch(long matchId) { return new Player(Sex.MALE); };

  public Player findWinnerFromSecondPreviousMatch(long matchId) { return new Player(Sex.FEMALE); };

  public void cancelMatchWithWinner(long matchId, Player player, String comment) {};

  public void cancelMatchNoWinner(long matchId, String comment) {};

  public Player findFirstPlayerForMatch(long matchId)  { return new Player(Sex.MALE); };

  public Player findSecondPlayerForMatch(long matchId)  { return new Player(Sex.FEMALE); };
}

/*
package com.apress.springbook.chapter01.jdbc;

import javax.sql.DataSource;

import com.apress.springbook.chapter01.MatchDao;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcMatchDao implements MatchDao {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    boolean doesMatchExist(long matchId) {
        return 1 == jdbcTemplate.queryForInt(
            "SELECT COUNT(0) FROM T_MATCHES WHERE MATCH_ID = ?",
            new Object[] { new Long(matchId) }
            );
    }
*/
    /* other methods omitted for brevity */
/*
}
*/
