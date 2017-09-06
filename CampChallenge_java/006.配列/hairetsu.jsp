<%-- 
    Document   : hairetsu
    Created on : 2017/09/06, 15:19:32
    Author     : ei-tk
--%>
<%@ page import = "java.util.ArrayList"%>
<%
    ArrayList<String> data = new ArrayList<String>();
    data.add("10");
    data.add("100");
    data.add("soeda");
    data.add("hayashi");
    data.add("-20");
    data.add("118");
    data.add("END");
    out.print(data.get(0));
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
