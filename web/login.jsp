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
        <jsp:include page="header.html"></jsp:include>
            <div id="wrapper">
                <div id="main-content">
                    <div id='form-container'>
                        <form id="login" class="form-style" method="post" action="LoginServlet">
                            <h1>Login...</h1>
                            <label for="username">Username:</label>
                            <input type="text" id="username" name="username" placeholder="username..." required>
                            <label for="password">Password:</label>
                            <input type="password" id="password" name="password" placeholder="password..." required>
                            <input id="login-form-btn-submit" class="btn-style" type="submit" value="Login" name="submit">
                        </form>
                        <ul>
                            <!-- <li><a href='#' target='#'>Forgot login information?</a></li> -->
                            <li><a href='password-reset.jsp' target='#'>Reset password</a></li>
                            <li><a href='new-customer.jsp' target='#'>Enroll</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
