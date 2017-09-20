<%-- 
    Document   : querystring
    Created on : 2017/09/20, 11:08:53
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
        <form action = "./querystring1-2.jsp" method="get">
        総額：
        <input type="number" name="total"  >
        <br>
        個数：        
        <input type="number" name="count" step="1" >
        <br>
        雑貨：
        <input type="radio" name="type" value="1">
        生鮮食品：
        <input type="radio" name="type" value="2">
        その他：
        <input type="radio" name="type" value="3">
        <br>
        <br>
        <br>
        <input type="submit" name="送信" value="送信">
        </form>
        <h1></h1>
    </body>
</html>
