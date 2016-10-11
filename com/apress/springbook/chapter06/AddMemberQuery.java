package com.apress.springbook.chapter06;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.core.SqlParameter;

public class AddMemberQuery extends SqlUpdate {
  private static final String SQL_QUERY =
    "INSERT INTO member (name_first, name_middle, name_last, address_line1, " +
    "address_line2, address_city, address_state, address_zip, age) " + 
    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

  public AddMemberQuery (DataSource dataSource) {
    super(dataSource, SQL_QUERY);
    declareParameter(new SqlParameter("name_first", Types.VARCHAR));
    declareParameter(new SqlParameter("name_middle", Types.VARCHAR));
    declareParameter(new SqlParameter("name_last", Types.VARCHAR));
    declareParameter(new SqlParameter("address_line1", Types.VARCHAR));    
    declareParameter(new SqlParameter("address_line2", Types.VARCHAR));    
    declareParameter(new SqlParameter("address_city", Types.VARCHAR));    
    declareParameter(new SqlParameter("address_state", Types.VARCHAR));    
    declareParameter(new SqlParameter("address_zip", Types.VARCHAR));    
    declareParameter(new SqlParameter("age", Types.INTEGER));
    compile();
  }
}
