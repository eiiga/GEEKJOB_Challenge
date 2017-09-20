<%-- 
    Document   : querystring2-2
    Created on : 2017/09/20, 16:20:40
    Author     : ei-tk
--%>
<%@page import="java.util.ArrayList"%>
<%
request.setCharacterEncoding("UTF-8");
  out.print("元の値：");
  out.print(request.getParameter("total"));
  out.print("<br>");
  ArrayList<Integer>p = new ArrayList<Integer>();
  int x = Integer.parseInt(request.getParameter("total"));
    for(int i =2;i<10;){        
      if(x % i == 0){
         x = x/i;
         p.add(i);
    }else{
          i++;
      }
    }
    for(int j =0;j<p.size();j++){
        out.print(p.get(j));
        out.print("<br>");
    }
    out.print("余った値："+x);
   
    
 %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1></h1>
    </body>
</html>
