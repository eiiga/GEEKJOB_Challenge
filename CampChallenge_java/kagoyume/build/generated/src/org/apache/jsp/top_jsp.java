package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.SearchData;
import org.UserDataDTO;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    UserDataDTO dto = (UserDataDTO)session.getAttribute("userinfo");
        if( dto == null){
            dto = new UserDataDTO();
        }

               StringBuffer url = new StringBuffer(); 
           url.append(request.getServletPath());
           url.append("?").append(request.getQueryString());
         String url2 = new String(url);
        

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <!-- BootstrapのCSS読み込み -->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- jQuery読み込み -->\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("        <!-- BootstrapのJS読み込み -->\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header style=\"background-color:#D7EEFF\"><br><br>\n");
      out.write("        ");
 if(dto.getName() == null){ 
      out.write("\n");
      out.write("        <a href=\"login.jsp?url=");
      out.print(url2);
      out.write("\" style=\"position: absolute; right: 20px; top: 20px\">ログイン</a>\n");
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
      out.write("\"  style=\"position: absolute; right: 20px; top: 60px\">ログアウト</a><br>\n");
      out.write("        <a href=\"Cart\" style=\"position: absolute; right: 20px; top: 80px\">買い物かご</a>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        \n");
      out.write("        <h1 align=\"center\">かごゆめ<br></h1><h3 align=\"center\">なんでも買えるシステム（仮）</h3>\n");
      out.write("        <br>\n");
      out.write("        </header>\n");
      out.write("        <br>\n");
      out.write("     \n");
      out.write("        <form action=\"http://localhost:8080/kagoyume/search\" method=\"GET\" class=\"col-xs-4 col-xs-offset-4 form-group\">\n");
      out.write("          \n");
      out.write("            <input type=\"text\" name=\"search\" value=\"\" class=\"center-block form-control\" required>\n");
      out.write("            <input type=\"submit\" name=\"searching\"  class=\"center-block btn btn-primary  btn-sm\" value=\"検索\">\n");
      out.write("          \n");
      out.write("        </form>\n");
      out.write("    </div>\n");
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
