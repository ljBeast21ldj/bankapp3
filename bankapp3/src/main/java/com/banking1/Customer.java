package com.banking1;

/*
Resource: "Java Bank App Full Twitch Stream", author: Intro to Computer Science,
published: 04/05/2015, url: https://www.youtube.com/watch?v=eR3sIf41xeI

Dr. Vinay Demos RevaturePro, Java Course, 04/12/2021 - 04/23/2021

*/

public class Customer {

    private final Account account;
    private final String ssn;
    private final String lastName;
    private final String firstName;


    Customer(String firstName, String lastName, String ssn, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.account = account;
    }

    @Override
    public String toString() {
        return "\nCustomer's Information\n" +
                "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "SSN: " + ssn +
                "account";
    }

    public String userInfo() {
        return "\nCustomer's Information\n" +
                "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "SSN: " + ssn +
                "Account: " + account.getAccountNumber();
    }

    Account getAccount() {
        return account;
    }
}
