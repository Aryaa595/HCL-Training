import java.util.*;

public class HashtableDemo {
    public static void main(String[] args) {

        // ===== Constructors =====
        Hashtable<Integer, String> ht1 = new Hashtable<>();             // default
        Hashtable<Integer, String> ht2 = new Hashtable<>(20);           // capacity
        Hashtable<Integer, String> ht3 = new Hashtable<>(20, 0.75f);    // capacity + load

        ht1.put(1, "One");
        ht1.put(2, "Two");

        Hashtable<Integer, String> ht4 = new Hashtable<>(ht1);          // collection

        // ===== Methods =====
        ht1.put(3, "Three");                //1 put
        ht1.putIfAbsent(4, "Four");         //2 putIfAbsent

        ht1.get(1);                         //3 get

        ht1.remove(2);                      //4 remove

        ht1.replace(1, "ONE");              //5 replace

        System.out.println(ht1.containsKey(3));    //6 containsKey
        System.out.println(ht1.containsValue("ONE")); //7 containsValue

        System.out.println(ht1.size());     //8 size
        System.out.println(ht1.isEmpty());  //9 isEmpty

        System.out.println(ht1.keySet());   //10 keySet
        System.out.println(ht1.values());   //11 values
        System.out.println(ht1.entrySet()); //12 entrySet

        ht1.clone();                        //13 clone

        ht1.clear();                        //14 clear

        System.out.println(ht1.equals(ht4)); //15 equals
    }
}
