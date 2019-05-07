<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TOBA::Admin Application</title>
    </head>
    <body>
        <jsp:include page="${request.contextPath}/header.jsp"></jsp:include>
            <div id="wrapper">
                <div id="main-content">
                    <div class="ap">
                        <h1>Welcome to the Admin application</h1>
                        <p>Please enter your username and password to continue.</p>
                        <p class="error">Invalid username or password.</p>
                        <div class="ap-form">
                            <form action="${pageContext.request.contextPath}/j_security_check" method="GET">
                                <label>Username</label>
                                <input type="text" name="j_username">
                                <label >Password</label>
                                <input type="password" name="j_password">
                                <input type="submit" class="ap-form-button" value="Login">    
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        <jsp:include page="${request.contextPath}/footer.jsp"></jsp:include>
    </body>
</html>