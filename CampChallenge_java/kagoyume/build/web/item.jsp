<%-- 
    Document   : item
    Created on : 2017/10/31, 10:46:25
    Author     : ei-tk
--%>


<%@page import="org.UserDataDTO"%>
<%@page import="org.JumsHelper"%>
<%@page import="org.SearchData"%>

<%
   SearchData sd = (SearchData)session.getAttribute("detail");
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
        
        <%= sd.getName() %>
        <br>
        <%= sd.getYen()%>円
        <br>
        <%= sd.getHeadline()%>
        <br>
        <%= sd.getDescription()%>
        <br>
        <img src="<%= sd.getImage() %>">
        
        </div>
        
        <form action="http://localhost:8080/kagoyume/Add" method="GET" class="col-xs-4 col-xs-offset-4 form-group">
            <input type="hidden" name="code" value="<%= sd.getCode() %>">
            <input type="submit" name="cart" class="center-block btn btn-primary  btn-sm"  value="カートに追加">
        </form>
            <br>
             <div  class="col-xs-4 col-xs-offset-4" >
            <%=JumsHelper.getInstance().home()%>
             </div>
    </body>
</html>
