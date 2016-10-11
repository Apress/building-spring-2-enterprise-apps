package com.apress.springbook.chapter06;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper{

            public Object mapRow(ResultSet resultSet, int row) throws SQLException {
               Member member = new Member();
               member.setId(resultSet.getInt("id"));
               member.getName().setFirst(resultSet.getString("name_first"));
               member.getName().setLast(resultSet.getString("name_last"));
             
               member.setAge(resultSet.getInt("age"));
               return member;
            }

}
