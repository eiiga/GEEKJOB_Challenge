<%-- 
    Document   : mydata
    Created on : 2017/11/01, 14:49:35
    Author     : ei-tk
--%>
<%@page import="org.JumsHelper"%>
<%@page import="org.UserDataDTO"%>
<%

    UserDataDTO user = (UserDataDTO)request.getAttribute("resultData");
        if( user == null){
            user = new UserDataDTO();
        }
            UserDataDTO dto = (UserDataDTO)session.getAttribute("userinfo");
        if( dto == null){
            dto = new UserDataDTO();
        }
        StringBuffer url = new StringBuffer(); 
           url.append(request.getServletPath());
           url.append("?").append(request.getQueryString());
         String url2 = new String(url);


%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                <h1>詳細情報</h1>
        名前:<%= user.getName()%><br>
        パスワード:<%= user.getPassword()%><br>
        メールアドレス:<%= user.getMail()%><br>
        住所:<%= user.getAddress()%><br>
        総額:<%= user.getTotal()%>円<br>
        登録日時:<%= user.getNewDate()%><br>
        </div>
        
        <br>
        <form action="MyHistory" method="POST" class="col-xs-4 col-xs-offset-4 form-group">
            <input type="hidden" name="userid" value="<%= user.getUserID()%>">
            <input type="submit" name="buy" class="center-block btn btn-primary  btn-sm" value="購入履歴">
            
        </form>
        <br>
        <form action="MyUpdate" method="POST" class="col-xs-4 col-xs-offset-4 form-group">
            <input type="hidden" name="userid" value="<%= user.getUserID()%>">
            <input type="submit" name="update" class="center-block btn btn-primary  btn-sm" value="更新">
            
        </form>
        <br>
        <form action="MyDelete" method="POST" class="col-xs-4 col-xs-offset-4 form-group">
            <input type="hidden" name="userid" value="<%= user.getUserID()%>"> 
            <input type="submit" name="delete" class="center-block btn btn-primary  btn-sm" value="削除">
            
        </form>
            <br>
             <div  class="col-xs-4 col-xs-offset-4" >
            <%=JumsHelper.getInstance().home()%>
             </div>
    </body>
</html>
