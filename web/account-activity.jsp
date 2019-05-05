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

                    <div id="ud-container">
                        <div id="ud-header">
                            <h1 class="header-style-big-bold">User Details - ${user.getFirstName()} ${user.getLastName()}</h1>
                        </div>
                        <table id="tb-ud">
                            <tr>
                                <td>Username: </td>
                                <td>${user.getUserName()}</td>
                            </tr>
                            <tr>
                                <td>Password:</td>
                                <td>${user.getPassword()}</td>
                            </tr>
                            <tr>
                                <td>First name:</td>
                                <td>${user.getFirstName()}</td>
                            </tr>
                            <tr>
                                <td>Last name:</td>
                                <td>${user.getLastName()}</td>
                            </tr>
                            <tr>
                                <td>Phone:</td>
                                <td>${user.getPhone()}</td>
                            </tr>
                            <tr>
                                <td>Address:</td>
                                <td>${user.getAddress()}</td>
                            </tr>
                            <tr>
                                <td>City:</td>
                                <td>${user.getCity()}</td>
                            </tr>
                            <tr>
                                <td>State:</td>
                                <td>${user.getState()}</td>
                            </tr>
                            <tr>
                                <td>Zip-code:</td>
                                <td>${user.getZipcode()}</td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td>${user.getEmail()}</td>
                            </tr>
                        </table>
                    </div>
                    <div id="ud-container">
                        <div id="ud-header">
                            <h1 class="header-style-big-bold">Your Transaction History:</h1>
                        </div>
                        <table id="tb-th">
                            <tr>
                                <th>Transaction Type</th>
                                <th>Amount</th>
                            </tr>
                            <c:forEach var="item" items="${account.getList()}">
                                <tr>
                                    <td>${item.transType}</td>
                                    <td>$${item.getFormattedBalance()}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </c:if>   

                <c:if test="${sessionScope.user == null}">
                    <h1>Not Logged In.</h1>
                </c:if>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>