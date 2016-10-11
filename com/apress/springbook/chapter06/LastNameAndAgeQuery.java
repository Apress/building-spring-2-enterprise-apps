package com.apress.springbook.chapter06;

import java.sql.ResultSet;
import java.sql.Types;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.core.SqlParameter;

public class LastNameAndAgeQuery extends MappingSqlQuery {
  private static final String SQL_QUERY =
    "SELECT * FROM member WHERE name_last = ? AND age = ?";

  public LastNameAndAgeQuery (DataSource ds) {
    super(ds, SQL_QUERY);
    declareParameter(new SqlParameter("name_last", Types.VARCHAR));
    declareParameter(new SqlParameter("age", Types.INTEGER));
    compile();
  }

  protected Object mapRow(ResultSet resultSet, int row) throws SQLException {
    Member member = new Member();
    member.setId(resultSet.getInt("id"));
    member.getName().setFirst(resultSet.getString("name_first"));
    member.getName().setMiddle(resultSet.getString("name_middle"));
    member.getName().setLast(resultSet.getString("name_last"));
    member.getAddress().setLine1(resultSet.getString("address_line1"));
    member.getAddress().setLine2(resultSet.getString("address_line2"));
    member.getAddress().setCity(resultSet.getString("address_city"));
    member.getAddress().setState(resultSet.getString("address_state"));
    member.getAddress().setZip(resultSet.getString("address_zip")); 
    member.setAge(resultSet.getInt("age"));
    return member;
  }
}
