<%-- 
    Document   : mydelete
    Created on : 2017/11/02, 10:36:21
    Author     : ei-tk
--%>

<%@page import="org.JumsHelper"%>
<%@page import="org.UserDataDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

    UserDataDTO dto = (UserDataDTO)session.getAttribute("userinfo");
       
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
        <title>JSP Page</title>
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
        
        <div  class="col-xs-4 col-xs-offset-4" >
        
        名前:<%= dto.getName()%><br>
        パスワード:<%= dto.getPassword()%><br>
        メールアドレス:<%= dto.getMail()%><br>
        住所:<%= dto.getAddress()%><br>
        総額:<%= dto.getTotal()%> 円<br>
        登録日時:<%= dto.getNewDate()%><br><br>
        
        削除しますか？<br><br>
        <a href="MyDeleteResult?data=<%= dto.getUserID() %>" >はい</a>
        <br><br>
        <a href="top.jsp?data=<%= dto.getUserID() %>" >いいえ</a>
        <br><br>
        
            <%=JumsHelper.getInstance().home()%>
        </div>
        
        
        
        
    </body>
</html>
