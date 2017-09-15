/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.util.ArrayList;

/**
 *
 * @author ei-tk
 */
public class User extends Human {

   
    @Override
    public int open() {
         int sum = 0;
         for(int primary : myCards){
             sum = sum + primary;
         }
         return sum; 
    }
    @Override
    public void setCards(ArrayList<Integer> Cards) {
        for (int value : Cards){
           myCards.add(value);
        }
    }

    @Override
    public boolean checkSum() {
        int sum = 0;
         for(int primary : myCards){
             sum = sum + primary;
         }
         if(sum < 18){
             return true;
         }else{
             return false;
         }
    }
    
    
}
