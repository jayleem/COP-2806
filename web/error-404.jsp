<%-- 
    Document   : error-404
    Created on : Mar 25, 2019, 9:40:28 AM
    Author     : Jason
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<% response.setStatus(404);%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>404 error</title>
    </head>
    <body>
        <h1>Page not found!!!</h1>
    </body>
</html>