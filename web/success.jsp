<%-- 
    Document   : success
    Created on : Apr 10, 2019, 12:16:46 PM
    Author     : Jason
--%>
<%@page import="TOBA.ui.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>    
        <title>TOBA::Enrollment Success</title>
    </head>
    <body>
        <jsp:include page="header.html"></jsp:include>
            <div id="wrapper">
                <div id="main-content">
                <% User user = (User) session.getAttribute("user");%>    
                <h1 class="header-style-big-bold">Account created successfully.</h1>
                <div id="ud-header">
                    <h2 class="header-style-big-bold">User Details - ${user.getFirstName()} ${user.getLastName()}</h2>
                </div>
                <div id="ud-container">
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
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>