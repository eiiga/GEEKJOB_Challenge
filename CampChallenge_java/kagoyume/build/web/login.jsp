<%-- 
    Document   : login
    Created on : 2017/10/31, 13:12:33
    Author     : ei-tk
--%>

<%@page import="org.UserDataDTO"%>
<%@page import="org.JumsHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  UserDataDTO dto = (UserDataDTO)session.getAttribute("userinfo");
        if( dto == null){
            dto = new UserDataDTO();
        }
  
       request.setCharacterEncoding("UTF-8"); 
       String url = request.getParameter("url");
       
        

       
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
        <title>ログイン画面</title>
    </head>
    <body>
        
                
        <header style="background-color:#D7EEFF"><br><br>
        <% if(dto.getName() == null){ %>
        <a href="login.jsp" style="position: absolute; right: 20px; top: 20px">ログイン</a>
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
        
        
        
        <form action="http://localhost:8080/kagoyume/Login" method="post" class="col-xs-4 col-xs-offset-4 form-group">
            <input type="text" name="name" value="" required  class="center-block form-control"><br>
            <input type="password" name="pass" value=""  required  class="center-block form-control"><br>
            <input type="hidden" name="url" value="<%= url %>" >
            <input type="submit" name="login" class="center-block btn btn-primary  btn-sm"  value="ログイン">
        </form>
        <form action="registration.jsp" method="post" class="col-xs-4 col-xs-offset-4 form-group">
            <input type="submit" name="new" class="center-block btn btn-primary  btn-sm"  value="新規登録">
        </form>
        <br>
         <div  class="col-xs-4 col-xs-offset-4" >
            <%=JumsHelper.getInstance().home()%>
             </div>
        
    </body>
</html>
