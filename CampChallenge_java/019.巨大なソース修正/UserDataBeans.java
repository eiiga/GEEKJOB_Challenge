/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserDataBeans;

import java.sql.Timestamp;


/**
 *
 * @author ei-tk
 */
public class UserDataBeans {
    private int userID;
    private String name;
    private String year;
    private String month;
    private String day;
    private String tell;
    private String type;
    private String comment;
    private Timestamp newDate;
    private String confirmcheck;
    
    
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getYear(){
        return year;
    }
    public void setYear(String year){
        this.year = year;
    }

    public String getMonth(){
        return month;
    }
    public void setMonth(String month){
        this.month = month;
    }    

    public String getDay(){
        return day;
    }
    public void setDay(String day){
        this.day = day;
    }
    
    public String getTell(){
        return tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
    public Timestamp getNewDate() {
        return newDate;
    }
    public void setNewDate(Timestamp newDate) {
        this.newDate = newDate;
    }
    
        public String getConfirmcheck(){
        return confirmcheck;
    }
    public void setConfirmcheck(String confirmcheck){
        this.confirmcheck = confirmcheck;
    
    }

    public void setConfirmcheck(StringBuilder confirmcheck) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
