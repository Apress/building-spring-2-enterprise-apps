package com.apress.springbook.chapter06;

import java.util.List;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.dao.DataAccessException;

import org.springframework.util.FileCopyUtils;

import org.springframework.jdbc.support.nativejdbc.SimpleNativeJdbcExtractor;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

//import org.apache.commons.dbcp.BasicDataSource;

public class MemberDaoImpl extends JdbcDaoSupport implements MemberDao {

private LastNameAndAgeQuery lastNameAndAgeQuery;
private UpdateAgeQuery updateAgeQuery;
private AddMemberQuery addMemberQuery;

private LobHandler lobHandler = new DefaultLobHandler();

protected void initDao() throws Exception {
  super.initDao();

  lastNameAndAgeQuery = new LastNameAndAgeQuery (getDataSource());
  updateAgeQuery = new UpdateAgeQuery (getDataSource());
  addMemberQuery = new AddMemberQuery (getDataSource());

CallAggregateMembers procedure = new CallAggregateMembers(getDataSource());
int numberOfAffectedRecords = procedure.aggregate(1, 2);

getJdbcTemplate().setNativeJdbcExtractor(new SimpleNativeJdbcExtractor());

}


  public int getTotalNumberOfMembers() {
    return getJdbcTemplate().queryForInt("SELECT COUNT(0) FROM members");
  }

  public List<Member> loadAll() {
    return (List<Member>) 
      getJdbcTemplate().query("SELECT * FROM member", new MemberRowMapper());
  }

    /*
public Member load(Integer id) {
  return (Member)getJdbcTemplate().queryForObject(
    "SELECT * FROM member WHERE id = ?",
    new Object[] { id },
    new RowMapper() {
      public Object mapRow(ResultSet resultSet, int row) throws SQLException {
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
  );
}
    */

    
public Member load(Integer id) {
  return new SimpleJdbcTemplate(getDataSource()).queryForObject(
    "SELECT * FROM member WHERE id = ?",
    new ParameterizedRowMapper<Member>() {
      public Member mapRow(ResultSet resultSet, int row)
          throws SQLException {
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
    }, id);
}
    

public int getTotalNumberOfMembers(Integer startAge, Integer endAge, String firstName) {
  return new SimpleJdbcTemplate(getDataSource()).queryForInt(
    "SELECT count(0) FROM member " +
    "WHERE age > ? AND age < ? AND first_name = ?",
    startAge, endAge, firstName);
}


public void add(Member member) {
  addMemberQuery.update(new Object[] {
    member.getName().getFirst(),
    member.getName().getMiddle(),
    member.getName().getLast(),
    member.getAddress().getLine1(),
    member.getAddress().getLine2(),
    member.getAddress().getCity(),
    member.getAddress().getState(),
    member.getAddress().getZip(),
    member.getAge(),
  });
}


    /*
public void add(Member member) {
  getJdbcTemplate().update(
    "INSERT INTO member (name_first, name_middle, name_last, address_line1, " +
    "address_line2, address_city, address_state, address_zip, age) " +
    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
    new Object[] {
      member.getName().getFirst(),
      member.getName().getMiddle(),
      member.getName().getLast(),
      member.getAddress().getLine1(),
      member.getAddress().getLine2(),
      member.getAddress().getCity(),
      member.getAddress().getState(),
      member.getAddress().getZip(),
      member.getAge()
    }
  );
}
    */
    /*
public void updateAge(Integer memberId, Integer age) {
  getJdbcTemplate().update(
    "UPDATE member SET age = ? WHERE id = ?",
    new Object[] { age, memberId }
  );
}
    */

public void updateAge(Integer memberId, Integer age) {
  updateAgeQuery.update(new Object[] { age, memberId });
}

public void delete(Member member) {
  getJdbcTemplate().update(
    "DELETE FROM member WHERE id = ?",
    new Object[] { member.getId() }
  );
}


public long getTotalAge() {
  return getJdbcTemplate().queryForLong("SELECT SUM(age) FROM member");
}

public long getAverageAge() {
  return getJdbcTemplate().queryForLong("SELECT AVG(age) FROM member");
}

public long getOldestAge() {
  return getJdbcTemplate().queryForLong("SELECT MAX(age) FROM member");
}

public long getYoungestAge() {
  return getJdbcTemplate().queryForLong("SELECT MIN(age) FROM member");
}

    /*
public List getMembersForLastNameAndAge(final String lastName, final Integer age) {
  return getJdbcTemplate().query(
    "SELECT * FROM member WHERE name_last = ? AND age = ?",
    new PreparedStatementSetter() {
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(0, lastName);
        ps.setInt(1, age);
      }
    },
    new RowMapper() {
      public Object mapRow(ResultSet resultSet, int i) throws SQLException {
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
  );
}
    */

public List getMembersForLastNameAndAge (String lastName, Integer age) {
  return lastNameAndAgeQuery.execute(new Object[] { lastName, age });
}

public void importMembers(final List<Member> members) {
  getJdbcTemplate().batchUpdate(
    "INSERT INTO member (name_first, name_middle, name_last, address_line1, " +
    "address_line2, address_city, address_state, address_zip, age) " +
    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
    new BatchPreparedStatementSetter() {
      public void setValues(PreparedStatement ps, int i) throws SQLException {
        Member member = members.get(i);
        ps.setString(1, member.getName().getFirst());
        ps.setString(2, member.getName().getMiddle());
        ps.setString(2, member.getName().getLast());
        ps.setInt(9, member.getAge());
      }

      public int getBatchSize() {
        return members.size();
      }
    }
  );
}

public void addImageForMember(final Integer memberId, final InputStream in)
throws IOException {
  final int imageSize = in.available();

  getJdbcTemplate().execute(
    "INSERT INTO member_image (member_id, image) VALUES (?, ?)",
    new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
      protected void setValues(PreparedStatement ps, LobCreator lobCreator)
      throws SQLException, DataAccessException {
        ps.setInt(1, memberId);
        lobCreator.setBlobAsBinaryStream(ps, 2, in, imageSize);
      }
    }
  );
}

public void getImage(Integer id, final OutputStream out) {
  getJdbcTemplate().query("SELECT image FROM member_image WHERE id = ?",
    new AbstractLobStreamingResultSetExtractor() {
      protected void streamData(ResultSet rs) throws SQLException, IOException {
        FileCopyUtils.copy(lobHandler.getBlobAsBinaryStream(rs, 1), out);
      }
    }
  );
}


}
