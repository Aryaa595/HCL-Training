package com.universitymanagement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;
import java.util.regex.Pattern;

public class University implements UniversityOperations {

    List<Student> studentList = new ArrayList<>();
    Vector<Student> studentVector = new Vector<>();
    Stack<Student> studentStack = new Stack<>();

    Map<Integer, Student> studentMap = new HashMap<>();
    Set<String> courseSet = new HashSet<>();

    Scanner sc = new Scanner(System.in);

    // Add Student
    public void addStudent() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (studentMap.containsKey(id))
                throw new Exception("Duplicate Student ID");

            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            if (!Pattern.matches("^[A-Za-z ]+$", name))
                throw new Exception("Invalid Name");

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            Student s = new Student(id, name, course, marks);

            studentList.add(s);
            studentVector.add(s);
            studentStack.push(s);
            studentMap.put(id, s);
            courseSet.add(course);

            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Display Students
    public void displayStudents() {
        System.out.println("\nID | Name | Course | Marks");
        for (Student s : studentList)
            System.out.println(s);
    }

    // Search Student
    public void searchStudent(int id) {
        if (studentMap.containsKey(id))
            System.out.println("Found: " + studentMap.get(id));
        else
            System.out.println("Student Not Found");
    }

    // Remove Student
    public void removeStudent(int id) {
        Student s = studentMap.remove(id);
        if (s != null) {
            studentList.remove(s);
            studentVector.remove(s);
            studentStack.remove(s);
            System.out.println("Student Removed");
        } else {
            System.out.println("Student Not Found");
        }
    }

    // Sort by Marks
    public void sortByMarks() {
        studentList.sort(Comparator.comparingInt(st -> st.marks));
        System.out.println("\nStudents Sorted By Marks:");
        displayStudents();
    }

    // Convert HashMap to TreeMap & Display
    public void convertToTreeMap() {
        TreeMap<Integer, Student> treeMap = new TreeMap<>(studentMap);
        System.out.println("\nTreeMap Data:");
        for (Student s : treeMap.values())
            System.out.println(s);
    }

    // Count Students Course-wise
    public void countCourseWise() {
        Map<String, Integer> countMap = new HashMap<>();

        for (Student s : studentList)
            countMap.put(s.course, countMap.getOrDefault(s.course, 0) + 1);

        System.out.println("\nCourse-wise Student Count:");
        System.out.println(countMap);
    }

    // Display Unique Courses
    public void displayCourses() {
        System.out.println("\nUnique Courses:");
        System.out.println(courseSet);
    }

    // MAIN
    public static void main(String[] args) {
        University um = new University();

        um.addStudent();
        um.addStudent();

        um.displayStudents();
        um.sortByMarks();
        um.convertToTreeMap();

        System.out.print("\nEnter ID to Search: ");
        int sid = um.sc.nextInt();
        um.searchStudent(sid);

        System.out.print("\nEnter ID to Remove: ");
        int rid = um.sc.nextInt();
        um.removeStudent(rid);

        um.countCourseWise();
        um.displayCourses();
    }
}