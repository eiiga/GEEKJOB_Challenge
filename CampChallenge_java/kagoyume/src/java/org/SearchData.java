/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;

import java.util.ArrayList;

/**
 *
 * @author ei-tk
 */
public class SearchData {
    private String code;
    private String Name;
    private String yen;
    private String description;
    private String headline;
    private String image;
    private ArrayList<SearchData> sd = new ArrayList<SearchData>();
    private ArrayList<String> item = new ArrayList<String>();
    private String word;
    private String totalsearch;
    
    
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
    
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
 
    public String getYen(){
        return yen;
    }
    public void setYen(String yen){
        this.yen = yen;
    }
    
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getHeadline(){
        return headline;
    }
    public void setHeadline(String headline){
        this.headline = headline;
    }
    
    public String getImage(){
        return image;
    }
    public void setImage(String image){
        this.image = image;
    }
    
    public ArrayList<SearchData> getSd(){
    return sd;
}
    public void setSd(ArrayList<SearchData> sd){
        this.sd = sd;
    }
    
    public ArrayList<String> getItem(){
        return item;
    }
    public void setItem(ArrayList<String> item){
        this.item = item;
    }
    
    public String getWord(){
        return word;
    }
    public void setWord(String word){
        this.word = word;
    }
    
    public String getTotalsearch(){
        return totalsearch;
    }
    public void setTotalsearch(String totalsearch){
        this.totalsearch = totalsearch;
    }
    
}
