/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.arnx.jsonic.JSON;

/**
 *
 * @author ei-tk
 */
public class MyHistory extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {

           request.setCharacterEncoding("UTF-8");
           int id = Integer.parseInt(request.getParameter("userid"));
           
           UserDataDTO buycon = new UserDataDTO();
           buycon.setUserID(id);
           
          ArrayList<UserDataDTO> buyconfirm = UserDataDAO .getInstance().searchByIDtobuyconfirm(buycon);
          
          SearchData buydata = new SearchData();
          ArrayList<SearchData> buy = new ArrayList<SearchData>();
          
           for(int i = 0; i < buyconfirm.size(); i++){
                    String itemcode = buyconfirm.get(i).getItem();
                    String result = "";
                    
                    
            String detail = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup?appid=dj00aiZpPVphYWdUWE1SZlc3byZzPWNvbnN1bWVyc2VjcmV0Jng9NDY-&responsegroup=medium&itemcode=" ;
            String detaildata = detail += itemcode;
            
            URL url = new URL(detaildata);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String tmp = "";
            while((tmp = in.readLine()) != null){
                result += tmp;
                
            }
            
            
            Map jsonRoot = (Map)JSON.decode(result);
            Map resultSet = (Map)jsonRoot.get("ResultSet");
            Map result0 = (Map)resultSet.get("0");
            Map Result = (Map)result0.get("Result");
            Map result0no0 = (Map)Result.get("0");
                String code = (String)result0no0.get("Code");
                String name = (String)result0no0.get("Name"); 
            Map image = (Map)result0no0.get("Image");
                String medium = (String)image.get("Medium");
            Map price = (Map)result0no0.get("Price");
                String yen = (String)price.get("_value");

                buydata.setName(name);
                buydata.setYen(yen);
                buydata.setImage(medium);
                buydata.setCode(code);
                buy.add(buydata);
                buydata = new SearchData();
                
                in.close();
                con.disconnect();
                
                } 
               buydata.setSd(buy); 
                
            request.setAttribute("buydata", buy);
          
          
            
          request.getRequestDispatcher("/myhistory.jsp").forward(request, response);
           
           
           
            
        }catch(Exception e){
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
