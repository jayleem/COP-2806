<%-- 
    Document   : new-customer
    Created on : Mar 25, 2019, 9:40:03 AM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>New Customer Sign-Up</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/stylesheet.css">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/media-queries.css">
    </head>
    <body>
        <header>
            <div id="nav">
                <div id="hamburger-btn" onclick="flyout()">
                    <div class="line1"></div>
                    <div class="line2"></div>
                    <div class="line3"></div>
                </div>
                <h1 id="title">TOBA</h1>
                <ul>
                    <li><a href='login.html' target='#'>Login</a></li>
                    <li><p>|</p></li>
                </ul>
            </div>            
            <div id="hidden-menu">
                <div id="nav-col">
                    <ul>
                        <li><a href='new-customer.jsp' target='_self'>Enroll</a></li>
                        <li><a href='#' target='_self'>Schedule an appointment</a></li>
                        <li><a href='#' target='_self'>Get the app</a></li>
                        <li><a href='#' target='_self'>Help</a></li>                    
                        <li><a href='#' target='_self'>Find a location</a></li>
                        <li><a href='#' target='_self'>Contact Us</a></li>
                        <li><a href='#' target='_self'>Privacy &amp  Security</a></li>
                        <li><a href='#' target='_self'>Small Business</a></li>
                        <li><a href='#' target='_self'>Wealth Management</a></li>
                        <li><a href='#' target='_self'>Businesses &amp Institutions</a></li>
                        <li><a href='#' target='_self'>About Us</a></li>
                    </ul>
                </div>
            </div>            
        </header>

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

        <footer id="footer">
            <p>&copy; 2019 TOBA. All Rights Reserved.</p>
        </footer>

        <script src="js/flyout.js"></script>
    </body>
</html>
