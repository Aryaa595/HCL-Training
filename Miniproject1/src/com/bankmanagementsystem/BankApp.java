package com.bankmanagementsystem;

import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = null;   // Runtime Polymorphism

        while (true) {
            System.out.println("\n1.Create Account");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Balance Enquiry");
            System.out.println("5.Display Account");
            System.out.println("6.Display All Stored Accounts");
            System.out.println("7.Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Account Number: ");
                        int accNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Customer Name: ");
                        String name = sc.nextLine();

                        System.out.print("Initial Balance: ");
                        double bal = sc.nextDouble();

                        System.out.print("1.Savings  2.Current: ");
                        int type = sc.nextInt();

                        if (type == 1)
                            account = new SavingsAccount(accNo, name, bal);
                        else
                            account = new CurrentAccount(accNo, name, bal);

                        AccountFileHandler.saveAccount(account);
                        System.out.println("Account Created Successfully");
                        break;

                    case 2:
                        System.out.print("Amount to Deposit: ");
                        double dep = sc.nextDouble();
                        account.deposit(dep, "Deposit Successful");
                        break;

                    case 3:
                        System.out.print("Amount to Withdraw: ");
                        double wd = sc.nextDouble();
                        account.withdraw(wd);
                        System.out.println("Withdrawal Successful");
                        break;

                    case 4:
                        System.out.println("Balance: ₹" + account.getBalance());
                        break;

                    case 5:
                        account.displayAccount();
                        account.calculateInterest();
                        break;

                    case 6:
                        AccountFileHandler.displayAccounts();
                        break;

                    case 7:
                        System.out.println("Thank You!");
                        System.exit(0);
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

