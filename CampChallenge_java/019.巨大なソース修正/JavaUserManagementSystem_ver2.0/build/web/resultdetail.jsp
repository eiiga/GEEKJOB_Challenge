<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    HttpSession rd = request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)rd.getAttribute("resultData");
    String UserID = String.valueOf(udd.getUserID());
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        <h1>詳細情報</h1>
        名前:<%= udd.getName()%><br>
        生年月日:<%= udd.getBirthday()%><br>
        種別:<%= udd.getType()%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        登録日時:<%= udd.getNewDate()%><br>
        <form action="Update" method="POST">
        <input type="hidden" name="UserID" value ="<%= UserID %>" >
        <input type="submit" name="update" value="変更" style="width:100px">
        
        </form>
        <form action="Delete" method="POST">
        <input type="hidden" name="UserID" value ="<%= UserID %>" >
        <input type="submit" name="delete" value="削除" style="width:100px">
        </form>
        <form action="SearchResult" method="post">
        <input type="hidden" name="name" value="">
        <input type="hidden" name="year" value="0">
        <input type="hidden" name="type" value="0">
        <input type="submit" name="searchresult" value="検索結果">
        </form>
        <%=jh.home()%>
    </body>
    
</html>
