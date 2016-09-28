<%-- 
    Document   : cards
    Created on : 17.09.2016, 14:36:51
    Author     : admin
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <spring:url value="/resources/styles.css" var="coreCss"/>
        <link href="${coreCss}" rel="stylesheet" type="text/css"/>
        <title>MEDICAL DATA PATIENTS</title>
    </head>
    <body>
        <div id="container">
            <div id="block-up">
                <nav class = "navigation-top-bar">
                    <div class = "container">
                        <div class = "navbar-header">
                            <a class = "navbar-brand" href = "#">Medical Data Centre</a>
                        </div>
                        <a class = "btn-back-lg" href = "index.htm" role = "button">Back</a>
                    </div>
                </nav>
                <div class = "jumbotron">
                    <div class = "container">
                        <img class = "main-logo" src = "resources/main-logo.png" alt = "Logo"/>
                        <div class = "title-container">
                            MEDICAL DATA CENTRE
                        </div>
                        <div class = "subtitle">
                            PATIENTS DATA
                        </div>
                        
                        <a href="cards.htm" class="btn-reset"></a>
                        <form:form method="post" action="cards.htm" commandName="card">
                            <form:input path="fullName" class="input-text" placeholder="Search.."/>
                            <input class="input-submit-search" type="submit" tabindex="-1" name="action" value="search"/>
                        </form:form>
                            <a class="show-btn" href="javascript:void(0)" onclick = "document.getElementById('envelope').style.display='block';document.getElementById('fade').style.display='block'">
                                <img class="add" src = "resources/add.png" alt="add patient">
                            </a>
                            <div id="envelope" class="envelope">
                                <a class="close-btn" href="javascript:void(0)" onclick = "document.getElementById('envelope').style.display='none';document.getElementById('fade').style.display='none'">Закрыть</a>
                                <h1 class="title">Add new patients</h1>
                                <form:form method="post" action="cards.htm" commandName="card">
                                    Ф.И.О.: <form:input path="fullName"/><br>
                                    Телефон(мобильный): <form:input path="mobile"/><br>
                                    Возраст: <form:input path="age"/><br>
                                    <input type="submit" name="action" value="Add" class="send-message">
                                </form:form>
                            </div>
                            <div id="fade" class="black-overlay"></div>
                    </div>
                </div>
            </div>
            <div id="block-middle">
                <div class="div-data-container">
                    <table>
                        <th>Ф. И. О.</th>
                        <th>Возраст</th>
                        <th>Телефон(мобильный)</th>
                        <th>Дата регистрации</th>
                        <th>Управление</th>
                        <c:forEach items="${cardList}" var="card">
                            <c:url var="deleteUrl" value="delete.htm?mobile=${card.mobile}"/>
                            <c:url var="editUrl" value="edit.htm?mobile=${card.mobile}"/>
                            <tr>
                                <td><c:out value="${card.fullName}"></c:out></td>
                                <td><c:out value="${card.age}"></c:out></td>
                                <td><c:out value="${card.mobile}"></c:out></td>
                                <td><c:out value="${card.dateRegistration}"></c:out></td>
                                <td><a href="${deleteUrl}">Remove</a> | <a href="${editUrl}">Edit</a></td>
                            </tr>
                        </c:forEach>   
                    </table>   
                </div>
            </div>
            <div id="block-footer">
                <div class = "footer-div">
                    <div class = "container">
                        <img class = "footer-logo" src = "resources/preview.jpg" alt = "Footer-logo">
                    </div>
                </div>
                <div class = "footer-info">
                    <div class = "container">
                        <hr class = "hr-line">
                        <span class = "info-span">@RumyankovDima.(c)2016</span>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
