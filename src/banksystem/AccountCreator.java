/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Sandeep_Sagar_Muralidhar
 */
public class AccountCreator {
    
    //private static DataStorage a = new SQL_Database();
    
    private DataStorage data;
    
    public AccountCreator(DataStorage d)
    {
        data = d;
    }
    
    public void createBankAccount()
    {
        String ssn, name;
        double balance;
        Scanner input = new Scanner(System.in);
        
        //prompt and input
        System.out.println("Please enter your name: ");
        name = input.nextLine();
        
        System.out.println("Please enter the SSN:");
        ssn = input.nextLine();
        
        System.out.println("Please enter the initial balance:");
        balance = input.nextDouble();
        
        //save to data storeage
        data.createBankAccount(name, ssn, balance);
    }
    
    public void createCreditAccount()
    {
        String ssn, name;
        double creditLine;
        double balance = 0;
        Scanner input = new Scanner(System.in);
        
        //prompt and input
        System.out.println("Please enter your name: ");
        name = input.nextLine();
        
        System.out.println("Please enter the SSN:");
        ssn = input.nextLine();
        
        System.out.println("Please enter the creditLine:");
        creditLine = input.nextDouble();
        
        data.createCreditAccount(name, ssn, creditLine);
    }
    
    public void createOnlineAccount()
    {
        String ssn, name, loginID, password;
        
        Scanner input = new Scanner(System.in);
        
        //prompt and input
        System.out.println("Please enter your name: ");
        name = input.nextLine();
        
        System.out.println("Please enter the SSN:");
        ssn = input.nextLine();
        
        System.out.println("Please enter the login ID:");
        loginID = input.nextLine();
        
        System.out.println("Please enter your password: ");
        password = input.nextLine();
        
        data.createOnlineAccount(name, ssn, loginID, password);
    }
    
}
