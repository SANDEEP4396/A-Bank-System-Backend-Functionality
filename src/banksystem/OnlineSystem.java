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
import java.util.Scanner;

/**
 *
 * @author Sandeep_sagar_Muralidhar
 */
public class OnlineSystem {
    
    //attribute
    private OnlineAccount theLoginAccount;
    private DataStorage data;
    
    //constructor
    public OnlineSystem(DataStorage d)
    {
        //at the biginning, there is no login account
        theLoginAccount = null;
        data = d;
    }
    
    public void showMainPage()
    {
        //declare varaibles
        Scanner input = new Scanner(System.in);
        String selection = "";
        
        while(!selection.equals("x"))
        {
            //display the menu
            System.out.println("Welcome to UHCL bank");
            System.out.println("Please make your selection");
            System.out.println("1: Create a new online ID");
            System.out.println("2: Login your online account");
            System.out.println("x: Finish the simulation");
            
            //get the selection from the user
            selection = input.nextLine();
            System.out.println();
            
            if(selection.equals("1"))
            {
                //register
                register();
                 
            }
            else if(selection.equals("2"))
            {
                //login
                login();
            }
        }
    }
    
    //register method
    public void register()
    {
        //declare varaibles
        String name, ssn, accountID, password;
        Scanner input = new Scanner(System.in);
        
        //prompts and input
        System.out.println("Please enter your name");
        name = input.nextLine();
        
        System.out.println("Please enter your ssn");
        ssn = input.nextLine();
        
        System.out.println("Please enter your new ID");
        accountID = input.nextLine();
        
        System.out.println("Please enter your password");
        password = input.nextLine();
        
        data.createOnlineAccount(name, ssn, accountID, password); 
    }
    
    public void login()
    {
        //we need id and password
        Scanner input = new Scanner(System.in);
        String id="";
        String password="";
         
        
        //get the login info.
        System.out.println("Please enter your ID");
        id = input.next();
        System.out.println("Please enter your password");
        password = input.next();
        
        String res = data.login(id, password);
        if(res.equals("success"))
        {
            theLoginAccount = new OnlineAccount(id, password);
            theLoginAccount.setData(data);
            String userSsn = data.getSsnByID(id);
            theLoginAccount.setSsn(userSsn);
            theLoginAccount.welcome();
        }
        else
        {
            System.out.println("The login failed");
        }
        
    }
    
}
