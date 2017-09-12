/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ei-tk
 */
public class hikisuutomodorichi2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */   
String[] profile(String ID){    
    String a[]={"12345","田中","1992/03/09","埼玉"};
    String b[]={"12333","鈴木","1998/02/02",null};
    String c[]={"12987","佐藤","1997/07/03","千葉"};
     switch(ID){
         case "a":
             return a;
         case "b":
             return b;
         case "c":
             return c;
     }  
    return null;
              
} 




    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String[] moji={"a","b","c"};
           
            for(String value: moji ){
                 String prof[] = profile(value);
                 if(prof[3]==null){
                     out.print(prof[3]="");
                     out.print("名前："+prof[1]+"<br>生年月日："+prof[2]+"<br>住所："+prof[3]+"<br>");
                     continue;
                 }
                 out.print("名前："+prof[1]+"<br>生年月日："+prof[2]+"<br>住所："+prof[3]+"<br>");
              
               
               
               
            }
            
//            for(String value: b){
//                if(b[3]==null){
//                    continue;
//                }
//               out.print(value+"<br>");
//            }
//            
//             for(String value: c){
//               out.print(value+"<br>");
//            }
//            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet hikisuutomodorichi2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1></h1>");
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
