<%-- 
    Document   : switch2
    Created on : 2017/09/06, 14:23:15
    Author     : ei-tk
--%>
<%
    char name = 'あ';
    switch(name){
        case 'A':
            out.print("英語");
            break;
        case 'あ':
            out.print("日本語");
            break;
        default:
            out.print(" ");
            break;
                
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
