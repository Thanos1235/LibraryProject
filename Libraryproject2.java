/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.libraryproject2;

import static java.lang.Boolean.TRUE;
import java.util.Scanner;

public class Libraryproject2 {

    public static void main(String[] args) {
        Lenders.setUpLenders();
        Books.setUpBooks();
        System.out.print("Welcome to our Lending Library!\nDo you wish to:\n1: Lend a book?\n2: Return a book?\n");
        
        Scanner scanner = new Scanner(System.in);
        int choiceInt = 0;
        do{
            choiceInt = scanner.nextInt();
            if(choiceInt < 1 || choiceInt > 2){
                System.out.print("Incorrect input. Please try again.\n");
            }else{
                System.out.print("Please type your Username:\n");
                String username = scanner.next();
                Boolean check = TRUE;
                do{
                  check = Lenders.checkUsername(username);
                  if(!check){
                      System.out.print("Incorrect input. Please type your Username again:\n");
                      username = scanner.next();
                  }
                }while(!check);
                
                Boolean checkIfLended = Lenders.checkIfLended(username);
                if(checkIfLended){
                    System.out.println("You already have lended a book. Please return your book first before you can lend another.");
                    break;
                }else{
                    //edw
                    if(choiceInt == 1){
                        //lend
                        System.out.print("Please type your desired book's title:\n");
                        String bookname = scanner.next();
                        Boolean checkbook= TRUE;
                        do{
                            checkbook = Books.checkBookname(bookname);
                            if(!checkbook){
                                System.out.print("This book is not registered in our Library. Please type a registered book' title:\n");
                                bookname = scanner.next();
                            }
                        }while(!checkbook);
                        Lenders.lendBook(username);
                    }else{
                        //return
                        System.out.print("Please type your returning book's title:\n");
                        String bookname = scanner.next();
                        Boolean checkbook= TRUE;
                        do{
                            checkbook = Books.checkBookname(bookname);
                            if(!checkbook){
                                System.out.print("This book is not registered in our Library. Please type a registered book's title:\n");
                                bookname = scanner.next();
                            }
                        }while(!checkbook);
                        Lenders.returnBook(username);
                    }
                    //edw
                }
            }
        }while(choiceInt <1 || choiceInt > 2);
        System.out.println("Thank you for using our Lending Library! See you again!");
    }
}