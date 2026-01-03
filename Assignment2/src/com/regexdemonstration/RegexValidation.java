package com.regexdemonstration;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexValidation {

    static boolean validate(String input, String regex) {
        return Pattern.matches(regex, input);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1.Mobile 2.Email 3.Username 4.Password 5.Exit");
            choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Mobile Number: ");
                        String mobile = sc.nextLine();
                        if (validate(mobile, "^[6-9]\\d{9}$"))
                            System.out.println("Welcome!");
                        else
                            System.out.println("Invalid Mobile Number");
                        break;

                    case 2:
                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();
                        if (validate(email, "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
                            System.out.println("Welcome!");
                        else
                            System.out.println("Invalid Email");
                        break;

                    case 3:
                        System.out.print("Enter Username: ");
                        String user = sc.nextLine();
                        if (validate(user, "^[a-zA-Z0-9]{5,}$"))
                            System.out.println("Welcome!");
                        else
                            System.out.println("Invalid Username");
                        break;

                    case 4:
                        System.out.print("Enter Password: ");
                        String pass = sc.nextLine();
                        if (validate(pass, "^(?=.*[A-Z])(?=.*\\d).{6,}$"))
                            System.out.println("Welcome!");
                        else
                            System.out.println("Invalid Password");
                        break;

                    case 5:
                        System.out.println("Exit");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } while (choice != 5);
        sc.close();
    }
}
