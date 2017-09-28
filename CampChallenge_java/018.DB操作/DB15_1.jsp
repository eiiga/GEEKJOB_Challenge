<%-- 
    Document   : DB15_1
    Created on : 2017/09/28, 10:21:12
    Author     : ei-tk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="http://localhost:8080/challenge15/DB15_2" method="post">
            <p>名前：</p>
            <input type="text" name="name" >
            <br>
            <p>年齢：</p>
            <input type="text" name="age" >
            <br>
            <p>誕生日：</p>
            <input type="text" name="birth" >
            <br>
            <br>
            <input type="submit" name="search" value="検索">
        </form>
    </body>
</html>
