package com.apress.springbook.chapter06;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.core.SqlParameter;

public class UpdateAgeQuery extends SqlUpdate {
   private static final String SQL_QUERY =
         "UPDATE member SET age = ? WHERE id = ?";

   public UpdateAgeQuery (DataSource dataSource) {
      super(dataSource, SQL_QUERY);
      declareParameter(new SqlParameter("age", Types.INTEGER));
      declareParameter(new SqlParameter("id", Types.INTEGER));
      compile();
   }
}
