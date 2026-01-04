package com.bankmanagementsystem;

import java.io.Serializable;

abstract class BankAccount implements Serializable {

    private int accountNumber;
    private String customerName;
    protected double balance;

    public BankAccount(int accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    // Encapsulation
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }

    // Method Overloading
    public void deposit(double amount) {
        balance += amount;
    }

    public void deposit(double amount, String msg) {
        balance += amount;
        System.out.println(msg);
    }

    public void withdraw(double amount) throws Exception {
        if (amount > balance)
            throw new Exception("Insufficient Balance");
        balance -= amount;
    }

    public void displayAccount() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Name      : " + customerName);
        System.out.println("Balance   : ₹" + balance);
    }

    // Abstract Method
    abstract void calculateInterest();
}
