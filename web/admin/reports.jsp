<%-- 
    Document   : reports
    Created on : May 4, 2019, 1:42:59 PM
    Author     : Jason
--%>

<%@page import="TOBA.ui.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TOBA::Admin reports</title>
    </head>
    <body>
        <jsp:include page="header.html"></jsp:include>
            <div id="wrapper">
                <div id="main-content"> 
                    <h2>View report of registered users.</h2><br>
                    <form action="ReportsServlet" method="POST">
                        <input type="submit" value="View Report" class="button" name="action" /><br>
                        <input type="submit" value="Hide Report" class="button" name="action" /><br>
                        <input type="submit" value="Export Report" class="button" name="action" /><br>
                    </form>
                <c:if test="${userList != null}">  
                    <br>
                    <div id="ur-container">
                        <table id="tb-ur">
                            <tr>
                                <th>ID</th>
                                <th>Username</th>
                                <th>Date Registered</th>
                            </tr>
                            <c:forEach var="user" items="${userList}">
                                <tr>
                                    <td><c:out value="${user.userId}" /></td>
                                    <td><c:out value="${user.userName}" /></td>
                                    <td><c:out value="${user.dateRegistered}" /></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </c:if>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
