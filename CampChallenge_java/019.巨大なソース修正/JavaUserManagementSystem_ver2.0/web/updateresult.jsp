<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper" %>
<%
    
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udbs = (UserDataBeans)request.getAttribute("udbs");
    Date now = new Date(); 
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String n = f.format(now);
    int userID = udbs.getUserID();
    String id = String.valueOf(userID);
   
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <h1>変更結果</h1><br>
        名前:<%= udbs.getName()%><br>
        生年月日:<%= udbs.getYear()+"年"+udbs.getMonth()+"月"+udbs.getDay()+"日"%><br>
        種別:<%= jh.exTypenum(udbs.getType())%><br>
        電話番号:<%= udbs.getTell()%><br>
        自己紹介:<%= udbs.getComment()%><br>
        更新時刻：<% out.print(n);%><br>
        以上の内容で更新しました。<br>
    </body>
    <form action="ResultDetail" method="post">
         <input type="hidden" name="id" value="<%= id %>">
        <% // key : UserID, value = 4 とか 5 とか     %> 
         
         
        <input type="submit" name="resultdetail" value="詳細へ戻る">
    </form>
    <%=jh.home()%>
    </body>
</html>
