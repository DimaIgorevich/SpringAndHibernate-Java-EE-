<%-- 
    Document   : edit
    Created on : 27.09.2016, 22:42:20
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDIT PATIENT PAGE</title>
    </head>
    <body>
        <form:form method="post" action="edit.htm" commandName="edit">
            Ф.И.О.: <form:input path="fullName"/> - <c:out value="${fullName}"></c:out><br>
            Возраст: <form:input path="age"/> - <c:out value="${age}"></c:out><br><form:hidden path="mobile"/>
            Дата регистрации: <form:input path="dateRegistration"/> - <c:out value="${dateRegistration}"></c:out><br>
            <c:out value="${mobile}"></c:out><br>
            <input type="submit" name="action" value="Submit"> | <a href="cards.htm">BACK</a>
        </form:form>
    </body>
</html>
