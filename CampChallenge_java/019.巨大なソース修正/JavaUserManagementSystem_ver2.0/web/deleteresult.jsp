
<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    JumsHelper jh = JumsHelper.getInstance();
%>
    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
    <h1>削除確認</h1>
    
    削除しました。<br>
    <form action="SearchResult" method="post">
        <input type="hidden" name="name" value="">
        <input type="hidden" name="year" value="0">
        <input type="hidden" name="type" value="0">
        <input type="submit" name="searchresult" value="検索結果">
    </form>
    
    <%=jh.home()%>
    </body>
</html>
