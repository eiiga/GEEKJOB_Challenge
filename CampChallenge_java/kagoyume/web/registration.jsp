<%-- 
    Document   : registration
    Created on : 2017/10/31, 14:29:33
    Author     : ei-tk
--%>

<%@page import="org.UserDataDTO"%>
<%@page import="org.JumsHelper"%>
<%@page import="org.JumsHelper"%>
<%@page import="org.UserData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    UserDataDTO dto = (UserDataDTO)session.getAttribute("userinfo");
        if( dto == null){
            dto = new UserDataDTO();
        }
UserData ud = (UserData)session.getAttribute("User");
    if(ud == null ){
        ud = new UserData();
    }
        StringBuffer url = new StringBuffer(); 
           url.append(request.getServletPath());
           url.append("?").append(request.getQueryString());
         String url2 = new String(url);

%>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- BootstrapのCSS読み込み -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- jQuery読み込み -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- BootstrapのJS読み込み -->
        <script src="js/bootstrap.min.js"></script>
        <title>会員登録</title>
    </head>
    <body>
        <header style="background-color:#D7EEFF"><br><br>
        <% if(dto.getName() == null){ %>
        <a href="login.jsp?url=<%= url2 %>" style="position: absolute; right: 20px; top: 20px">ログイン</a>
        <%} else{ %>
        <p align="right">ようこそ
        <a href="http://localhost:8080/kagoyume/Mydata?data=<%= dto.getUserID() %>"><%= dto.getName() %></a>
        さん</p>
        <a href="http://localhost:8080/kagoyume/Logout?data=<%= dto.getName() %>"  style="position: absolute; right: 20px; top: 60px">ログアウト</a>
        <a href="Cart" style="position: absolute;right: 20px; top: 80px">買い物かご</a>
        <% } %>
        
        <h1 align="center">かごゆめ<br></h1><h3 align="center">なんでも買えるシステム（仮）</h3>
        <br>
        </header>
        
        
        
        
        <form action="RegistrationConfirm" method="POST" class="col-xs-4 col-xs-offset-4 form-group" >
            名前：
            <input type="text" name="name"  class="center-block form-control" value="<%= ud.getName() %>" required><br><br>
            パスワード：
            <input type="password" name="pass"  class="center-block form-control" value="<%= ud.getPass() %>" required ><br><br>
            メールアドレス：
            <input type="text" name="email"  class="center-block form-control" value="<%= ud.getEmail() %>" required><br><br>
            住所：<br>
            <textarea name="address" rows=10 cols=50 style="resize:none" wrap="hard"  class="center-block form-control" required><%= ud.getAddress() %></textarea><br><br>
            <input type="submit" name="entry"  class="center-block btn btn-primary  btn-sm"  value="登録">
        </form>
            
            <br>
            <div  class="col-xs-4 col-xs-offset-4" >
            <%=JumsHelper.getInstance().home()%>
             </div>
    </body>
</html>
