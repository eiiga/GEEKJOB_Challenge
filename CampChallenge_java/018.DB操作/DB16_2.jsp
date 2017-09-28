<%-- 
    Document   : DB16_2
    Created on : 2017/09/28, 10:57:12
    Author     : ei-tk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫登録・表示</title>
    </head>
    <body>
        <form action="http://localhost:8080/challenge15/DB16_3" method="post">
            在庫登録
            <br>
            <br>
            在庫ID：
            <input type="text" name="ID">
            <br>
            <br>
            商品名：
            <input type="text" name="name">
            <br>
            <br>
            メーカーID：
            <input type="text" name="infoID">
            <br>
            <br>
            仕入れ日：
            <input type="text" name="day">
            <br>
            <br>
            個数：
            <input type="text" name="num">
            <br>
            <br>
            <br>
            <input type="submit" name="insert" value="登録">
            
        </form>
        <form action="http://localhost:8080/challenge15/DB16_5" method="post">
            <br>
            <br>
            <input type="submit" name="select" value="現在の在庫状況">
        </form>
        <form action="http://localhost:8080/challenge15/DB16_1.jsp" method="post">
            <br>
            <br>
            <input type="submit" name="logout" value="ログアウト">
        </form>
        
    </body>
</html>
