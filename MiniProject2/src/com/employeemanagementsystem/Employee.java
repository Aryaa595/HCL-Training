package com.employeemanagementsystem;

import java.io.Serializable;

class Employee implements Serializable, Comparable<Employee> {

    private int empId;
    private String name;
    private String department;
    private double salary;

    public Employee(int empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee e) {
        return this.empId - e.empId;
    }

    @Override
    public String toString() {
        return empId + " | " + name + " | " + department + " | ₹" + salary;
    }
}

