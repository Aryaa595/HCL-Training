package com.employeemanagementsystem;

import java.io.*;
import java.util.*;

class EmployeeFileUtil {

    static final String FILE_NAME = "employees.txt";

    public static void saveToFile(List<Employee> list) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(list);
        } catch (Exception e) {
            System.out.println("File Save Error");
        }
    }

    public static List<Employee> loadFromFile() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Employee>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}

