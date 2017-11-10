/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;



/**
 *
 * @author ei-tk
 */
public class UserData {

private int userID = 0;    
private String name = "";
private String pass = "";
private String email = "";
private String address = "";
private int total = 0;


public int getUserID(){
    return userID;
}
public void setUserID(int userID){
    this.userID = userID;
}
        
        
public String getName(){
    return name;
}
public void setName(String name){
    this.name = name;
}

public String getPass(){
    return pass;
}
public void setPass(String pass){
    this.pass = pass;
}
    
public String getEmail(){
    return email;
}
public void setEmail(String email){
    this.email = email;
}

public String getAddress(){
    return address;
}
public void setAddress(String address){
    this.address = address;
}

public int getTotal(){
    return total;
}
public void setTotal(int total){
    this.total = total;
}

}
