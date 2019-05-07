<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesheet.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/media-queries.css">
        <!--[if IE]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>
        <header>
            <div id="nav">
                <div id="hamburger-btn" onclick="flyout()">
                    <div class="line1"></div>
                    <div class="line2"></div>
                    <div class="line3"></div>
                </div>
                <a id="title" href='${pageContext.request.contextPath}/index.jsp' target='_self'>TOBA</a>
                <ul>
                    <li><a href='login.jsp' target='_self'>Login</a></li>
                    <li><p>|</p></li>
                </ul>
            </div>            
            <div id="hidden-menu">
                <div id="nav-col">
                    <ul>
                        <li><a href='${pageContext.request.contextPath}/index.jsp' target='_self'>Home</a></li>
                        <li><a href='${pageContext.request.contextPath}/new-customer.jsp' target='_self'>Enroll</a></li>
                        <li><a href='${pageContext.request.contextPath}/add-funds.jsp' target='_self'>Add Funds</a></li>
                        <li><a href='${pageContext.request.contextPath}/account-activity.jsp' target='_self'>Account Activity</a></li>                    
                        <li><a href='${pageContext.request.contextPath}/admin/' target='_self'>Admin Login</a></li>
                    </ul>
                </div>
            </div>            
        </header>
        <script src="${pageContext.request.contextPath}/js/flyout.js"></script>        
    </body>
</html>
