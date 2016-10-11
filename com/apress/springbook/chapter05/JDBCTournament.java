package com.apress.springbook.chapter05;

import java.util.List;

public class JDBCTournament {

  private javax.sql.DataSource dataSource;

    /*
  public int countTournamentRegistrations(int tournamentId) throws MyDataAccessException {
    java.sql.Connection conn = null;
    java.sql.Statement statement = null;
    java.sql.ResultSet rs = null;
    try {
      conn = dataSource.getConnection();
      statement = conn.createStatement();
      rs = statement.executeQuery(
        "SELECT COUNT(0) FROM t_registrations WHERE " + 
        "tournament_id = " + tournamentId
         );
      rs.next();
      return rs.getInt(1);
    } catch (java.sql.SQLException e) {
      throw new MyDataAccessException(e);
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (java.sql.SQLException e) {
          // exception must be caught, can't do anything with it.
          e.printStackTrace();
        }
      }
      if (statement != null) {
        try {
          statement.close();
        } catch (java.sql.SQLException e) {
          // exception must be caught, can't do anything with it.
          e.printStackTrace();
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (java.sql.SQLException e) {
          // exception must be caught, can't do anything with it.
          e.printStackTrace();
        }
      }
    }
  }
    */

public int countTournamentRegistrations(int tournamentId) throws MyDataAccessException {
  try {
    java.sql.Connection conn = dataSource.getConnection();
    java.sql.Statement statement = conn.createStatement();
    java.sql.ResultSet rs = statement.executeQuery(
       "SELECT COUNT(0) FROM T_REGISTRATIONS WHERE " + 
       "TOURNAMENT_ID = " + tournamentId
       );
    rs.next();
    int result = rs.getInt(1);
    rs.close();
    statement.close();
    conn.close();
    return result;
  } catch (java.sql.SQLException e) {
    throw new MyDataAccessException(e);
  }
}

    /*
public List findRegisteredPlayers(int tournamentId) throws MyDataAccessException {
  java.sql.Connection conn = null;
  try {
    conn = dataSource.getConnection();
    java.sql.Statement statement = conn.createStatement();
    java.util.List results = new java.util.ArrayList();
    java.sql.ResultSet rs = statement.executeQuery(
       "SELECT p.player_id, p.first_name, p.last_name " + 
       "FROM t_registrations r, t_players p WHERE " +
       "r.player_id = p.player_id AND" + 
       "r.tournament_id = " + tournamentId
       );
    while (rs.next()) {
      int playerId = rs.getInt(1);
      String firstName = rs.getString(2);
      String lastName = rs.getString(3);
      Player player = new Player(playerId, firstName, lastName);
      results.add(player); 
    }
    return results;
 } catch (java.sql.SQLException e) {
    throw new MyDataAccessException(e);
 } finally {
    if (conn != null) {
      try {
        conn.close();
      } catch (java.sql.SQLException e) {
        // exception must be caught, can't do anything with it.
        e.printStackTrace();
      }
    }
  }
}
    */

public List findRegisteredPlayers(int tournamentId) throws MyDataAccessException {
  java.sql.Connection conn = null;
  try {
    conn = dataSource.getConnection();
    java.sql.PreparedStatement statement = conn.prepareStatement(
       "SELECT p.player_id, p.first_name, p.last_name " + 
       "FROM t_registrations r, t_players p WHERE " +
       "r.player_id = p.player_id AND" + 
       "r.tournament_id = ?"
       );
    statement.setInt(1, tournamentId);
    java.sql.ResultSet rs = statement.executeQuery();
    java.util.List results = new java.util.ArrayList();      
    while (rs.next()) {
      int playerId = rs.getInt(1);
      String firstName = rs.getString(2);
      String lastName = rs.getString(3);
      Player player = new Player(playerId, firstName, lastName);
      results.add(player); 
    }
    return results;
  } catch (java.sql.SQLException e) {
    throw new MyDataAccessException(e);
  } finally {
    if (conn != null) {
      try {
        conn.close();
      } catch (java.sql.SQLException e) {
        // exception must be caught, can't do anything with it.
        e.printStackTrace();
      }
    }
  }
}

}
