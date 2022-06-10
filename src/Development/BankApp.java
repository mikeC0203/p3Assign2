/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Development;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author michaelcalbay
 */
public class BankApp {
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner scan = new Scanner(System.in);
        
        MCBank bank = new MCBank();
        
        bank.printLogo();
        bank.printPrompt();
        
        System.out.println("BEFORE STARTING");
        System.out.println("Do you want to recreate all accounts from the previous session? ");
        System.out.println("\nANY NUMBER - Recreate.");
        System.out.println("0 - Wipe Data.");
        
        int resetChoice = 0;
        
        while(!scan.hasNextInt())
        {
            if(scan.hasNext("x") || scan.hasNext("X"))
            {
                System.out.println("CLOSING...");
                System.exit(0);
            }
            else
            {
                System.out.println("Invalid Input! Try Again.");
                scan.next();
            }
        }
        
        resetChoice = scan.nextInt();
        
        if(resetChoice != 0)
        {
            bank.recreateAccounts();
        }
        else
        {
            bank.wipeAccounts();
        }
        
        int userChoice = 0;
        
        do
        {
            
            bank.showOptions();

            while(!scan.hasNextInt())
            {
                if(scan.hasNext("x") || scan.hasNext("X"))
                {
                    bank.saveAccounts();
                    bank.rawAccountDetails();
                    bank.printGoodBye();
                    System.exit(0);
                }
                else
                {
                    System.out.println("Invalid Input! Try Again.");
                    scan.next();
                }
            }
            
            userChoice = scan.nextInt();
            switch (userChoice) 
            {
                case 1:
                    {
                        scan.nextLine();
                        System.out.println("");
                        System.out.println("-LOGIN-\n");
                        
                        System.out.print("Username: ");
                        String userName = scan.nextLine();
                        System.out.print("Password: ");
                        String password = scan.nextLine();
                        
                        for(int i = 3;!(bank.loginCorrect(userName, password)) && i != 0; i--)
                        {
                            if(userName.equalsIgnoreCase("x"))
                            {
                                break;
                            }
                            
                            System.out.println("\nInvalid Username or Password!");
                            if(i != 1)
                            {
                                System.out.println("You have "+(i)+" attempts left!");
                            }
                            else
                            {
                                System.out.println("You have "+(i)+" attempt left!");
                            }
                            
                            System.out.println("Try again.");
                            System.out.println("OR");
                            System.out.println("Input (x) in USER & PASS to go back to the main menu.");
                            
                            System.out.print("Username: ");
                            userName = scan.next();
                            System.out.print("Password: ");
                            password = scan.next();
                            
                            scan.nextLine();
                        }

                        if(userName.equalsIgnoreCase("x"))
                        {
                            break;
                        }
                        else if(!bank.loginCorrect(userName, password))
                        {
                            System.out.println("Too many incorrect attempts!");
                            System.out.println("Taking you to the Main Menu.\n");
                            
                            break;
                        }
                        else
                        {   
                            BankAccount currentAcc = bank.login(userName, password);
                            
                            System.out.println("-=============-");
                            System.out.println("-= HOME PAGE =-");
                            System.out.println("-=============-\n");
                            System.out.println(currentAcc);
                            
                            int userActions = 0;
                            
                            do
                            {
                                currentAcc.custActions();
                                while(!scan.hasNextInt())
                                {
                                    if(scan.hasNext("x") || scan.hasNext("X"))
                                    {
                                        System.out.println("LOGGING OUT.");
                                        System.out.println("TAKING YOU TO HOME PAGE");
                                        System.out.println("\n");
                                        break;
                                    }
                                    else
                                    {
                                        System.out.println("Invalid Input! Try Again.");
                                        scan.next();
                                    }
                                }
                                
                                if(scan.hasNext("x") || scan.hasNext("X"))
                                {
                                    userActions = 6;
                                }
                                else
                                {
                                    userActions = scan.nextInt();
                                }

                                switch(userActions)
                                {
                                    case 1:
                                    {
                                        System.out.println("WITHDRAW");
                                        System.out.println("--------");
                                        System.out.print("Go or Savings?: ");
                                        String accType = scan.next();
                                        System.out.print("Amount: ");
                                        while(!scan.hasNextDouble())
                                        {
                                            System.out.println("Invalid Input! Try Again.");
                                            scan.next();
                                        }
                                        
                                        double amount = scan.nextDouble();
                                        
                                        currentAcc.withdraw(accType, amount);
                                        System.out.println("\n"+currentAcc);
                                        
                                        break;
                                    }   
                                    case 2:
                                    {
                                        System.out.println("DEPOSIT");
                                        System.out.println("-------");
                                        System.out.print("Go or Savings?: ");
                                        String accType = scan.next();
                                        System.out.print("Amount: ");

                                        while(!scan.hasNextDouble())
                                        {
                                            System.out.println("Invalid Input! Try Again.");
                                            scan.next();
                                        }
                                        double amount = scan.nextDouble();
                                        
                                        currentAcc.deposit(accType, amount);
                                        System.out.println("\n"+currentAcc);
                                        
                                        break;
                                    }
                                    case 3:
                                    {
                                        System.out.println("MOVE FUNDS");
                                        System.out.println("----------");
                                        System.out.print("From Go or Savings?: ");
                                        String fromAcc = scan.next();
                                        System.out.print("To Go or Savings?: ");
                                        String toAcc = scan.next();
                                        System.out.print("Amount: ");

                                        while(!scan.hasNextDouble())
                                        {
                                            System.out.println("Invalid Input! Try Again.");
                                            scan.next();
                                        }
                                        double amount = scan.nextDouble();
                                        
                                        currentAcc.moveFunds(fromAcc, toAcc, amount);
                                        System.out.println("\n"+currentAcc);
                                        
                                        break;
                                    }   
                                    case 4:
                                    {
                                        scan.nextLine();
                                        
                                        System.out.println("SEND PAYMENT");
                                        System.out.println("------------");
                                        System.out.println("Please Enter other party's Details: ");
                                        System.out.print("First Name: ");
                                        String toFirstName = scan.nextLine();
                                        System.out.print("Last Name: ");
                                        String toLastName = scan.nextLine();
                                        System.out.println("Advise which account You're sending from: ");
                                        System.out.print("Go or Savings?: ");
                                        String accType = scan.next();
                                        System.out.print("Amount: ");

                                        while(!scan.hasNextDouble())
                                        {
                                            System.out.println("Invalid Input! Try Again.");
                                            scan.next();
                                        }
                                        double amount = scan.nextDouble();
                                        
                                        if(bank.getAccount(toFirstName, toLastName) != null)
                                        {
                                            currentAcc.transfer(bank.getAccount(toFirstName, toLastName), accType, amount);
                                        }
                                        else
                                        {
                                            System.out.println("Bank Account Doesn't Exist!");
                                            System.out.println("Going back to Menu.");
                                        }
                                        System.out.println("\n"+currentAcc);
                                        break;
                                    }   
                                    case 5:
                                    {
                                        System.out.println(currentAcc);
                                        
                                        break;
                                    }
                                    default:
                                    {
                                        if(userActions == 6)
                                        {
                                            userActions = 'x';
                                        }
                                        else
                                        {
                                            System.out.println("Not an option.");
                                            System.out.println("Try Again.\n");
                                        }
                                        break;
                                    }
                                    
                                }
                                scan.nextLine();
                            }while(userActions != 'x');
                            
                        }   
                        break;
                    }
                case 2:
                    {
                        scan.nextLine();
                        System.out.println("");
                        System.out.println("-REGISTRATION-\n");
                        System.out.print("First Name: ");
                        String firstName = scan.nextLine();
                        System.out.print("Last Name: ");
                        String lastName = scan.nextLine();
                        System.out.print("Username: ");
                        String userName = scan.nextLine();
                        String password = "";
                        String passwordConfirm = "";
                        do
                        {
                            System.out.print("Password: ");
                            password = scan.next();
                            System.out.print("Confirm Password: ");
                            passwordConfirm = scan.next();
                            
                            if(!password.equals(passwordConfirm))
                            {
                                System.out.println("\nPassword did not match!");
                                System.out.println("\nEnter Again.");
                            }
                            
                        }while(!password.equals(passwordConfirm));
                        
                        
                        while(!bank.userNamesTaken(userName).contains(userName))
                        {
                            System.out.println("\nUsername Taken!");
                            System.out.println("Try Again.");
                            
                            System.out.print("Username: ");
                            userName = scan.next();
                            
                            if(userName.equalsIgnoreCase("x"))
                            {
                                break;
                            }
                        }
                        
                        if(userName.equalsIgnoreCase("x"))
                        {
                            break;
                        }
                        else
                        {
                            bank.createAccount(userName, password, firstName, lastName);
                            System.out.println("\nACCOUNT CREATED!\n");
                            break;
                        }
                    }
                    
                    
                default:
                    {
                        System.out.println("*===============*");
                        System.out.println("* Not an Option *");
                        System.out.println("*===============*");
                        System.out.println("*   TRY AGAIN   *");
                        System.out.println("*===============*\n");
                            
                        break;
                    }
            }
            
        }while(userChoice != 'x');
        bank.saveAccounts();
    } 
}