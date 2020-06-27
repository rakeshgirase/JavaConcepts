package com.exuberant.tutorials.javaconcept.multithreading.callable;

import com.exuberant.tutorials.javaconcept.customObjects.Employee;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableEmployeeServiceTest {

    private static Logger logger = LoggerFactory.getLogger(CallableEmployeeServiceTest.class);

    @Test
    public void call() {
        CallableEmployeeService callableEmployeeService = new CallableEmployeeService();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Future<Employee> future = pool.submit(callableEmployeeService);
        try {
            Employee emp = future.get();//get will throw exception if exception occurs in executorService
            System.err.println("Got Employee: " + emp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}