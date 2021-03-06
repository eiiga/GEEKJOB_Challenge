package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class UpdateResult extends HttpServlet {

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
            
//            UserDataBeansに格納
            UserDataBeans udbs = new UserDataBeans();
            String userID = request.getParameter("userID");
            int ID = Integer.parseInt(userID);
            udbs.setUserID(ID);
            udbs.setName(request.getParameter("name"));
            udbs.setYear(request.getParameter("year"));
            udbs.setMonth(request.getParameter("month"));
            udbs.setDay(request.getParameter("day"));
            udbs.setType(request.getParameter("type"));
            udbs.setTell(request.getParameter("tell"));
            udbs.setComment(request.getParameter("comment"));

            
            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO userdataup = new UserDataDTO();
            udbs.UD2DTOMapping(userdataup);
            
            //DBへデータの挿入
            UserDataDAO .getInstance().update(userdataup);
            
            request.setAttribute("udbs", udbs);
            request.getRequestDispatcher("/updateresult.jsp").forward(request, response);
            
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        } finally {
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
