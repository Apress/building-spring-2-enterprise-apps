<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Register a New Member</title>
  </head>

  <body>
    <h1>Register a New Member</h1>

    <form:form commandName="member">
      <form:errors path="*"/>

      <table>
        <tbody>
          <tr>
            <td class="form-label"><label for="sex">Sex:</label></td>
            <td class="form-field">
              <form:select path="sex">
                <form:option value="FEMALE" />
                <form:option value="MALE" />
              </form:select>
            </td>
          </tr>
          <spring:nestedPath path="name">
            <tr>
              <td class="form-label">
                <form:label for="first">First Name:</label>
              </td>
              <td class="form-field"><form:input path="first"/></td>
            </tr>
            <tr>
              <td class="form-label">
                <form:label for="last">Last Name:</label>
              </td>
              <td class="form-field"><form:input path="last"/></td>
            </tr>
          </spring:nestedPath>
          <tr>
            <td class="form-label"><form:label for="age">Age:</label></td>
            <td class="form-field"><form:input path="age"/></td>
          </tr>
          <spring:nestedPath path="address">
            <tr>
              <td class="form-label"><form:label for="line1">Line 1</label></td>
              <td class="form-field"><form:input path="line1" /></td>
            </tr>
            <tr>
              <td class="form-label"><form:label for="line2">Line 2</label></td>
              <td class="form-field"><form:input path="line2" /></td>
            </tr>
            <tr>
              <td class="form-label"><form:label for="city">City</label></td>
              <td class="form-field"><form:input path="city" /></td>
            </tr>
            <tr>
              <td class="form-label"><form:label for="state">State</label></td>
              <td class="form-field"><form:input path="state" /></td>
            </tr>
            <tr>
              <td class="form-label"><form:label for="zip">Zip</label></td>
              <td class="form-field"><form:input path="zip" /></td>
            </tr>
          </spring:nestedPath>
          <tr>
            <td style="vertical-align:top"><label>Phone Number(s):</label></td>
            <td>
              <c:forEach items="${member.phoneNumbers}" 
                         var="phoneNumber" 
                         varStatus="loop">
                <div id="phone-number-fields">
                  <form:input path="phoneNumbers[${loop.index}].areaCode" />
                  <form:input path="phoneNumbers[${loop.index}].number" />
                  <form:select path="phoneNumbers[${loop.index}].type"
                               items="${phoneNumberTypes}" />
                  <input type="submit" name="action_removePhoneNumber_${loop.index}" 
                         value="Remove Phone Number" />
                </div>
              </c:forEach>

              <input type="submit" name="action_addPhoneNumber" 
                     value="Add Phone Number" />
            </td>
          </tr>

          <tr>
            <td />
            <td><input type="submit" value="Register" /></td>
          </tr>
        </tbody>
      </table>
    </form:form>
  </body>
</html>
