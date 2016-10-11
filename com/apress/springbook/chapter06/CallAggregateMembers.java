package com.apress.springbook.chapter06;

import java.util.Map;
import java.util.HashMap;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlOutParameter;

public class CallAggregateMembers extends StoredProcedure {
  private static final String STORED_PROCEDURE_NAME = "aggregate_members";

  public CallAggregateMembers(DataSource dataSource) {
    super(dataSource, STORED_PROCEDURE_NAME);
    declareParameter(new SqlParameter("start_age", Types.INTEGER));
    declareParameter(new SqlParameter("end_age", Types.INTEGER));
    declareParameter(new SqlOutParameter("number_aggregated", Types.INTEGER));
    compile();
  }

  public int aggregate(Integer start, Integer end) {
    Map<String, Integer> inParameters = new HashMap<String,Integer>(2);
    inParameters.put("start_age", start);
    inParameters.put("end_age", end);

    Map outParameters = execute(inParameters);
    if (outParameters.size() > 0) {
      return (Integer) outParameters.get("number_aggregated");
    } else {
      return 0;
    }
  }
}
