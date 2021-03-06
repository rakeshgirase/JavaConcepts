package com.exuberant.tutorials.javaconcept.fundamentals;

import com.exuberant.tutorials.javaconcept.customObjects.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class CloneDemo {

    private static Logger logger = LoggerFactory.getLogger(CloneDemo.class);

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(baos);
        Employee emp = new Employee(1, "Rakesh", "Mumbai");
        os.writeObject(emp);
        emp.setAddress("Thane");
        ByteArrayInputStream bain = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bain);
        Employee emp2 = null;
        try {
            emp2 = (Employee) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        logger.info(emp.toString());
        logger.info(emp2.toString());
    }
}
