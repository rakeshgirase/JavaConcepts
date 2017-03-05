package com.exuberant.tutorials.javaconcept.sort.collectionSort;

import java.util.*;


public class CollectionClass {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<Object, Object> h = new HashMap<Object, Object>();
        h.put(null, null);
        System.out.println("HashMap");
        hashMap();
        System.out.println("HashTable");
        hashTable();
        String test = new String("ABC");
        System.out.println(test.concat("def"));
        System.out.println(test);
        StringBuffer testBuffer = new StringBuffer("ABC");
        System.out.println(testBuffer.append("def"));
        System.out.println(testBuffer);
        StringBuffer str = new StringBuffer("Rakesh");
        System.out.println("String is " + str);
        modifyStringBuffer(str);
        System.out.println("Modified String is " + str);
    }

    public static void hashMap() {
        HashMap<Integer, Cricketer> hashMap = new HashMap<Integer, Cricketer>();
        Cricketer c1 = new Cricketer("Rakesh", 55, "India");
        Cricketer c2 = new Cricketer("G", 41, "SA");
        Cricketer c3 = new Cricketer("A", 65, "AUS");
        hashMap.put(c1.avg, c1);
        hashMap.put(c2.avg, c2);
        hashMap.put(c3.avg, c3);
        hashMap.put(null, null);
        Set<Integer> s = hashMap.keySet();
        Iterator<Integer> iter = s.iterator();
        while (iter.hasNext()) {
            System.err.println(iter.next());
        }
    }

    public static void hashTable() {
        Hashtable<Integer, Cricketer> hashTable = new Hashtable<Integer, Cricketer>();
        Cricketer c1 = new Cricketer("Rakesh", 55, "India");
        Cricketer c2 = new Cricketer("G", 41, "SA");
        Cricketer c3 = new Cricketer("A", 65, "AUS");
        hashTable.put(c1.avg, c1);
        hashTable.put(c2.avg, c2);
        hashTable.put(c3.avg, c3);
        //hashTable.put(5, null);
        Set<Integer> s = hashTable.keySet();
        Iterator<Integer> iter = s.iterator();
        while (iter.hasNext()) {
            System.err.println(hashTable.get(iter.next()));
        }
    }

    public static void treeMap() {
        TreeSet<Cricketer> tree = new TreeSet<Cricketer>();
        Cricketer c1 = new Cricketer("Rakesh", 55, "India");
        Cricketer c2 = new Cricketer("G", 41, "SA");
        Cricketer c3 = new Cricketer("A", 65, "AUS");
        tree.add(c1);
        tree.add(c2);
        tree.add(c3);
        Iterator<Cricketer> iter = tree.iterator();
        while (iter.hasNext()) {
            System.err.println(iter.next());
        }

    }

    public static void modifyString(String str) {
        System.err.println("String is " + str);
        str = "Modified";
    }

    public static void modifyStringBuffer(StringBuffer str) {
        System.err.println("StringBuffer is " + str);
        str = new StringBuffer("Modified");
    }

}
