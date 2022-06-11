/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Development;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author michaelcalbay
 */
public class MCBank implements BankActions,Login{
    //Instance Variable Containing list of Accounts
    private ArrayList<BankAccount> accounts;
    private HashMap<String, BankAccount> accountMap;
    private HashMap<String, String> accDetailMap;
    private BankAccount currentAccount;
    public boolean loggedIn;
    
    MCBank()
    {
        this.accounts = new ArrayList<>();
        this.accountMap = new HashMap<>();
        this.accDetailMap = new HashMap<>();
    }
    
    //Prints Bank App Logo
    @Override
    public void printLogo()
    {
        System.out.println("*========================*");
        System.out.println("*     ONLINE BANKING*    *");
        System.out.println("*========================*");
    }
    
    //Initial Prompt asking user to login or register
    @Override
    public void printPrompt()
    {
        System.out.println("");
        System.out.println("-----------------------------------------");
        System.out.println("| Please Login or Register to continue. |");
        System.out.println("-----------------------------------------");
    }
    //Shows user function options
    @Override
    public void showOptions()
    {
        System.out.println("");
        System.out.println("Press: ");
        System.out.println("1. Login to an existing Account");
        System.out.println("2. Create an Account");
        System.out.println("-------------------------------");
        System.out.println("Press X: EXIT");
        
        System.out.print("\nEnter Choice: ");
        System.out.println("");
    }
    
    //Print goodbye!
    @Override
    public void printGoodBye()
    {
        System.out.println("\nThank you for using our Online Banking System.\n");
        System.out.println("*=============*");
        System.out.println("*   GOODBYE   *");
        System.out.println("*=============*");
    }
    
    //Create an account if Bank is Empty or account doesn't already exists
    @Override
    public void createAccount(String user, String password, String firstName, String lastName)
    {
        BankAccount newAccount = new BankAccount(firstName,lastName);
        
        if(this.accounts.isEmpty())
        {
            this.accounts.add(newAccount);
            this.accountMap.put(user, newAccount);
            this.getAccDetailMap().put(user, password);
        }
        else if(!(this.accounts.contains(newAccount)) && !(this.accDetailMap.containsKey(user)))
        {
            this.accounts.add(newAccount);
            this.accountMap.put(user, newAccount);
            this.getAccDetailMap().put(user, password);
        }
    }
    
    //Login to an account if user & password matches and points to a BankAccount
    @Override
    public BankAccount login(String user, String password)
    {
        if(loginCorrect(user, password))
        {
            if(this.accountMap.containsKey(user))
            {
                this.loggedIn = true;
                this.setCurrentAccount(this.accountMap.get(user));
                return this.accountMap.get(user);
            }
        }
        return null;
    }
    
    
    //Checks user and password if correct
    @Override
    public boolean loginCorrect(String user, String password)
    {
        return this.getAccDetailMap().containsKey(user) && this.getAccDetailMap().get(user).equals(password);
    }
    
    //Returns the list of accounts
    @Override
    public ArrayList<BankAccount> listAccounts()
    {
        return this.accounts;
    }
    
    //Returns the account with the first and last name input from user.
    @Override
    public BankAccount getAccount(String firstName, String lastName)
    {
        BankAccount c = new BankAccount(firstName, lastName);
        
        if(this.accounts.contains(c))
        {
            return this.accounts.get(this.accounts.indexOf(c));
        }
        
        return null;
    }
    
    //Returns the account with the userName
    public BankAccount getAccount(String userName) {
        return this.accountMap.get(userName);
    }
    
    //Returns an ArrayList of Usernames taken to prevent users from having the
    //same usernames
    public ArrayList<String> userNamesTaken(String userName)
    {
        ArrayList<String> userNames = new ArrayList<>();
        
        if(!this.accDetailMap.containsKey(userName))
        {
            userNames.add(userName);
        }
        
        return userNames;
    }
    
    //Saves all existing account into a text file
    //This includes USERNAME, PASSWORD, AND ACCOUNT BALANCES
    //This is mainly for ADMIN ACCESS ONLY
    public void saveAccounts()
    {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("./File_IO/admin_custList.txt"));
            
            for(BankAccount s : this.accounts)
            {   
                for(Entry<String, BankAccount> key : accountMap.entrySet())
                {
                    if(key.getValue() == s)
                    {
                        bw.write("Username: "+key.getKey());
                        bw.newLine();
                        bw.write("Password: "+this.getAccDetailMap().get(key.getKey()));
                        bw.newLine();
                    }
                }
                bw.write(s.toString()+"\n");
            }
            
            bw.close();
        }catch(IOException e){
            System.err.println("Error Found: "+e.getMessage());
        }
    }
    
    //Writes account details in raw values - With it's balances for account recreation.
    public void rawAccountDetails()
    {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("./File_IO/existing_accounts.txt"));
            
            for(BankAccount s : this.accounts)
            {
                for(Entry<String, BankAccount> key : accountMap.entrySet())
                {
                    if(key.getValue() == s)
                    {
                        bw.write(key.getKey()+"\n");
                        bw.write(this.getAccDetailMap().get(key.getKey())+"\n");
                    }
                }
                bw.write(s.getCustomer().getFirstName()+"\n");
                bw.write(s.getCustomer().getLastName()+"\n");
                bw.write(""+s.getGoBalance().getBalance()+"\n");
                bw.write(""+s.getSavBalance().getBalance()+"\n");
            }
            
            bw.close();
        }catch(IOException e){
            System.err.println("Error Found: "+e.getMessage());
        }
    }
    
    //Recreate Accounts if "existing_accounts.txt is not null
    public void recreateAccounts() throws FileNotFoundException
    {
        FileInputStream fIS = new FileInputStream("./File_IO/existing_accounts.txt");
        Scanner scan = new Scanner(fIS);
        
        if(scan.hasNext())
        {
            try{
                BufferedReader br = new BufferedReader(new FileReader("./File_IO/existing_accounts.txt"));
                
                String userName = "";
                String pin = "";
                String firstName = "";
                String lastName = "";
                double goBalance = 0;
                double savBalance = 0;

                while((userName = br.readLine()) != null)
                {
                    pin = br.readLine();
                    firstName = br.readLine();
                    lastName = br.readLine();
                    goBalance = Double.parseDouble(br.readLine());
                    savBalance = Double.parseDouble(br.readLine());
                    
                    createAccount(userName, pin, firstName, lastName);
                    this.getAccount(firstName, lastName).deposit("go", goBalance);
                    this.getAccount(firstName, lastName).deposit("savings", savBalance);
                }
                
                System.out.println("ACCOUNT(S) FROM PREVIOUS SESSIONS");
                System.out.println("HAS BEEN RECREATED..");
                
            }catch(IOException e)
            {
                System.err.println("Error Found: "+e.getMessage());
            }
        }
        else
        {
            System.out.println("THERE ARE NO ACCOUNTS FOUND!");
            System.out.println("NOTHING RECREATED...");
        }
    }
    
    //Wipes data in Admin & existing accounts txt files
    public void wipeAccounts()
    {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("./File_IO/admin_custList.txt"));
            bw.write("");
            bw = new BufferedWriter(new FileWriter("./File_IO/existing_accounts.txt"));
            bw.write("");
            
            bw.close();
            
            System.out.println("WIPING DATA FROM PREVIOUS SESSIONS...");
        }catch(IOException e)
        {
            System.err.println("Error Found: "+e.getMessage());
        }
    }

    /**
     * @return the accDetailMap
     */
    public HashMap<String, String> getAccDetailMap() {
        return accDetailMap;
    }

    /**
     * @return the currentAccount
     */
    public BankAccount getCurrentAccount() {
        return currentAccount;
    }

    /**
     * @param currentAccount the currentAccount to set
     */
    public void setCurrentAccount(BankAccount currentAccount) {
        this.currentAccount = currentAccount;
    }
}