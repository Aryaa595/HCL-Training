package com.employeemanagementsystem;

import java.util.*;

public class EmployeeManagementApp {

    static Scanner sc = new Scanner(System.in);
    static List<Employee> employees;

    public static void main(String[] args) {

        if (!Login.authenticate()) {
            System.out.println("Invalid Login");
            return;
        }

        employees = EmployeeFileUtil.loadFromFile();
        int choice;

        do {
            System.out.println("\n--- EMPLOYEE MANAGEMENT MENU ---");
            System.out.println("1.Add Employee");
            System.out.println("2.Display All Employees");
            System.out.println("3.Search Employee by ID");
            System.out.println("4.Update Employee Salary");
            System.out.println("5.Delete Employee");
            System.out.println("6.Display Sorted Employees");
            System.out.println("7.Display Departments");
            System.out.println("8.Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> addEmployee();
                    case 2 -> displayEmployees();
                    case 3 -> searchEmployee();
                    case 4 -> updateSalary();
                    case 5 -> deleteEmployee();
                    case 6 -> sortEmployees();
                    case 7 -> displayDepartments();
                    case 8 -> {
                        System.out.println("Exiting...");
                        EmployeeFileUtil.saveToFile(employees);
                    }
                    default -> System.out.println("Invalid Choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 8);
    }

    // 1. Add Employee
    static void addEmployee() throws Exception {
        System.out.print("Employee ID: ");
        int id = sc.nextInt();

        for (Employee e : employees)
            if (e.getEmpId() == id)
                throw new Exception("Employee ID must be unique");

        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Department: ");
        String dept = sc.nextLine();
        if (dept.isEmpty())
            throw new Exception("Department cannot be empty");

        System.out.print("Salary: ");
        double sal = sc.nextDouble();
        if (sal <= 0)
            throw new Exception("Salary must be positive");

        employees.add(new Employee(id, name, dept, sal));
        EmployeeFileUtil.saveToFile(employees);
        System.out.println("Employee Added Successfully");
    }

    // 2. Display All Employees
    static void displayEmployees() {
        if (employees.isEmpty())
            System.out.println("No Employees Found");
        else
            employees.forEach(System.out::println);
    }

    // 3. Search Employee
    static void searchEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.getEmpId() == id) {
                System.out.println(e);
                return;
            }
        }
        System.out.println("Employee Not Found");
    }

    // 4. Update Salary
    static void updateSalary() throws Exception {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.getEmpId() == id) {
                System.out.print("New Salary: ");
                double sal = sc.nextDouble();
                if (sal <= 0)
                    throw new Exception("Salary must be positive");

                e.setSalary(sal);
                EmployeeFileUtil.saveToFile(employees);
                System.out.println("Salary Updated");
                return;
            }
        }
        System.out.println("Employee Not Found");
    }

    // 5. Delete Employee
    static void deleteEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        boolean removed = employees.removeIf(e -> e.getEmpId() == id);

        if (removed) {
            EmployeeFileUtil.saveToFile(employees);
            System.out.println("Employee Deleted");
        } else {
            System.out.println("Employee Not Found");
        }
    }

    // 6. Sorted Employees
    static void sortEmployees() {
        Collections.sort(employees);
        displayEmployees();
    }

    // 7. Display Departments
    static void displayDepartments() {
        Set<String> depts = new HashSet<>();
        for (Employee e : employees)
            depts.add(e.getDepartment());

        System.out.println("Departments: " + depts);
    }
}

