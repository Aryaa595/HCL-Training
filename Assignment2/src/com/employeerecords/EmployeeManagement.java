package com.employeerecords;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EmployeeManagement implements EmployeeOperations {

    HashMap<Integer, Employee> hashMap = new HashMap<>();
    Hashtable<Integer, Employee> hashtable = new Hashtable<>();
    TreeMap<Integer, Employee> treeMap = new TreeMap<>();

    Scanner sc = new Scanner(System.in);

    // Add Employee
    public void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        Employee emp = new Employee(id, name);

        hashMap.put(id, emp);
        treeMap.put(id, emp);
        hashtable.put(id, emp); // Hashtable does NOT allow null

        System.out.println("Employee Added Successfully");
    }

    // Display Employees
    public void displayEmployees() {
        System.out.println("\n--- HashMap Records ---");
        for (Map.Entry<Integer, Employee> e : hashMap.entrySet())
            System.out.println(e.getValue());

        System.out.println("\n--- TreeMap Records ---");
        for (Map.Entry<Integer, Employee> e : treeMap.entrySet())
            System.out.println(e.getValue());

        System.out.println("\n--- Hashtable Records ---");
        for (Map.Entry<Integer, Employee> e : hashtable.entrySet())
            System.out.println(e.getValue());
    }

    // Search Employee
    public void searchEmployee(int id) {
        if (hashMap.containsKey(id))
            System.out.println("Employee Found: " + hashMap.get(id));
        else
            System.out.println("Employee Not Found");
    }

    // Remove Employee
    public void removeEmployee(int id) {
        hashMap.remove(id);
        treeMap.remove(id);
        hashtable.remove(id);
        System.out.println("Employee Removed");
    }

    // Demonstrate NULL behavior
    public void demonstrateNullSupport() {
        System.out.println("\n--- Null Support Demonstration ---");

        hashMap.put(null, new Employee(0, "NullKeyEmp"));
        hashMap.put(999, null);

        System.out.println("HashMap allows null key & value");

        try {
            hashtable.put(null, new Employee(1, "Test"));
        } catch (Exception e) {
            System.out.println("Hashtable does NOT allow null key/value");
        }

        // TreeMap does not allow null key
        try {
            treeMap.put(null, new Employee(2, "Test"));
        } catch (Exception e) {
            System.out.println("TreeMap does NOT allow null key");
        }
    }

    // MAIN
    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement();

        em.addEmployee();
        em.displayEmployees();

        System.out.print("\nEnter ID to Search: ");
        int sid = em.sc.nextInt();
        em.searchEmployee(sid);

        System.out.print("\nEnter ID to Remove: ");
        int rid = em.sc.nextInt();
        em.removeEmployee(rid);

        em.demonstrateNullSupport();
    }
}
