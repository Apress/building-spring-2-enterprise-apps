<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>List Members</title>
  </head>

  <body>
    <h1>List Members</h1>

    <c:if test="${empty memberList}">
      <p>No members found.</p>
    </c:if>

    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Age</th>
          <th>Address</th>
        </tr>
      </thead>

      <tbody>
        <c:forEach items="${memberList}" var="member">
          <tr>
            <td>${member.name.last}, ${member.name.first}</td>
            <td>${member.age}</td>
            <td>${member.address}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <form action="searchformembers" method="get">
      <p>
        <label for="q">First or Last Name:</label>
        <input type="text" name="q" value="${param.q}"/>
        <input type="submit" value="Search" />
      </p>
    </form>

  </body>
</html>
