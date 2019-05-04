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
public class DB16_5 extends HttpServlet {

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
           
            
            Connection db_con = null;
            PreparedStatement  db_st1 = null;
            PreparedStatement  db_st2 = null;
            ResultSet db_data1 = null;
            ResultSet db_data2 = null;
            
            try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB16","***","***");
            
            db_st1 = db_con.prepareStatement("select * from user ");
            
            
            db_data1 = db_st1.executeQuery();
            
            while(db_data1.next()){
                out.print("在庫ID："+db_data1.getInt("ID")+"，");
                out.print("商品名："+db_data1.getString("name")+"，");
                out.print("メーカーID："+db_data1.getInt("infoID")+"，");
                out.print("仕入れ日："+db_data1.getString("day")+"，");
                out.print("個数："+db_data1.getInt("num")+"<br><br>");
                }
            
            db_st2 = db_con.prepareStatement("select * from information ");
            db_data2 = db_st2.executeQuery();
            

            while(db_data2.next()){
                out.print("メーカーID："+db_data2.getInt("infoID")+"，");
                out.print("メーカー："+db_data2.getString("information")+"<br>");
                }
            
            db_data1.close();
            db_st1.close();           
            db_data2.close();          
            db_st2.close();
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
