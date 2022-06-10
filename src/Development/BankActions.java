/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Development;

import java.util.ArrayList;

/**
 *
 * @author michaelcalbay
 */
public interface BankActions {
    
    public void printLogo();
    public void printPrompt();
    public void showOptions();
    public void printGoodBye();
    public ArrayList<BankAccount> listAccounts();
    public BankAccount getAccount(String firstName, String lastName);
}
