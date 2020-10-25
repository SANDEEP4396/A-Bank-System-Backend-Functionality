/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

import java.util.ArrayList;

/**
 *
 * @author Sandeep_Sagar_Muralidhar
 */
public interface DataStorage {
    
    void createBankAccount(String name, String ssn, double balance);
    void createCreditAccount(String name, String ssn, double creditLine);
    void createOnlineAccount(String name, String ssn, String id, String psw);
    String login(String id, String password);
    ArrayList<Product> getProductAccounts(String ssn);
    void updateBalance(String accountNumber, double balance, String statement);
    String getSsnByID(String i);
    //ArrayList<BankAccount> getBankAccounts(String ssn);
    //ArrayList<CreditCard> getCreditCardAccounts(String ssn);  
}
