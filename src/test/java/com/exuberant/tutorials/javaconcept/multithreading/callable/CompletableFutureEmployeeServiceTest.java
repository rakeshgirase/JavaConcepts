package com.exuberant.tutorials.javaconcept.multithreading.callable;

import com.exuberant.tutorials.javaconcept.customObjects.Employee;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureEmployeeServiceTest {

    private static Logger logger = LoggerFactory.getLogger(CompletableFutureEmployeeServiceTest.class);

    @Test
    public void call() throws ExecutionException, InterruptedException {
        CallableEmployeeService callableEmployeeService = new CallableEmployeeService();
        CompletableFuture<Employee> completableFuture = CompletableFuture.supplyAsync(callableEmployeeService::call);
        //Lazy
        CompletableFuture<Void> future = completableFuture
                .thenAccept(s -> System.out.println("Computation returned: " + s));
        future.get();
    }
}