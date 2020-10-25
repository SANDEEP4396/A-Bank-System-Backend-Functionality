/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Sandeep_Sagar_Muralidhar
 */
public class OnlineAccount {
    
    //attributes
    private String ssn;
    private String id;
    private String psw;
    private String name;
    
    private DataStorage data;
    
    //we are coming back
    //a set of bank accounts
    private ArrayList<BankAccount> bankAccounts
            = new ArrayList<BankAccount>();
    private ArrayList<CreditCard> creditCards
            = new ArrayList<CreditCard>();
    
    //constructor
    public OnlineAccount(String i, String p)
    {
        id = i;
        psw = p;
    }
    
    //display the welcome msg and options 
    public void welcome()
    {
        System.out.println();
        System.out.println("Hello " + id + 
                ", welcome to your online account");
        
        
        Scanner input = new Scanner(System.in);
        String selection = "";
        
        ArrayList<Product> lists = data.getProductAccounts(ssn);
        
        System.out.println(lists.size());
        
        for(Product each: lists)
        {
            if(each instanceof BankAccount)
            {
                bankAccounts.add((BankAccount)each);
            }
            else if(each instanceof CreditCard)
            {
                creditCards.add((CreditCard)each);
            }
            
        }
        
        while(!selection.equals("x"))
        {
            //welcome msg
            System.out.println("\n***Welcome to your online account***");
            //options
            System.out.println("Please select your options");
            //first of all, display all bank accounts numbers
             
            for(int i=0; i<bankAccounts.size(); i++)
            {
                System.out.printf("%s: select Account %s to view\n", i+1, 
                        bankAccounts.get(i).getAccountNumber());
            }
            
            for(int i=0; i<creditCards.size(); i++)
            {
                System.out.printf("%s: select Account %s to view\n", 
                        i+1+bankAccounts.size(), 
                        creditCards.get(i).getAccountNumber());
            }
            //other options
            System.out.println("s: Reset your password");
            System.out.println("t: Account Transfer");
            System.out.println("x: sign out\n");
            
            //after display the menu, we ask the user to input selection
            selection = input.next();
            
            if(selection.equals("s"))
            {
                //reset password
            }
            else if(selection.equals("t"))
            {
                //account transfer
                transfer();
            }
            else if(isInteger(selection))
            {
                //we convert the selection into an integer
                int intSelection = Integer.parseInt(selection);
                //make sure the selection is in a good range
                if(intSelection >= 1 && 
                        intSelection<=bankAccounts.size() + creditCards.size())
                {
                    //now view the statement
                    if(intSelection <= bankAccounts.size())
                    {
                        bankAccounts.get(intSelection-1).showStatement();
                    }
                    else
                    {
                        creditCards.get(intSelection-1-bankAccounts.size()).
                                showStatement();
                    }
                     
                }
            }
        }
        
    }
    
    //do account transfer
    public void transfer()
    {
        //varaibles
        Scanner input = new Scanner(System.in);
        String accountFrom, accountTo;
        double transferAmount;
        
        //make sure it has more than two bank accounts
        if(bankAccounts.size()>= 2)
        {
            //good to go
            //list the bank accounts
            for(int i=0; i<bankAccounts.size(); i++)
            {
                System.out.printf("%s: select Account %s\n", i+1, 
                        bankAccounts.get(i).getAccountNumber());
            }
            
            //ask the user to enter accountFrom & accountTo
            System.out.println("Please select the account from");
            accountFrom = input.next();
            
            System.out.println("Please select account to");
            accountTo = input.next();
            
            System.out.println("Please indicate the amount of transfer");
            transferAmount = input.nextDouble();
            
            //validate the input
            if(isInteger(accountFrom) && isInteger(accountTo))
            {
                //good to go
                int intFrom = Integer.parseInt(accountFrom);
                int intTo = Integer.parseInt(accountTo);
                
                //in a good range?
                if(intFrom >=1 && intFrom <= bankAccounts.size()
                        && intTo>=1 && intTo <= bankAccounts.size()
                        && intFrom != intTo)
                {
                    //good to go to check balance
                    if(bankAccounts.get(intFrom-1).getBalance() 
                            >= transferAmount)
                    {
                        //good to go to do the transfer
                     bankAccounts.get(intFrom-1).withdraw(transferAmount);
                        bankAccounts.get(intTo-1).deposit(transferAmount);
                        System.out.println("The transfer is successful!\n");
                    }
                    else
                    {
                        System.out.println("You do not have enough "
                                + "money to do the "
                                + "transfer");
                    }
                }
                else
                {
                    System.out.println("Please use correct input");
                }
            }
            else
            {
                System.out.println("Please use the correct input\n");
            }
        }
        else
        {
            System.out.println("You must have two bank "
                    + "accounts to do the transfer\n");
        }
        
    }
   
   
    public void resetPassword()
    {
        //varaibles
        Scanner input = new Scanner(System.in);
        String old, new1, new2;
        
        System.out.println("Please enter your current password");
        old = input.next();
        
        System.out.println("Please enter your new password");
        new1 = input.next();
        
        System.out.println("Please confirm your new password");
        new2 = input.next();
        
        //check the current password
        if(old.equals(psw))
        {
            //good to go to check new psw
            if(new1.equals(new2))
            {
                //good to go to change it
                psw = new1;
            }
            else
            {
                System.out.println("The new passwords did not match!\n");
            }
        }
        else
        {
            System.out.println("Your password is not correct!\n");
        }
        
    }
    
    //get methods and set methods
    public String getSsn() {
        return ssn;
    }

     

    public String getId() {
        return id;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataStorage getData() {
        return data;
    }

    public void setData(DataStorage data) {
        this.data = data;
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(ArrayList<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public ArrayList<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(ArrayList<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    
    
    //to determine whether a is an integer
    private boolean isInteger(String a)
    {
        try
        {
            //if a is not an integer, an exception will be thrown out
            int i = Integer.parseInt(a);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    
}


 