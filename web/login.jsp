<%-- 
    Document   : login
    Created on : Mar 25, 2019, 9:40:03 AM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TOBA::Login</title>
    <body>
        <jsp:include page="${request.contextPath}/header.jsp"></jsp:include>
            <div id="wrapper">
                <div id="main-content">
                    <div class="ap">
                        <div class="ap-form">
                            <form action="LoginServlet" method="post">
                                <h1>Welcome to TOBA.</h1>
                                <p>Please enter your username and password to continue.</p>
                                <label for="username">Username:</label>
                                <input type="text" id="username" name="username" placeholder="username..." required>
                                <label for="password">Password:</label>
                                <input type="password" id="password" name="password" placeholder="password..." required>
                                <input id="login-form-btn-submit" class="ap-form-button" type="submit" value="Login" name="submit"> 
                            </form>
                            <ul>
                                <!-- <li><a href='#' target='#'>Forgot login information?</a></li> -->
                                <li><a href='password-reset.jsp' target='#'>Forgotten your password?</a></li>
                                <li><a href='new-customer.jsp' target='#'>Sign up Today!</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        <jsp:include page="${request.contextPath}/footer.jsp"></jsp:include>
    </body>
</html>
