<%-- 
    Document   : transaction
    Created on : Apr 10, 2019, 12:18:41 PM
    Author     : Jason
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="TOBA.ui.User"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TOBA::Add Funds</title>
    </head>
    <body>
        <jsp:include page="${request.contextPath}/header.jsp"></jsp:include> 
            <div id="wrapper">
            <c:if test="${sessionScope.user != null}">
                <div id='form-container'>
                    <form id="sign-up" class="form-style" method="post" action="AddFundsServlet">
                        <h1>Account Balance: $${sessionScope.account.getFormattedBalance()}</h1>
                        <label for="addFunds">Enter Amount:</label>
                        <input input type="number" step="0.01" id="addFunds" name="addFunds" placeholder="5.00">

                        <p id="err">${message}</p>                    
                        <div>
                            <input id="sign-up-form-btn-submit" class="btn-style" type="submit" value="Submit">
                        </div>      
                    </form>
                </div>
            </c:if>
            <c:if test="${sessionScope.user == null}">
                <h1>Not Logged In.</h1>
            </c:if>
        </div>
        <jsp:include page="${request.contextPath}/footer.jsp"></jsp:include>
    </body>
</html>
