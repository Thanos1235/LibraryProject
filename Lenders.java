/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libraryproject2;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.ArrayList;
import java.util.List;

public class Lenders {
    String username;
    Boolean lendedbook;

    public Lenders(String username, Boolean lendedbook) {
        this.username = username;
        this.lendedbook = lendedbook;
    }

    public String getUsername() {
        return username;
    }

    public Boolean getLendedbook() {
        return lendedbook;
    }

    public void setLendedbook(Boolean lendedbook) {
        this.lendedbook = lendedbook;
    }
    
    static Lenders user1 = new Lenders("user1", TRUE);
    static Lenders user2 = new Lenders("user2", FALSE);
    static List <Lenders> lenders = new ArrayList<>();
    
    public static void setUpLenders(){
        lenders.add(user1);
        lenders.add(user2);
    }
    
    public static Boolean checkUsername(String username){
        Boolean res = FALSE;
        for(Lenders target: lenders){
            if(target.getUsername().equals(username)){
                res = TRUE;
            }else{
                res = FALSE;
            }
        }
        return res;
    }
    
    public static Boolean checkIfLended(String username){
        Boolean res = TRUE;
        for(Lenders target: lenders){
            if(target.getUsername().equals(username)){
                if(!target.getLendedbook()){
                    res = FALSE;
                }
            }
        }
        return res;
    }
    
    public static void lendBook(String username){
        int i = 0;
        for(Lenders target: lenders){
            if(target.getUsername().equals(username)){
                target.setLendedbook(TRUE);
                lenders.set(i, target);
            }
            i++;
        }
    }
    
    public static void returnBook(String username){
        int i = 0;
        for(Lenders target: lenders){
            if(target.getUsername().equals(username)){
                target.setLendedbook(FALSE);
                lenders.set(i, target);
            }    
            i++;
        }
    }
}