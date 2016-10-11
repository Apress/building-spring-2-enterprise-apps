<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="dt" uri="http://displaytag.sf.net" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>List Members - Paginated</title>
  </head>

  <body>
    <h1>List Members - Paginated</h1>

    <dt:table name="memberList" id="member" sort="external" defaultsort="1"
              requestURI="/app/paginatedallmembers">
      <dt:column title="First Name" sortable="true" sortName="name_first">
        ${member.name.first}
      </dt:column>
      <dt:column title="Last Name" sortable="true" sortName="name_last">
        ${member.name.last}
      </dt:column>
    </dt:table>

  </body>
</html>
