/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libraryproject2;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.ArrayList;
import java.util.List;

public class Books {
    String name;

    public Books(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    static Books bookc = new Books("bookc");
    static Books bookb = new Books("bookb");
    static Books book0 = new Books("book0");
    static List <Books> books = new ArrayList<>();
    
    public static void setUpBooks(){
        books.add(bookb);
        books.add(bookc);
        books.add(book0);
    }
    
    public static Boolean checkBookname(String bookname){
        Boolean res = FALSE;
        for(Books target: books){
            if(target.getName().equals(bookname)){
                res = TRUE;
            }else{
                res = FALSE;
            }
        }
        return res;
    }
}