package com.exuberant.tutorials.javaconcept.sort.collectionsort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class CollectionClass {

    private static Logger logger = LoggerFactory.getLogger(CollectionClass.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<Object, Object> h = new HashMap<>();
        h.put(null, null);
        logger.info("HashMap");
        hashMap();
        logger.info("HashTable");
        hashTable();
        String test = new String("ABC");
        logger.info(test.concat("def"));
        logger.info(test);
        StringBuffer testBuffer = new StringBuffer("ABC");
        logger.info(String.valueOf(testBuffer.append("def")));
        logger.info(String.valueOf(testBuffer));
        StringBuffer str = new StringBuffer("Rakesh");
        logger.info("String is " + str);
        modifyStringBuffer(str);
        logger.info("Modified String is " + str);
    }

    public static void hashMap() {
        Map<Integer, Cricketer> hashMap = new HashMap<>();
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
            logger.info(String.valueOf(iter.next()));
        }
    }

    public static void hashTable() {
        Map<Integer, Cricketer> hashTable = new Hashtable<>();
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
            logger.info(String.valueOf(hashTable.get(iter.next())));
        }
    }

    public static void treeMap() {
        TreeSet<Cricketer> tree = new TreeSet<>();
        Cricketer c1 = new Cricketer("Rakesh", 55, "India");
        Cricketer c2 = new Cricketer("G", 41, "SA");
        Cricketer c3 = new Cricketer("A", 65, "AUS");
        tree.add(c1);
        tree.add(c2);
        tree.add(c3);
        Iterator<Cricketer> iter = tree.iterator();
        while (iter.hasNext()) {
            logger.info(String.valueOf(iter.next()));
        }

    }

    public static void modifyString(String str) {
        logger.info("String is " + str);
        str = "Modified";
    }

    public static void modifyStringBuffer(StringBuffer str) {
        logger.info("StringBuffer is " + str);
        str = new StringBuffer("Modified");
    }

}
