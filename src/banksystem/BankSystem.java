/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

import java.util.Scanner;

/**
 *
 * @author LinJian
 */
public class BankSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //DataStorage data = new SQL_Database();
        //suppose later on the management decides to use Cloud to store data
        //Do we have to change the source code in the business logic a lot?
        
        DataStorage data = new SQL_Database();
        Scanner input = new Scanner(System.in);
        String selection = "";
         
        
        while(!selection.equals("x"))
        {
            //display the menu
            System.out.println("Please make your selection");
            System.out.println("1: Open a new bank account");
            System.out.println("2: Open a credit card account");
            System.out.println("3: Go to online system");
            System.out.println("x: Finish the simulation");
            
            //get the selection from the user
            selection = input.nextLine();
            System.out.println();
            
            if(selection.equals("1"))
            {
                //open a new bank account
                new AccountCreator(data).createBankAccount();
            }
            else if(selection.equals("2"))
            {
                //open a new credit card account
                new AccountCreator(data).createCreditAccount();   
            }
            else if(selection.equals("3"))
            {
                new OnlineSystem(data).showMainPage();
            }
        }
    }
    
}
