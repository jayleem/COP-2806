<%-- 
    Document   : account activity
    Created on : Apr 11, 2019, 10:16:46 PM
    Author     : Jason
--%>
<%@page import="TOBA.ui.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TOBA::Account Activity</title>
    </head>
    <body>
        <jsp:include page="header.html"></jsp:include>
            <div id="wrapper">
                <div id="main-content">    
                <c:if test="${sessionScope.user != null}">
                    <h1>Welcome ${sessionScope.user.getFirstName()} ${sessionScope.user.getLastName()}</h1>
                </c:if>
                <c:if test="${sessionScope.user == null}">
                    <h1>Not Logged In.</h1>
                </c:if>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>