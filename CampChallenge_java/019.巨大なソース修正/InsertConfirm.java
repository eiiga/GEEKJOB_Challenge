package jums;

import UserDataBeans.UserDataBeans;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertconfirm.jspと対応するサーブレット
 * フォーム入力された情報はここでセッションに格納し、以降持ちまわることになる
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertConfirm extends HttpServlet {


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");//セッションに格納する文字コードをUTF-8に変更
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
            //フォームからの入力を取得
            String name = request.getParameter("name");
                if(name == null){
                    name = "";
                }
            String year = request.getParameter("year");
                 if(year.equals("")){
                    year = "";
                }
            String month = request.getParameter("month");
                 if(month == null){
                    month = "";
                }
            String day = request.getParameter("day");
                 if(day == null){
                    day = "";
                }
            String type = request.getParameter("type");
                if(type == null){
                    type = "0";
                }
            String tell = request.getParameter("tell");
                 if(tell == null){
                    tell = "";
                }
            String comment = request.getParameter("comment");
                 if(comment == null){
                    comment = "";
                }

            StringBuilder confirm = new StringBuilder("");
                if(name.equals("")){
                    confirm.append("「名前」");
                }
                if(year.equals("") || month.equals("") || day.equals("") ){
                    confirm.append("「生年月日」");
                }
                if(type.equals("0") ){
                    confirm.append("「種別」");
                }
                if(tell.equals("") ){
                    confirm.append("「電話番号」");
                }
                 if(comment.equals("")){
                    confirm.append("「自己紹介」");
                }
            String confirmcheck = confirm.toString();
            
            
            //ユーザー情報に対応したJavaBeansオブジェクトに格納していく
            UserDataBeans userinfo = new UserDataBeans();
            userinfo.setName(name);
            userinfo.setYear(year);
            userinfo.setMonth(month);
            userinfo.setDay(day);
            userinfo.setType(type);
            userinfo.setTell(tell);
            userinfo.setComment(comment);
            userinfo.setConfirmcheck(confirmcheck);
            
            

//            セッションに格納
            session.setAttribute("user", userinfo);
            System.out.println("Session updated!!");
            
           
            

            
            request.setAttribute("user", userinfo);
            request.getRequestDispatcher("/insertconfirm.jsp").forward(request, response);
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
