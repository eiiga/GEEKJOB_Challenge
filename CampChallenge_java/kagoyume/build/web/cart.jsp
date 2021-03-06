<%-- 
    Document   : cart
    Created on : 2017/11/02, 13:18:46
    Author     : ei-tk
--%>

<%@page import="org.UserDataDTO"%>
<%@page import="org.JumsHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.SearchData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    ArrayList<SearchData> cartitem = (ArrayList<SearchData>)session.getAttribute("cartitem");
     UserDataDTO dto = (UserDataDTO)session.getAttribute("userinfo");
        if( dto == null){
            dto = new UserDataDTO();
        }
        StringBuffer url = new StringBuffer(); 
           url.append(request.getServletPath());
           url.append("?").append(request.getQueryString());
         String url2 = new String(url);


%>

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
<%
    if(cartitem == null|| cartitem.size() == 0){
    out.print("カートに商品がありません。");
    out.print("<br>");
    }else{
    for(int i = 0; i < cartitem.size(); i++ ){%>
    商品名：<a href="Item?data=<%= cartitem.get(i).getCode() %>"><%= cartitem.get(i).getName() %></a>
    <br>
    金額：<%= cartitem.get(i).getYen() %>円
    <br>
    <img src="<%= cartitem.get(i).getImage() %>">
    <br>
    <a href="CartDelete?cartnum=<%= i %>"> 削除 </a>
    <br><br><br>
        <%}%>
        
        <% int total = 0;
            for(int j = 0; j < cartitem.size(); j++){
            int price = Integer.parseInt(cartitem.get(j).getYen());
            total = total + price;
        }%>
        合計金額：<%= total %>円
        </div>
        <br>
        <form action="buyconfirm.jsp" method="POST" class="col-xs-4 col-xs-offset-4 form-group">
            <input type="submit" name="buy" class="center-block btn btn-primary  btn-sm" value="購入確認">
        </form>
    
    <%}%>
    <br>
             <div  class="col-xs-4 col-xs-offset-4" >
            <%=JumsHelper.getInstance().home()%>
             </div>
    
    </body>
</html>
