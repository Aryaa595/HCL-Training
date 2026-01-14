import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {

        // ===== Constructors =====
        HashMap<Integer, String> map1 = new HashMap<>();                // default
        HashMap<Integer, String> map2 = new HashMap<>(20);              // capacity
        HashMap<Integer, String> map3 = new HashMap<>(20, 0.75f);       // capacity + load

        map1.put(1, "A");
        map1.put(2, "B");

        HashMap<Integer, String> map4 = new HashMap<>(map1);            // collection

        // ===== Methods =====
        map1.put(3, "C");                    // 1 put
        map1.putIfAbsent(2, "BB");           // 2 putIfAbsent

        map1.putAll(map4);                   // 3 putAll

        System.out.println(map1.get(1));     // 4 get
        System.out.println(map1.getOrDefault(5, "NA")); //5 getOrDefault

        System.out.println(map1.containsKey(2));   //6 containsKey
        System.out.println(map1.containsValue("C"));//7 containsValue

        map1.remove(3);                      //8 remove(key)

        map1.replace(2, "Z");                //9 replace

        System.out.println(map1.size());     //10 size
        System.out.println(map1.isEmpty());  //11 isEmpty

        System.out.println(map1.keySet());   //12 keySet
        System.out.println(map1.values());   //13 values
        System.out.println(map1.entrySet()); //14 entrySet

        map1.clear();                        //15 clear
        System.out.println(map1);
    }
}
