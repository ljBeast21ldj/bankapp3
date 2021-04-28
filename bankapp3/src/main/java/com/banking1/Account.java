package com.banking1;

/*
Resource: "Java Bank App Full Twitch Stream", author: Intro to Computer Science,
published: 04/05/2015, url: https://www.youtube.com/watch?v=eR3sIf41xeI

Dr. Vinay Demos RevaturePro, Java Course, 04/12/2021 - 04/23/2021

*/

public class Account {
    private double balance = 0;
    private double interest = 0.03;
    private int accountNumber;
    private static int totalAccounts = 1000000;

    // constructor
    Account() {
        accountNumber = totalAccounts++;
    }
    // getters and setters
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterest() {
        return interest * 100;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
    // no setter for account number to make it read only
    public int getAccountNumber() {
        return accountNumber;
    }

    public void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("Insufficient funds. Please enter a different amount.");
            return;
        }
        balance -= amount + 1;
        inspectInterest();
        System.out.println("Success! Your transaction of $" + amount + " dollars has been withdrawn and fee of $1");
        System.out.println("Current balance: " + balance);
        System.out.println("Thank you for visiting!");
    }

    public void deposit(double amount) {
        if(amount < 0) {
            System.out.println("Hold up! You cannot deposit negative funds! Please try again.");
            return;
        }
        inspectInterest();
        amount = amount + amount * interest;
        balance += amount;
        System.out.println("Success! Your transaction of $" + amount + " dollars has been deposited and interest of: "+interest);
        System.out.println("Current balance: " + balance);
        System.out.println("Thank you for visiting!");
    }

    public void inspectInterest() {
        if(balance > 10000) {
            interest = 0.03;
        } else {
            interest = 0.01;
        }
    }
}
