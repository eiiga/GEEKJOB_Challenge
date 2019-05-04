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
public class DB11_2 extends HttpServlet {

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
            int id = Integer.parseInt(request.getParameter("ID"));
            String name = request.getParameter("名前");
            String tel = request.getParameter("電話番号");
            int age = Integer.parseInt(request.getParameter("年齢"));
            String birth = request.getParameter("誕生日");
            
                     
            Connection db_con = null;
            PreparedStatement  db_st1 = null;
            PreparedStatement  db_st2 = null;
            ResultSet db_data = null;
            try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","***","***");
            
            db_st1 = db_con.prepareStatement("update profiles set name = ?, tel = ?, age = ?, birthday = ? where profilesID = ?");
            db_st1.setInt(5, id);
            db_st1.setString(1, name);
            db_st1.setString(2, tel);
            db_st1.setInt(3, age);
            db_st1.setString(4, birth);
            db_st1.executeUpdate();
            
            db_st2 = db_con.prepareStatement("select * from profiles ");
            db_data = db_st2.executeQuery();
            while(db_data.next()){
                out.print("ID："+db_data.getInt("profilesID")+"，");
                out.print("名前："+db_data.getString("name")+"，");
                out.print("電話番号："+db_data.getString("tel")+"，");
                out.print("年齢："+db_data.getInt("age")+"，");
                out.print("誕生日："+db_data.getString("birthday")+"<br>");
            }
            db_data.close();
            db_st1.close();
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
