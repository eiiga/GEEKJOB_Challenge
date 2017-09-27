<%-- 
    Document   : DB11_1
    Created on : 2017/09/27, 17:18:56
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
        <form action="http://localhost:8080/challenge15/DB11_2" method="post">
            ID：
            <input type="text" name="ID">
            <br>
            名前：
            <input type="text" name="名前">
            <br>
            電話番号：
            <input type="text" name="電話番号">
            <br>
            年齢：
            <input type="text" name="年齢">
            <br>
            誕生日：
            <input type="text" name="誕生日">
            <br>
            <input type="submit" name="update" value="更新">
        </form>
    </body>
</html>
