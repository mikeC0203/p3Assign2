/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Development;

/**
 *
 * @author michaelcalbay
 */
public interface CustActions {
    
    public void custActions();
    public void deposit(String accType, double amount);
    public void withdraw(String accType, double amount);
    public void transfer(BankAccount e, String accType, double amount);
    public void moveFunds(String fromAcc, String toAcc, double amount);
}
