package com.exuberant.tutorials.javaconcept.reflections;

import com.exuberant.tutorials.javaconcept.customObjects.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {

    private static Logger logger = LoggerFactory.getLogger(ReflectionDemo.class);

    public static void main(String[] args) throws Exception {
        /*createObjects();
		setPrivateFields();
		invokeMethods();*/
        Class clazz = Class.forName("com.exuberant.tutorials.javaconcept.customObjects.Employee");
        logger.info(String.valueOf(clazz));
        Employee emp = new Employee(1, "Rakesh", "Mumbai");
        Method method = clazz.getMethod("getName");
        logger.info(String.valueOf(method.invoke(emp)));
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
        logger.info(String.valueOf(emp));
    }

    private static void createObjects() throws Exception {
        Class<Emp> e = Emp.class;
        Emp emp = e.newInstance();
        logger.info(String.valueOf(emp));
        emp = e.getConstructor(String.class).newInstance("Rakesh");
    }
}

class Emp {

    private static Logger logger = LoggerFactory.getLogger(Emp.class);

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
        logger.info("Public: My Name is " + name);
        logger.info("Arguments " + test);
    }
}