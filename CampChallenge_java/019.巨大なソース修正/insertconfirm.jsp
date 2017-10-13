<%@page import="UserDataBeans.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    UserDataBeans userinfo =(UserDataBeans)request.getAttribute("user");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
       
        <%if(!userinfo.getName().equals("") && !userinfo.getYear().equals("") && !userinfo.getMonth().equals("") && !userinfo.getDay().equals("") && !userinfo.getType().equals("0") && !userinfo.getTell().equals("") && !userinfo.getComment().equals("")){%>
        
        <h1>登録確認</h1>
        名前:<%= userinfo.getName()%><br>
        生年月日:<%= userinfo.getYear()+"年"+userinfo.getMonth()+"月"+userinfo.getDay()+"日"%><br>
        種別:<%= userinfo.getType()%><br>
        電話番号:<%= userinfo.getTell()%><br>
        自己紹介:<%= userinfo.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="submit" name="yes" value="はい">
        </form>
        <%}else{%>
        <%= userinfo.getConfirmcheck() %><br>
        を入力してください。
         <%}%>
                <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
       
         <%=JumsHelper.getInstance().home()%>
    </body>
</html>
