<%-- 
    Document   : password reset
    Created on : Apr 11, 2019, 10:16:46 PM
    Author     : Jason
--%>
<%@page import="TOBA.ui.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TOBA::Reset Password</title>
    </head>
    <body>
        <jsp:include page="header.html"></jsp:include>
            <div id="wrapper">
                <div id="main-content">    
                    <div id='form-container'>
                        <form id="reset-password" class="form-style" method="post" action="PasswordResetServlet">
                            <label for="password">New password:</label>
                            <input type="password" id="password" name="password" placeholder="" value="${sessionScope.user.password}">                                  
                        <p id="err">${message}</p> 
                        <div>
                            <input id="sign-up-form-btn-submit" class="btn-style" type="submit" value="Submit">
                        </div>      
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>