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
abstract class Human {
    public abstract int open();
    public abstract void setCards(ArrayList<Integer>Cards);            
    public abstract boolean checkSum();
    ArrayList<Integer> myCards = new ArrayList<Integer>();
}

