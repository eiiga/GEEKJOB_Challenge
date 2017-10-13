<%@page import="UserDataBeans.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    
   UserDataBeans userinfo =(UserDataBeans)session.getAttribute("user");
      if(userinfo == null){
       userinfo = new UserDataBeans();
   }
      if(userinfo.getName()==null){
       userinfo.setName("");
   }
      if(userinfo.getTell()==null){
       userinfo.setTell("");
   }
      if(userinfo.getComment()==null){
       userinfo.setComment("");
   } 
      if(userinfo.getType()==null){
       userinfo.setType("0");
   } 
      if(userinfo.getYear()==null){
       userinfo.setYear("");
   } 
      if(userinfo.getMonth()==null){
       userinfo.setMonth("");
   } 
      if(userinfo.getDay()==null){
       userinfo.setDay("");
   } 
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value=<%=userinfo.getName()%>>
        <br><br>

        生年月日:　
        <select name="year">
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"> <%=i%> </option>
            <% } %>
            <option value="<%=userinfo.getYear()%>" selected ><%=userinfo.getYear()%> </option>
        </select>年
        <select name="month">
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
            <option value="<%=userinfo.getMonth()%>" selected ><%=userinfo.getMonth()%> </option>
        </select>月
        <select name="day">
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
            <option value="<%=userinfo.getDay()%>" selected ><%=userinfo.getDay()%> </option>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1" <% if(userinfo.getType().equals("1")){
            out.print("checked");}%> >エンジニア<br>
        <input type="radio" name="type" value="2" <% if(userinfo.getType().equals("2")){
            out.print("checked");}%>>営業<br>
        <input type="radio" name="type" value="3" <% if(userinfo.getType().equals("3")){
            out.print("checked");}%> >その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%=userinfo.getTell()%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=userinfo.getComment()%></textarea><br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
