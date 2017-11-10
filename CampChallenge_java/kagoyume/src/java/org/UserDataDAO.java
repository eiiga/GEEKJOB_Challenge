/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author ei-tk
 */
public class UserDataDAO {
    
        //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insertuser(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name, password, mail, address, total, newDate, deleteFlg) VALUES(?,?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());
            st.setInt(5, 0);
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7, 0);
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    
    
    
        public UserDataDTO login(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("select * from user_t where name = ? and password = ? and deleteFlg = ?");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            st.setInt(3, 0);
            ResultSet rs = st.executeQuery();
            
            UserDataDTO uddto = new UserDataDTO();
            
            while(rs.next()){
                uddto.setUserID(rs.getInt(1));
                uddto.setName(rs.getString(2));
                uddto.setPassword(rs.getString(3));
                uddto.setMail(rs.getString(4));
                uddto.setAddress(rs.getString(5));
                uddto.setTotal(rs.getInt(6));
                uddto.setNewDate(rs.getTimestamp(7));
                uddto.setDeleteFlg(rs.getInt(8));
            }            
            System.out.println("insert completed");
            
            return uddto;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
        
        public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE UserID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setPassword(rs.getString(3));
            resultUd.setMail(rs.getString(4));
            resultUd.setAddress(rs.getString(5));
            resultUd.setTotal(rs.getInt(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            resultUd.setDeleteFlg(rs.getInt(8));
            
            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
        
     public void update(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE user_t SET name = ?, password = ?, mail = ?, address = ?, newDate = ? WHERE UserID = ?");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            st.setInt(6,ud.getUserID());
            st.executeUpdate();

            
            System.out.println("update completed");

         
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
        
     }
        
             public void delete(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE user_t SET deleteFlg = ? WHERE UserID = ?");
            st.setInt(1, 1);
            st.setInt(2,ud.getUserID());
            st.executeUpdate();

            
            System.out.println("delete completed");

         
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
        
    }    
        
       public void insertbuy(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO buy_t(UserID, item, type, buyDate) VALUES(?,?,?,?)");
            st.setInt(1, ud.getUserID());
            st.setString(2, ud.getItem());
            st.setInt(3, ud.getType());
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }     
     public void updatetotal(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE user_t SET total = total + ? WHERE UserID = ?");
            st.setInt(1, ud.getTotal());
            st.setInt(2,ud.getUserID());
            st.executeUpdate();

            
            System.out.println("update completed");

         
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
     } 
       
            public ArrayList<UserDataDTO> searchByIDtobuyconfirm(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM buy_t WHERE UserID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            UserDataDTO resultUd = new UserDataDTO();
            ArrayList<UserDataDTO> buyconfirm = new ArrayList<UserDataDTO>();
           
            while(rs.next()){
                resultUd.setBuyID(rs.getInt(1));
                resultUd.setUserID(rs.getInt(2));
                resultUd.setItem(rs.getString(3));
                resultUd.setType(rs.getInt(4));
                resultUd.setNewDate(rs.getTimestamp(5));
                buyconfirm.add(resultUd);
                resultUd = new UserDataDTO();
            }
            System.out.println("searchByID completed");

            return buyconfirm;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
}
