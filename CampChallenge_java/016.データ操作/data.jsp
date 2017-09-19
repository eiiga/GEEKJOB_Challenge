<%-- 
    Document   : data
    Created on : 2017/09/19, 17:04:06
    Author     : ei-tk
--%>
<%
  request.setCharacterEncoding("UTF-8");
  out.print(request.getParameter("名前"));
  out.print("<br>");
  out.print(request.getParameter("性別"));
  out.print("<br>");
  out.print(request.getParameter("趣味"));
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1></h1>
    </body>
</html>
