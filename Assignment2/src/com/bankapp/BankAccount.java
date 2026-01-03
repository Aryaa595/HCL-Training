package com.bankapp;

class BankAccount implements BankingOperations, CustomerOperations {

    private int accountNumber;
    private String customerName;
    private double balance;

    public BankAccount(int accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid deposit amount");
        balance += amount;
        System.out.println("Amount Deposited Successfully");
    }

    public void withdraw(double amount) {
        if (amount > balance)
            throw new ArithmeticException("Insufficient Balance");
        balance -= amount;
        System.out.println("Withdrawal Successful");
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void displayCustomerDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Customer Name: " + customerName);
    }
}
