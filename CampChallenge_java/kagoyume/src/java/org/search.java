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
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.arnx.jsonic.JSON;


/**
 *
 * @author ei-tk
 */
public class search extends HttpServlet {

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
        String result = "";
        PrintWriter out = response.getWriter();
        try  {
            
            request.setCharacterEncoding("UTF-8");
            String word = request.getParameter("search");
            String search = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?appid=dj00aiZpPVphYWdUWE1SZlc3byZzPWNvbnN1bWVyc2VjcmV0Jng9NDY-&query=" ;
            String wordurl = URLEncoder.encode(word, "UTF-8");
            
            String searchword = search += wordurl;
            
            
            URL url = new URL(searchword);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String tmp = "";
            while((tmp = in.readLine()) != null){
                result += tmp;
                
            }

            ArrayList<SearchData> sd = new ArrayList();
            SearchData searchdata = new SearchData();
            
            for(int i = 0; i < 20; i++){
            
            String num = String.valueOf(i);
            
            Map jsonRoot = (Map)JSON.decode(result);
            Map resultSet = (Map)jsonRoot.get("ResultSet");
                String totalsearch = (String)resultSet.get("totalResultsAvailable");
            Map result0 = (Map)resultSet.get("0");
            Map Result = (Map)result0.get("Result");
            Map resultnum = (Map)Result.get(num);
                String code = (String)resultnum.get("Code");
                String name = (String)resultnum.get("Name");
            Map Image = (Map)resultnum.get("Image");
                String img = (String)Image.get("Medium");
            Map price = (Map)resultnum.get("Price");
                String yen = (String)price.get("_value");
            
            searchdata.setTotalsearch(totalsearch);
            searchdata.setCode(code);
            searchdata.setName(name);
            searchdata.setImage(img);
            searchdata.setYen(yen);
            sd.add(searchdata);
            searchdata = new SearchData();
           }
            
            searchdata.setSd(sd);
            searchdata.setWord(word);
            
            session.setAttribute("Data", sd);
            request.setAttribute("word", searchdata);
            
            in.close();
            con.disconnect();
            
            
            
            RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
            rd.forward(request, response);
            
            }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセス
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            }finally {
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
