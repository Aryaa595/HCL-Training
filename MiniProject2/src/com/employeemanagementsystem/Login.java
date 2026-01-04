package com.employeemanagementsystem;

import java.util.Scanner;

class Login {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    public static boolean authenticate() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String u = sc.nextLine();

        System.out.print("Password: ");
        String p = sc.nextLine();

        return u.equals(USERNAME) && p.equals(PASSWORD);
    }
}

