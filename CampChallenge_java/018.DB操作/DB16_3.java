/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author ei-tk
 */
public class DB16_3 extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            request.setCharacterEncoding("UTF-8");
            int ID = Integer.parseInt(request.getParameter("ID"));
            String name = request.getParameter("name");
            int infoID = Integer.parseInt(request.getParameter("infoID"));
            String day = request.getParameter("day");
            int num = Integer.parseInt(request.getParameter("num"));
            String info = request.getParameter("info"); 
            
            Connection db_con = null;
            PreparedStatement  db_st = null;
           

            
            try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB16","***","***");
            
            db_st = db_con.prepareStatement("insert into user(ID, name, infoID, day, num) values(?,?,?,?,?)");
            db_st.setInt(1, ID);
            db_st.setString(2, name);
            db_st.setInt(3, infoID);
            db_st.setString(4, day);
            db_st.setInt(5, num);
            db_st.executeUpdate();
                       
            out.print("登録しました。<br>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DB16_5</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"http://localhost:8080/challenge15/DB16_2.jsp\" method=\"post\">");
            out.print("<input type=\"submit\" value=\"戻る\"");
            out.print("</form>");
            out.println("</body>");
            out.println("</html>");
            
            db_st.close();
            db_con.close();
            } catch(Exception e_con){
                out.print(e_con.getMessage());      
            } finally{
                if(db_con != null){
                    try{
                        db_con.close();
                    }catch(Exception e_con){
                        out.print(e_con.getMessage());
                    }
                }
        }            
            
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
