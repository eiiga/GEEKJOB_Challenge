<%-- 
    Document   : Cookies
    Created on : 2017/09/21, 10:45:49
    Author     : ei-tk
--%>
<%@ page import="java.net.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
          SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd　HH:mm:ss");
          Date d = new Date();
          String s =f.format(d);
          String value = URLEncoder.encode(d.toString());
          Cookie c = new Cookie("accesstime",value);
          c.setMaxAge(60*60*24);
          response.addCookie(c);
        %>
            <form action="http://localhost:8080/challenge14/cockie" method="POST">
                <br><br><input type="submit" name="時刻" value="時刻">
            </form>
        <h1></h1>
    </body>
</html>
