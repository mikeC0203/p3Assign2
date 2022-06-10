/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Development;

import java.text.NumberFormat;

/**
 *
 * @author michaelcalbay
 */
public class GoAccount {
    private String type;
    private double balance;
    
    GoAccount()
    {
        this.type = "Go Account";
        this.balance = 0.0;
    }
    
    
    @Override
    public String toString()
    {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        
        return this.type+": "+format.format(this.balance);
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}
