package com.banking1;
/*
Resource: "Java Bank App Full Twitch Stream", author: Intro to Computer Science,
published: 04/05/2015, url: https://www.youtube.com/watch?v=eR3sIf41xeI

Dr. Vinay Demos RevaturePro, Java Course, 04/12/2021 - 04/23/2021

*/

import java.util.ArrayList;

public class Bank {
    ArrayList<Customer> customers = new ArrayList<Customer>();
    // if you want to print out the ArrayList Arrays.toString(list.toArray())
    // or use the ArrayList.get()
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    Customer getCustomer(int account) {
        return customers.get(account);
    }

    ArrayList<Customer> getCustomers() {
        return customers;
    }
}
