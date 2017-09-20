<%-- 
    Document   : querystring1-2
    Created on : 2017/09/20, 11:28:20
    Author     : ei-tk
--%>

<%
  request.setCharacterEncoding("UTF-8");
  out.print(request.getParameter("total"));
  out.print("<br>");
  out.print(request.getParameter("count"));
  out.print("<br>");
          
  switch(Integer.parseInt(request.getParameter("type"))){
      case 1:
          out.print("雑貨");
          out.print("<br>");
          break;
      case 2:
          out.print("生鮮食品");
          out.print("<br>");
          break;
      case 3:
          out.print("その他");
          out.print("<br>");
          break;
  }
    
  int x = Integer.parseInt(request.getParameter("total"));
  int y = Integer.parseInt(request.getParameter("count"));
  
  out.print("1個あたり："+x/y);
  out.print("<br>");
  
if(3000<=x && x<5000){
    double p = x * 0.04;
    out.print("ポイント："+p);
}else if (x>=5000){
    double p = x * 0.05;
    out.print("ポイント："+p);
}else{
    out.print("ポイント：0");
}

     
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
