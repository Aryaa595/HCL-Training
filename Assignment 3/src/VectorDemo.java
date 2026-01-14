import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {

        // ===== Constructors =====
        Vector<Integer> v1 = new Vector<>();                 // default
        Vector<Integer> v2 = new Vector<>(5);                // capacity
        Vector<Integer> v3 = new Vector<>(5, 3);             // capacity + increment

        v1.add(10);
        v1.add(20);

        Vector<Integer> v4 = new Vector<>(v1);               // collection

        // ===== Methods =====
        v1.add(30);                       // 1 add
        v1.addElement(40);                // 2 addElement

        v1.insertElementAt(15, 1);        // 3 insertElementAt
        System.out.println(v1);

        System.out.println(v1.firstElement()); // 4 firstElement
        System.out.println(v1.lastElement());  // 5 lastElement

        System.out.println(v1.get(2));         // 6 get

        v1.set(2, 25);                         // 7 set

        v1.remove(1);                          // 8 remove(index)
        v1.removeElement(40);                  // 9 removeElement

        System.out.println(v1.contains(25));   //10 contains
        System.out.println(v1.indexOf(25));    //11 indexOf

        System.out.println(v1.size());         //12 size
        System.out.println(v1.capacity());     //13 capacity

        v1.trimToSize();                       //14 trimToSize

        v1.clear();                            //15 clear
        System.out.println(v1);
    }
}
