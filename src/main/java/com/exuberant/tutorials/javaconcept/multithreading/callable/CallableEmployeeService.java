package com.exuberant.tutorials.javaconcept.multithreading.callable;

import com.exuberant.tutorials.javaconcept.customObjects.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public class CallableEmployeeService implements Callable<Employee> {

    private static Logger logger = LoggerFactory.getLogger(CallableEmployeeService.class);

    @Override
    public Employee call() {
        logger.info("About to sleep for 5 seconds");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /* Uncomment following when you want to try callable throwing exception
        if (true)
            throw new RuntimeException("Something went wrong!");*/
        return new Employee(1, "Rakesh", "Mumbai");
    }
}
