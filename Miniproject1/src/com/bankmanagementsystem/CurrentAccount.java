package com.bankmanagementsystem;

class CurrentAccount extends BankAccount {

    public CurrentAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    public void calculateInterest() {
        System.out.println("No interest for Current Account");
    }
}
