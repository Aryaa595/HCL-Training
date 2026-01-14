import java.util.*;

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {

        // ===== Constructors =====
        ArrayList<String> list1 = new ArrayList<>();                 // default
        ArrayList<String> list2 = new ArrayList<>(10);               // with capacity

        list1.add("Apple");
        list1.add("Banana");

        ArrayList<String> list3 = new ArrayList<>(list1);            // collection constructor

        // ===== Methods =====
        list1.add("Mango");                         // 1 add
        list1.add(1, "Orange");                     // 2 add(index, element)

        list1.addAll(list3);                        // 3 addAll
        list1.addAll(1, list3);                     // 4 addAll(index, collection)

        System.out.println("List: " + list1);

        System.out.println("Get index 2: " + list1.get(2));        // 5 get

        list1.set(0, "Pineapple");                   // 6 set
        System.out.println("After set: " + list1);

        list1.remove(1);                             // 7 remove(index)
        list1.remove("Banana");                      // 8 remove(object)

        System.out.println("Contains Mango? " + list1.contains("Mango")); // 9 contains

        System.out.println("Index of Mango: " + list1.indexOf("Mango"));   //10 indexOf
        System.out.println("Last index: " + list1.lastIndexOf("Mango"));   //11 lastIndexOf

        System.out.println("Size: " + list1.size()); //12 size

        Object[] arr = list1.toArray();              //13 toArray
        System.out.println("Array length: " + arr.length);

        list1.trimToSize();                          //14 trimToSize

        list1.clear();                               //15 clear
        System.out.println("After clear: " + list1);
    }
}
