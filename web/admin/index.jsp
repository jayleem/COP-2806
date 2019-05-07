<%-- 
    Document   : index
    Created on : Mar 25, 2019, 9:40:03 AM
    Author     : Jason
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TOBA::Home</title>
    </head>
    <body>
        <jsp:include page="${request.contextPath}/header.jsp"></jsp:include>
            <div id="wrapper">
                <div id="main-content">
                    <a href='${pageContext.request.contextPath}/admin/reports.jsp' target='_self'>Reports</a>
                </div>
            </div>
        <jsp:include page="${request.contextPath}/footer.jsp"></jsp:include>
    </body>
</html>
