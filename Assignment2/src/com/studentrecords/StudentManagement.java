package com.studentrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentManagement implements StudentOperations {

    List<Student> students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter Roll: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        if (!Pattern.matches("^[A-Za-z ]+$", name))
            throw new IllegalArgumentException("Invalid Name");

        students.add(new Student(roll, name));
        System.out.println("Student Added");
    }

    public void displayStudents() {
        for (Student s : students)
            System.out.println(s.roll + " " + s.name);
    }

    public void searchStudent(int roll) {
        for (Student s : students)
            if (s.roll == roll)
                System.out.println("Found: " + s.name);
    }

    public void removeStudent(int roll) {
        students.removeIf(s -> s.roll == roll);
        System.out.println("Student Removed");
    }

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        sm.addStudent();
        sm.displayStudents();
    }
}
