<%-- 
    Document   : for2
    Created on : 2017/09/07, 11:03:58
    Author     : ei-tk
--%>

<%
   String x = "A";
    for(int y = 0; y < 30; y++){
        String name = "e" + x +"i";
        out.print(name+",\n");
        x = x+ "A";     
    }
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
