package com.banking1;

import java.util.ArrayList;
import java.util.Scanner;

/*
Resources:
"Java Bank App Full Twitch Stream", author: Intro to Computer Science,
published: 04/05/2015, url: https://www.youtube.com/watch?v=eR3sIf41xeI

"Java for students", Practice. Menu-Driven "bank account" application,
found: 04/25/2021, url: www.javaforstudents.co.uk/Practice/Bank_account

"#Java OOP Simple #Bank #Account Application
#Inheritance and Is a #Relationship, author: CodingHelpLine,
published on Oct 6, 2020, on Youtube, url: https://www.youtube.com/watch?v=-HZSyjuuOsc

Dr. Vinay Demos RevaturePro, Java Course, 04/12/2021 - 04/23/2021

*/


public class Menu {
    // creating instance variables
    // scanner class takes in the customers input
    Scanner userKeyboard = new Scanner(System.in);
    /* Bank class will have the list of customers
       make use of the object in Menu class to keep track of them
       this will make it easier to edit while creating GUI */
    Bank bank = new Bank();
    boolean exit = false;

    // outlining the methods

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.startMenu();
    }
    private void printMenu() {
        System.out.println("Please choose between options: ");
        System.out.println("1) Create a new Account");
        System.out.println("2) Make a Deposit");
        System.out.println("3) Make a Withdrawal");
        System.out.println("4) See account balance");
        System.out.println("0 Exit");

    }

    private void printIntro() {
        System.out.println("+--------------------------------+");
        System.out.println("|       Welcome to Larry's       |");
        System.out.println("|            Bank App            |");
        System.out.println("+--------------------------------+");
    }

    public void startMenu() {
        printIntro();
        while (!exit) {
            printMenu();
            int options = getOption();
            executeOption(options);
        }
    }

    private void executeOption(int options) {
        switch (options) {
            case 0:
                System.out.println("Thank you for Visiting my Application!");
                System.exit(0);
                break;
            case 1:
                // create account
                createAccount();
                break;
            case 2:
                // make deposit

                break;
            case 3:
                // make a withdrawal
                break;
            case 4:
                // check account balance
                break;
            default:
                System.out.println("Unknown Error has Occurred.");
        }
    }

    private void createAccount() {
        String firstName, lastName, ssn, accountType = "";
        double firstDeposit = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Please enter the account type either checking or savings: ");
            accountType = userKeyboard.nextLine();
            if (accountType.equalsIgnoreCase("checking") || accountType.equalsIgnoreCase("savings")) {
                isValid = true;
            } else {
                System.out.println("Invalid account type selected. Please enter checking or savings: ");
            }
        }
        System.out.println("Please enter your first name: ");
        firstName = userKeyboard.nextLine();
        System.out.println("Please enter your last name: ");
        lastName = userKeyboard.nextLine();
        System.out.println("Please enter your social security number: ");
        ssn = userKeyboard.nextLine();
        isValid = false;
        while (!isValid) {
            System.out.println("Please enter an initial deposit: ");
            try {
                firstDeposit = Double.parseDouble(userKeyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Deposit must be a number. Please try again.");
            }
            if (accountType.equalsIgnoreCase("checking")) {
                if (firstDeposit < 100) {
                    System.out.println("Checking account requires a minimum deposit of $100 to open.");
                } else {
                    isValid = true;
                }
            } else if (accountType.equalsIgnoreCase("savings")) {
                if(firstDeposit < 50) {
                    System.out.println("Savings account requires a minimum deposit of $50 to open.");
                } else {
                    isValid = true;
                }
            }
        }
        // Here we can create an account for user
        Account account;
        if(accountType.equalsIgnoreCase("checking")) {
            account = new Checking(firstDeposit);
        } else {
            account = new Savings(firstDeposit);
        }
        Customer customer = new Customer(firstName, lastName, ssn, account);
        bank.addCustomer(customer);
    }

    private void depositCash() {
        int account = selectAccount();
        if (account >= 0) {
            System.out.println("How much would you like to deposit today?: ");
            double amount = 0;
            // placing try catch statement just in case a user doesn't place numbers in input
            try {
                amount = Double.parseDouble(userKeyboard.nextLine());
            } catch (NumberFormatException e) {
                amount = 0;
            }
            // goes to the bank object, gets customer's account type and deposits the amount to that account
            // based on the user's input typed
            bank.getCustomer(account).getAccount().deposit(amount);
        }
    }

    private void withdrawFunds() {

    }

    private void listBalances() {

    }
    // method to return the accounts selected
    private int selectAccount() {
        ArrayList<Customer> customers = bank.getCustomers();
        if(customers.size() <= 0) {
            System.out.println("No customers are found at your location.");
        }
        System.out.println("Select an account:");
        for(int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ") " + customers.get(i).userInfo());
        }
        int account = 0;
        System.out.println("Confirm your selection:");
        // if anything other than a number is typed set account to -1
        try {
            account = Integer.parseInt(userKeyboard.nextLine()) - 1;
        } catch (NumberFormatException e) {
            account = -1;
        }
        return account;
    }


    private int getOption() {
        int option = -1;
       do {
           System.out.println("Please enter your selection: ");
           // make sure customer's choice is in range of menu's options
           try {
               option = Integer.parseInt(userKeyboard.nextLine());
           } catch(NumberFormatException e) {
               System.out.println("Invalid choice. Please enter only numbers for selection.");
           }
           // if not send error message asking customer to try again
           if(option < 0 || option > 4) {
               System.out.println("Choice is outside of range. Please select again.");
           }

       } while (option < 0 || option > 4);
       return option;
    }
}
