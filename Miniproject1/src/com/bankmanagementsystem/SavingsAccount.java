package com.bankmanagementsystem;

class SavingsAccount extends BankAccount {

    public SavingsAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    // Method Overriding
    public void calculateInterest() {
        double interest = balance * 0.04;
        balance += interest;
        System.out.println("Savings Interest Added: ₹" + interest);
    }
}