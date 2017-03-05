package com.exuberant.tutorials.javaconcept.reflections;

import com.exuberant.tutorials.javaconcept.customObjects.Employee;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        /*createObjects();
		setPrivateFields();
		invokeMethods();*/
        Class clazz = Class.forName("com.exuberant.tutorials.javaconcept.customObjects.Employee");
        System.out.println(clazz);
        Employee emp = new Employee(1, "Rakesh", "Mumbai");
        Method method = clazz.getMethod("getName");
        System.out.println(method.invoke(emp));
    }

    private static void invokeMethods() throws Exception {
        Class<Emp> e = Emp.class;
        Emp emp = e.getConstructor(String.class).newInstance("Methods");
        Method m = e.getMethod("printPublic", String.class);
        m.invoke(emp, "Args");
    }

    private static void setPrivateFields() throws Exception {
        Class<Emp> e = Emp.class;
        Emp emp = new Emp();
        Field f = e.getDeclaredField("name");
        //Field f = e.getField("name");
        f.setAccessible(true);
        f.set(emp, "Dynamic");
        System.out.println(emp);
    }

    private static void createObjects() throws Exception {
        Class<Emp> e = Emp.class;
        Emp emp = e.newInstance();
        System.out.println(emp);
        emp = e.getConstructor(String.class).newInstance("Rakesh");
    }
}

class Emp {
    private String name;

    public Emp(String name) {
        this.name = name;
    }

    public Emp() {
    }

    @Override
    public String toString() {
        return name;
    }

    public void printPublic(String test) {
        System.out.println("Public: My Name is " + name);
        System.out.println("Arguments " + test);
    }
}