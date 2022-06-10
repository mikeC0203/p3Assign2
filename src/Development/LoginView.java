/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Development;

/**
 *
 * @author micha
 */
public class LoginView {
    public static void main(String[] args) {
        MCBank bank = new MCBank();
        
        LoginFormV2 loginForm = new LoginFormV2(bank);
        loginForm.setVisible(true);
        loginForm.setLocationRelativeTo(null);
    }
}
