/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

/**
 *
 * @author Sandeep_Sagar_Muralidhar
 */
public class CreditCard extends Product{
   
     
    private double balance;
    private double creditLine;
    private String accountNumber;
    
    public CreditCard(String n, String s, double b, double c, String a)
    {
        super(n, s, "Credit Card");
        balance = b;
        creditLine = c; 
        accountNumber = a;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        this.creditLine = creditLine;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }   

    @Override
    public void showStatement()
    {
        
    }
}
