/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Development;

/**
 *
 * 20888496 - CALBAY
 * https://github.com/mikeC0203/p3Assign2 - GITHUB REPO
 * 
 * PLEASE RUN THIS TO USE THE APP
 */
public class AppMainView {
    public static void main(String[] args) {
        MCBank bank = new MCBank();
        
        LoginFormV2 loginForm = new LoginFormV2(bank);
        loginForm.setVisible(true);
        loginForm.setLocationRelativeTo(null);
    }
}
