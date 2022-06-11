/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Development;


/**
 *
 * 20888496 - CALBAY
 * https://github.com/mikeC0203/p3Assign2 - GITHUB REPO
 */
public class BankAccount extends MCBank implements CustActions {
    
    private Person customer;
    private GoAccount goBalance;
    private SavingsAccount savBalance;
    
    BankAccount(String firstName, String lastName)
    {
        this.customer = new Person(firstName, lastName);
        this.goBalance = new GoAccount();
        this.savBalance = new SavingsAccount();
    }
    
    //Show customer actions option
    @Override
    public void custActions()
    {   
        System.out.println("");
        System.out.println("Press 1: WITHDRAW");
        System.out.println("Press 2: DEPOSIT");
        System.out.println("Press 3: MOVE FUNDS");
        System.out.println("Press 4: SEND PAYMENT");
        System.out.println("Press 5: SHOW ACCOUNT DETAILS");
        System.out.println("-----------------------------");
        System.out.println("Press X: TO LOGOUT!");
        System.out.println("");
    }
    
    //Deposit to an account if amount is greater than 0.
    @Override
    public void deposit(String accType, double amount)
    {
        if(amount > 0)
        {
            if(accType.equalsIgnoreCase("Go"))
            {
                this.getGoBalance().setBalance(this.getGoBalance().getBalance()+amount);
            }
            else if(accType.equalsIgnoreCase("Savings"))
            {
                this.getSavBalance().setBalance(this.getSavBalance().getBalance()+amount);
            }
            else
            {
                System.out.println("Account does not exist!");
            }
        }
    }
    
    //Withdraw to an account if amount is less than account's balance
    @Override
    public void withdraw(String accType, double amount)
    {
        if(accType.equalsIgnoreCase("Go"))
        {
            if(amount <= this.getGoBalance().getBalance() && amount > 0)
            {
                this.getGoBalance().setBalance(this.getGoBalance().getBalance()-amount);
            }
        }
        else if(accType.equalsIgnoreCase("Savings"))
        {
            if(amount <= this.getSavBalance().getBalance() && amount > 0);
            {
                this.getSavBalance().setBalance(this.getSavBalance().getBalance()-amount);
            }
        }
        else
        {
            System.out.println("Account does not exist!");
        }
    }
    
    //Transfer from one account to another, from & to a specific account type.
    //IF and ONLY IF account's balance is greater than the amount.
    @Override
    public void transfer(BankAccount e, String accType, double amount)
    {
        if(e != null)
        {   
            switch (accType.toUpperCase())
            {
                case "GO":
                    if(this.getGoBalance().getBalance() >= amount && amount > 0)
                    {
                        this.withdraw(accType, amount);
                        e.deposit("Go", amount);
                    }

                    break;
                case "SAVINGS":
                    if(this.getSavBalance().getBalance() >= amount && amount > 0)
                    {
                        this.withdraw(accType, amount);
                        e.deposit("Go", amount);
                    }    
                    
                    break;
                
                default:
                    System.out.println("Account does not exist!");
                
                break;
            }
        }
        else
        {
            System.out.println("Account does not exist!");
            System.out.println("Don't worry, we did not charge your account.");
        }
    }
    
    
    //Transfers funds locally. From one account to another.
    //IF and ONLY IF account balance it's coming from is greater than amount.
    @Override
    public void moveFunds(String fromAcc, String toAcc, double amount)
    {
        switch(fromAcc.toLowerCase())
        {
            case "go":
                if(this.getGoBalance().getBalance() >= amount && amount > 0)
                {
                    this.withdraw(fromAcc, amount);
                    this.deposit(toAcc, amount);
                }
                
                break;
            case "savings":
                if(this.getSavBalance().getBalance() >= amount && amount > 0)
                {
                    this.withdraw(fromAcc, amount);
                    this.deposit(toAcc, amount);
                }
                
                break;
            default:
                System.out.println("Account does not exist!");
                
                break;
                
        }
    }  
    
    
    //Java Built-in Methods Override--------------------------------------------
    @Override
    public boolean equals(Object o)
    {
        return o != null && o instanceof BankAccount
                && ((BankAccount) o).getCustomer().getFirstName().equalsIgnoreCase(this.getCustomer().getFirstName())
                && ((BankAccount) o).getCustomer().getLastName().equalsIgnoreCase(this.getCustomer().getLastName());
        
    }
       
    @Override
    public String toString()
    {   
        return "First Name: "+this.customer.getFirstName()+"\n"
                +"Last Name: "+this.customer.getLastName()+"\n\n"
                +this.getGoBalance()+"\n"
                +this.getSavBalance()+"\n"
                +"-----------------------------------------";
    }

    /**
     * @return the customer
     */
    public Person getCustomer() {
        return customer;
    }

    /**
     * @return the goBalance
     */
    public GoAccount getGoBalance() {
        return goBalance;
    }

    /**
     * @return the savBalance
     */
    public SavingsAccount getSavBalance() {
        return savBalance;
    }
    
}