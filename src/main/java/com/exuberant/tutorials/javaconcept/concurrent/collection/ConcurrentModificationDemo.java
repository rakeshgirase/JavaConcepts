package com.exuberant.tutorials.javaconcept.concurrent.collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ConcurrentModificationDemo {

    private static Logger logger = LoggerFactory.getLogger(ConcurrentModificationDemo.class);

    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");
        Iterator<String> it = myList.iterator();
        while (it.hasNext()) {
            String value = it.next();
            logger.info("List Value:" + value);
            /*if (value.equals("3"))
            myList.remove(value);*/
        }
        Map<String, String> myMap = new HashMap<>();
        myMap.put("1", "1");
        myMap.put("2", "2");
        myMap.put("3", "3");
        Iterator<String> it1 = myMap.keySet().iterator();
        while (it1.hasNext()) {
            String key = it1.next();
            logger.info("Map Value:" + myMap.get(key));
            if (key.equals("2")) {
                myMap.put("1", "4");
                //myMap.put("4", "4");
            }
        }
    }
}