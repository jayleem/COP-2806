<%-- 
    Document   : error-java
    Created on : Mar 25, 2019, 9:40:51 AM
    Author     : Jason
--%>

<%@ page isErrorPage="true" import="java.io.*" contentType="text/plain"%>
Message:
<%=exception.getMessage()%>

StackTrace:
<%
	StringWriter stringWriter = new StringWriter();
	PrintWriter printWriter = new PrintWriter(stringWriter);
	exception.printStackTrace(printWriter);
	out.println(stringWriter);
	printWriter.close();
	stringWriter.close();
%>