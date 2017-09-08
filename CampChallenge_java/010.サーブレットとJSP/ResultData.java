package org.camp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author ei-tk
 */
public class ResultData  implements Serializable{
    private Date d;
    private String luck;
    
    public ResultData(){}

    /**
     * @return 
     * @ return the d
     * 
     */

    public Date getD(){
        return d;
    }
    
    /**
     * @param d the d to set
     */
    public void setD(Date d){
        this.d = d;
    }
    
    /**
     * @return the luck
     */
    public String getLuck(){
        return luck;
    }
    public void setLuck(String luck){
        this.luck = luck;
        
    }
}
