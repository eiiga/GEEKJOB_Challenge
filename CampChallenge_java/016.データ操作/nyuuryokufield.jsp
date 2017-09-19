<%-- 
    Document   : nyuuryokufield
    Created on : 2017/09/19, 16:07:27
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
        <form action = "./data.jsp" method="post">
         <!--form--> 
            名前
            <br>
            <input type="text" name="名前">
            <br>
            男：
            <input type="radio" name="性別" value="男">
            女：
            <input type="radio" name="性別" value="女">
            <br>
            趣味 
            <br>
            <textarea cols ="30" rows ="5" name="趣味"></textarea>
            
            <br>
            <input type="submit" name="btnSubmit">
            <h1></h1>
    </body>
</html>

