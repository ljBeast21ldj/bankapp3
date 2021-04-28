package com.banking1;

/*
Resource: "Java Bank App Full Twitch Stream", author: Intro to Computer Science,
published: 04/05/2015, url: https://www.youtube.com/watch?v=eR3sIf41xeI

Dr. Vinay Demos RevaturePro, Java Course, 04/12/2021 - 04/23/2021

*/

public class Checking extends Account {
    private static String accountType = "Checking";

    Checking(double firstDeposit) {
        super();
        this.setBalance(firstDeposit);
        this.inspectInterest();
    }

    @Override
    public String toString() {
        return "Account type: " + accountType + " Account\n" +
                "Account Number: " + this.getAccountNumber() + "\n" +
                "Balance: " + this.getBalance() + "\n" +
                "Interest Rate: " + this.getInterest() + "%\n";
    }
}
