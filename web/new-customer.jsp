<%-- 
    Document   : new-customer
    Created on : Mar 25, 2019, 9:40:03 AM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TOBA::New Customer Sign-Up</title>
    </head>
    <body>
        <jsp:include page="${request.contextPath}/header.jsp"></jsp:include> 
            <div id="wrapper">
                <div id='form-container'>
                    <form id="sign-up" class="form-style" method="post" action="NewCustomerServlet">
                        <h1>Personal Information...</h1>
                        <label for="firstName">First Name:</label>
                        <input type="text" id="firstName" name="firstName" placeholder="John">

                        <label for="lastName">Last Name:</label>
                        <input type="text" id="lastName" name="lastName" placeholder="Smith">

                        <label for="phone">Phone:</label>
                        <input type="text" id="phone" name="phone" placeholder="555-555-5555">

                        <label for="address">Address:</label>
                        <input type="text" id="address" name="address" placeholder="123 Fake Street">

                        <label for="city">City:</label>
                        <input type="text" id="city" name="city" placeholder="Orlando">

                        <label for="state">State:</label>
                        <input type="text" id="state" name="state" placeholder="FL">

                        <label for="zipcode">Zip Code:</label>
                        <input type="text" id="zipcode" name="zipcode" placeholder="12345">

                        <label for="email">E-mail:</label>
                        <input type="text" id="email" name="email" placeholder="example@xyz.org">

                        <p id="err">${message}</p>                    
                    <div>
                        <input id="sign-up-form-btn-submit" class="btn-style" type="submit" value="Submit">
                    </div>      
                </form>
            </div>
        </div>
        <jsp:include page="${request.contextPath}/footer.jsp"></jsp:include>
    </body>
</html>
