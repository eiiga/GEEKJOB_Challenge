<%@page import="java.util.Calendar"%>
<%@page import="jums.UserDataDTO"%>
<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)request.getAttribute("updateData");
    Calendar birthday = Calendar.getInstance();
    birthday.setTime(udd.getBirthday());
    int year = birthday.get(Calendar.YEAR);
    int m = birthday.get(Calendar.MONTH);
    int month = m+1;
    int day = birthday.get(Calendar.DAY_OF_MONTH);
    String userID = String.valueOf(udd.getUserID());
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
    <form action="UpdateResult" method="POST">
        <input type="hidden" name="userID" value="<%= userID %>">
        名前:
        <input type="text" name="name" value="<%= udd.getName() %>">
        <br><br>

        生年月日:　
        <select name="year">
            <option value="">----</option>
            <% for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" <% if(year == i){out.print("selected = \"selected\"");}%>><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <% for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" <% if(month == i){out.print("selected = \"selected\"");}%> ><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <% for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>" <% if(day == i){out.print("selected = \"selected\"");}%> ><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
            <% for(int i = 1; i<=3; i++){ %>
            <input type="radio" name="type" value="<%=i%>"<% if(udd.getType() == i){out.print("checked");}%> > <%=jh.exTypenum(i)%><br>
            <% } %>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%= udd.getTell() %>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= udd.getComment() %></textarea><br><br>
        
        <input type="submit" name="btnSubmit" value="更新">
    </form>
        <form action="resultdetail.jsp" method="post">
            <input type="submit" name="resultdetail" value="戻る">
        </form>
        <br>
        <%=jh.home()%>
    </body>
</html>
