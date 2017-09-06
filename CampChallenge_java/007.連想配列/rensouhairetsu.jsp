<%-- 
    Document   : rensouhairetsu
    Created on : 2017/09/06, 16:37:13
    Author     : ei-tk
--%>

<%@ page import = "java.util.HashMap"%>
<%
    HashMap<String, String> prof = new HashMap<String, String>();
    prof.put("1", "AAA");
    prof.put("hello", "world");
    prof.put("soeda", "33");
    prof.put("20", "20");
    
    out.print(prof.get("1"));
    out.print(prof.get("hello"));
    out.print(prof.get("soeda"));
    out.print(prof.get("20"));
    
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
