<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <spring:url value="/resources/styles.css" var="coreCss"/>
        <link href="${coreCss}" rel="stylesheet" type="text/css"/>
        <title>MEDICAL DATA CENTRE</title>
    </head>
    <body>
        <div id="container">
            <div id="block-up">
                <nav class = "navigation-top-bar">
                    <div class = "container">
                        <div class = "navbar-header">
                            <a class = "navbar-brand" href = "#">Medical Data Centre</a>
                        </div>
                    </div>
                </nav>
                <div class = "jumbotron">
                    <div class = "container">
                        <img class = "main-logo" src = "resources/main-logo.png" alt = "Logo"/>
                        <div class = "title-container">
                            MEDICAL DATA CENTRE
                        </div>
                        <a class = "btn-primary-lg" href = "cards.htm" role = "button">Get Start</a>
                    </div>
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
