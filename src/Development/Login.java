/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Development;


/**
 *
 * @author michaelcalbay
 */
public interface Login {
    
    public void createAccount(String user, String password, String firstName, String lastName);
    public BankAccount login(String user, String password);
    public boolean loginCorrect(String user, String password);
    
}
