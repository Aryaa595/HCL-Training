import java.util.Scanner;

// Custom Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Bank Account Class
class BankAccount {

    private String accountHolder;
    private int accountNumber;
    private double balance;

    // Constructor
    BankAccount(String name, int accNo, double initialBalance) {
        accountHolder = name;
        accountNumber = accNo;
        balance = initialBalance;
    }

    // Deposit Method
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        System.out.println("Amount deposited successfully");
    }

    // Withdraw Method
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
        System.out.println("Amount withdrawn successfully");
    }

    // Balance Enquiry
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Display Account Details
    public void displayDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

// Main Class
public class BankManagement {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("---- Create Bank Account ----");
        System.out.print("Enter Account Holder Name: ");
        String name = input.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = input.nextInt();

        System.out.print("Enter Initial Balance: ");
        double balance = input.nextDouble();

        BankAccount account = new BankAccount(name, accNo, balance);

        int choice;

        do {
            System.out.println("\n---- BANK MENU ----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = input.nextDouble();
                        account.deposit(depositAmount);
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = input.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;

                    case 3:
                        account.checkBalance();
                        break;

                    case 4:
                        account.displayDetails();
                        break;

                    case 5:
                        System.out.println("Thank you for using Bank Management System");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);

        input.close();
    }
}
