import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {

        // ===== Constructors =====
        TreeMap<Integer, String> tm1 = new TreeMap<>();              // default

        tm1.put(3, "C");
        tm1.put(1, "A");

        TreeMap<Integer, String> tm2 = new TreeMap<>(tm1);          // map

        TreeMap<Integer, String> tm3 = new TreeMap<>(Comparator.reverseOrder()); // comparator

        tm3.putAll(tm1);

        // ===== Methods =====
        tm1.put(2, "B");                    //1 put

        System.out.println(tm1.get(1));     //2 get

        System.out.println(tm1.firstKey()); //3 firstKey
        System.out.println(tm1.lastKey());  //4 lastKey

        System.out.println(tm1.ceilingKey(2)); //5 ceilingKey
        System.out.println(tm1.floorKey(2));   //6 floorKey

        System.out.println(tm1.higherKey(2));  //7 higherKey
        System.out.println(tm1.lowerKey(2));   //8 lowerKey

        System.out.println(tm1.headMap(3));    //9 headMap
        System.out.println(tm1.tailMap(2));    //10 tailMap

        System.out.println(tm1.subMap(1, 3));  //11 subMap

        tm1.remove(2);                          //12 remove

        System.out.println(tm1.keySet());       //13 keySet
        System.out.println(tm1.values());       //14 values

        tm1.clear();                            //15 clear
        System.out.println(tm1);
    }
}

