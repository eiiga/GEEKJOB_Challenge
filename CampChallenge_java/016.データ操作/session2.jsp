<%-- 
    Document   : session2
    Created on : 2017/09/22, 10:22:17
    Author     : ei-tk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession n = request.getSession();
        String protname = (String) n.getAttribute("data1");
        if(protname==null){
            protname = "名前を記入してください";
        }
    HttpSession S = request.getSession();
        String prots = (String)S.getAttribute("data2");
        if(prots==null){
            prots="";
        }
    HttpSession h = request.getSession();
        String prothobby = (String)h.getAttribute("data3");
        if(prothobby==null){
            prothobby = "趣味を記入してください";
        }

  
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action ="http://localhost:8080/challenge14/session2_2" method="post">
            名前
            <br>
            <input type="text" name="名前" value=<%=protname%> >
            <br>
            男：
            <input type="radio" name="性別" value="男"<%
                   if(prots.equals("男")){
                       out.print("checked");
                   }
                   %>>
            女：
            <input type="radio" name="性別" value="女"<%
                   if(prots.equals("女")){
                       out.print("checked");
                   }
                   %>>
            <br>
            趣味 
            <br>
            <textarea cols ="30" rows ="5" name="趣味"  ><%=prothobby%></textarea>
            
            <br>
            <input type="submit" name="Submit" value="送信">
        </form>
    </body>
</html>
