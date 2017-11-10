/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ei-tk
 */
public class MyUpdateResult extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
       
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        try{

                        
             request.setCharacterEncoding("UTF-8");
            
//            UserDataに格納
            UserData ud = new UserData();

            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            
            ud.setUserID(userid);
            ud.setName(request.getParameter("name"));
            ud.setPass(request.getParameter("pass"));
            ud.setEmail(request.getParameter("email"));
            ud.setAddress(request.getParameter("address"));

            
            UserDataDTO uddto = new UserDataDTO();
                uddto.setUserID(ud.getUserID());
                uddto.setName(ud.getName());
                uddto.setPassword(ud.getPass());
                uddto.setMail(ud.getEmail());
                uddto.setAddress(ud.getAddress()); 
            
            
            //DBへデータの挿入
            UserDataDAO .getInstance().update(uddto);
            
            UserDataDTO dto = UserDataDAO .getInstance().searchByID(uddto);
            
            session.setAttribute("userinfo", dto);
            request.getRequestDispatcher("/myupdateresult.jsp").forward(request, response);
            
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        
        }finally{
            out.close();
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
