package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.UserDataDTO;
import org.JumsHelper;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

  UserDataDTO dto = (UserDataDTO)session.getAttribute("userinfo");
        if( dto == null){
            dto = new UserDataDTO();
        }
  
       request.setCharacterEncoding("UTF-8"); 
       String url = request.getParameter("url");
       

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>ログイン画面</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("                \n");
      out.write("                \n");
      out.write("        ");
 if(dto.getName() == null){ 
      out.write("\n");
      out.write("        <a href=\"login.jsp\" style=\"position: absolute; right: 20px; top: 20px\">ログイン</a>\n");
      out.write("        ");
} else{ 
      out.write("\n");
      out.write("        <p align=\"right\">ようこそ\n");
      out.write("        <a href=\"http://localhost:8080/kagoyume/Mydata?data=");
      out.print( dto.getUserID() );
      out.write('"');
      out.write('>');
      out.print( dto.getName() );
      out.write("</a>\n");
      out.write("        さん</p>\n");
      out.write("        <a href=\"http://localhost:8080/kagoyume/Logout?data=");
      out.print( dto.getName() );
      out.write("\"  style=\"position: absolute; right: 20px; top: 40px\">ログアウト</a>\n");
      out.write("        <a href=\"Cart\" style=\"position: absolute;right: 20px; top: 60px\">買い物かご</a>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        \n");
      out.write("        <h1 align=\"center\">かごゆめ<br></h1><h3 align=\"center\">なんでも買えるシステム（仮）</h3>\n");
      out.write("        <br>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <form action=\"http://localhost:8080/kagoyume/Login\" method=\"post\">\n");
      out.write("            <input type=\"text\" name=\"name\" value=\"\" required ><br>\n");
      out.write("            <input type=\"password\" name=\"pass\" value=\"\"  required><br>\n");
      out.write("            <input type=\"hidden\" name=\"url\" value=\"");
      out.print( url );
      out.write("\" >\n");
      out.write("            <input type=\"submit\" name=\"login\" value=\"ログイン\">\n");
      out.write("        </form>\n");
      out.write("        <form action=\"registration.jsp\" method=\"post\">\n");
      out.write("            <input type=\"submit\" name=\"new\" value=\"新規登録\">\n");
      out.write("        </form>\n");
      out.write("        <br>\n");
      out.write("        ");
      out.print(JumsHelper.getInstance().home());
      out.write("\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
