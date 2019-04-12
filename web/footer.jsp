<%-- 
    Document   : footer
    Created on : Apr 10, 2019, 1:14:12 PM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.Date" %>
<%@page import = "java.text.SimpleDateFormat" %>

<%
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  String date = sdf.format(new Date());
%>

<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
    </body>
    <footer id="footer">
        <p>&copy; <%=date%> TOBA. All Rights Reserved.</p>
    </footer>
</html>
