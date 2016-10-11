package com.apress.springbook.chapter05;

public class SpringJDBCTournament {

  private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;

public void setDataSource(javax.sql.DataSource dataSource) {
  this.jdbcTemplate =
    new org.springframework.jdbc.core.JdbcTemplate(dataSource);
}

public int countTournamentRegistrations(int tournamentId) {
  return this.jdbcTemplate.queryForInt(
       "SELECT COUNT(0) FROM t_registrations WHERE " + 
       "tournament_id = ?", new Object[] { new Integer(tournamentId) }
    );
}


}
