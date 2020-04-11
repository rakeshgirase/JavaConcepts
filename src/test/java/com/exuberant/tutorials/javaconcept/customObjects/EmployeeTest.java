package com.exuberant.tutorials.javaconcept.customObjects;

import org.junit.Test;

import java.util.*;

public class EmployeeTest {

    @Test
    public void testComparable() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, null, null));
        list.add(new Employee(5, null, null));
        list.add(new Employee(3, null, null));
        list.add(new Employee(8, null, null));
        System.err.println("Before: " + list);
        Collections.sort(list);
        System.err.println("After First: " + list);
        Comparator<? super Employee> myComparison = (e1, e2) -> (Integer.compare(e1.getEmpId(), e2.getEmpId()));
    }

    @Test
    public void testMap() {
        Map<Employee, String> map = new HashMap();
        for (Map.Entry<Employee, String> entry : map.entrySet()) {
            entry.getKey();
            entry.getValue();
        }

        for (Employee key : map.keySet()) {
            String value = map.get(key);
        }
    }

}