package com.bankmanagementsystem;

import java.io.*;
import java.util.*;

class AccountFileHandler {

    static final String FILE_NAME = "accounts.txt";

    // Save account
    public static void saveAccount(BankAccount acc) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(acc.getAccountNumber() + "," +
                     acc.getCustomerName() + "," +
                     acc.getBalance() + "," +
                     acc.getClass().getSimpleName() + "\n");
        } catch (IOException e) {
            System.out.println("File Error");
        }
    }

    // Display all accounts
    public static void displayAccounts() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Stored Accounts ---");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("AccNo: " + data[0] +
                        " | Name: " + data[1] +
                        " | Balance: ₹" + data[2] +
                        " | Type: " + data[3]);
            }
        } catch (IOException e) {
            System.out.println("No records found");
        }
    }
}

