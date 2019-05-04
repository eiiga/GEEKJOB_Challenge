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
public class DB7 extends HttpServlet {

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
            Connection db_con = null;
            PreparedStatement  db_st = null;
            PreparedStatement  db_st2 = null;
            ResultSet db_data = null;
            String sql1 = "update profiles set name = ?, age = ?, birthday = ? where profilesID = 1";
            String sql2 = "select * from profiles";
            try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","***","***"); 
            db_st = db_con.prepareStatement(sql1);
            db_st.setString(1, "松岡　修造");
            db_st.setInt(2, 48);
            db_st.setString(3, "1967-11-06");
            db_st.executeUpdate();
            db_st2 = db_con.prepareStatement(sql2);
            db_data = db_st2.executeQuery();
            while(db_data.next()){
                out.print("ID："+db_data.getInt("profilesID")+"，");
                out.print("名前："+db_data.getString("name")+"，");
                out.print("電話番号："+db_data.getString("tel")+"，");
                out.print("年齢："+db_data.getInt("age")+"，");
                out.print("誕生日："+db_data.getString("birthday")+"<br>");
            }
            db_data.close();
            db_st.close();
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
