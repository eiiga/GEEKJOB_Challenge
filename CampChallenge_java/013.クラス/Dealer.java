/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ei-tk
 */
public class Dealer extends Human{
    
    ArrayList<Integer> cards = new ArrayList<Integer>();
   public  void trump(){
        for(int i = 1;i < 53;i++ ){
            int x = i % 13 + 1;
               if(x>10){
                x=10;
            }
            cards.add(x);
        }
    }
   public ArrayList<Integer> deal(){
        Random rand1 = new Random();
        int num1 = rand1.nextInt(cards.size());
        int card1 = cards.get(num1);
        cards.remove(num1);
        int num2 = rand1.nextInt(cards.size());
        int card2 = cards.get(num2);
        cards.remove(num2);
        ArrayList<Integer> dealercards1 = new ArrayList<Integer>();
        dealercards1.add(card1);
        dealercards1.add(card2);
        return dealercards1;
    }
   public ArrayList<Integer> hit(){
        Random rand2 = new Random();
        int num2 = rand2.nextInt(cards.size());
        int card3 = cards.get(num2);
        cards.remove(num2);
        ArrayList<Integer> dealercards2 = new ArrayList<Integer>();
        dealercards2.add(card3);
        return dealercards2;
   }
    @Override
   public void setCards(ArrayList<Integer>Cards){
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
    @Override
    public int open() {
        int sum = 0;
         for(int primary : myCards){
             sum = sum + primary;
         }
        return sum; 
    }

}    