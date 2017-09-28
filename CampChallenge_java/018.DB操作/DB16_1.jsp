<%-- 
    Document   : DB16_1
    Created on : 2017/09/28, 10:52:46
    Author     : ei-tk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン画面</title>
    </head>
    <body>
      <form action="http://localhost:8080/challenge15/DB16_4" method="post">
            <p>ユーザー名：</p>
            <input type="text" name="user">
            <br>
            <p>パスワード：</p>
            <input type="password" name="pass">
            <br>
            <br>      
            <input type="submit" name="login" value="ログイン">
        </form>
    </body>
</html>
