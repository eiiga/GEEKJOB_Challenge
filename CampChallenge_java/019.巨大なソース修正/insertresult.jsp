<%@page import="jums.UserDataDTO"%>
<%@page import="UserDataBeans.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
     UserDataDTO dto =(UserDataDTO)request.getAttribute("DTO");
     
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前:<%= dto.getName()%><br>
        生年月日:<%= dto.getBirthday()%><br>
        種別:<%= dto.getType()%><br>
        電話番号:<%= dto.getTell()%><br>
        自己紹介:<%= dto.getComment()%><br>
        以上の内容で登録しました。<br>
        登録時刻：<%= dto.getNewDate()%><br>
                
         <%=JumsHelper.getInstance().home()%>
         
    </body>
</html>
<% session.invalidate(); %>
