package com.bankapp;

import java.util.Scanner;

public class UseBankApp {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount acc = new BankAccount(accNo, name, balance);

        try {
            acc.deposit(2000);
            acc.withdraw(1000);
            acc.checkBalance();
            acc.displayCustomerDetails();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
