/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.Math;

/**
 *
 * @author ei-tk
 */
public class file3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
           Date start = new Date();
           SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd　HH:mm:ss");
            start = f.parse("2017-09-19　13:13:00");
            String s =f.format(start);
            
           File log = new File("og.text");
           FileWriter fw = new FileWriter(log);
            fw.write("<br>"+s+"：開始<br>");
            fw.close(); 
           
           double r = 4;
           double R = r * 2 * Math.PI;
           double r2 = r * r * Math.PI;
           out.print("円の半径："+r+"<br>");
           out.print("円周の長さ："+R+"<br>");
           out.print("円の面積："+r2+"<br>");
           
           Date finish = new Date();
           SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd　HH:mm:ss");
            finish = f2.parse("2017-09-19　14:26:00");
            String st =f2.format(finish);
            
           FileWriter fw2 = new FileWriter(log, true);
            fw2.write("<br>"+st+"：終了<br>");
            fw2.close();

           FileReader fr = new FileReader(log);
           BufferedReader br = new BufferedReader(fr);
            out.print(br.readLine()+"<br>");
            br.close();
          
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(file3.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(file3.class.getName()).log(Level.SEVERE, null, ex);
        }
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
