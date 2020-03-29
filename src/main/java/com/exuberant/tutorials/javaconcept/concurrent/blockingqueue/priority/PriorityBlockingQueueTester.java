package com.exuberant.tutorials.javaconcept.concurrent.blockingqueue.priority;

import com.exuberant.tutorials.javaconcept.customObjects.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;


public class PriorityBlockingQueueTester {

    private static Logger logger = LoggerFactory.getLogger(PriorityBlockingQueueTester.class);

    public static void main(String[] args) {
        BlockingQueue<Employee> pq = new PriorityBlockingQueue<>();
        pq.add(new Employee(1, "Rakesh", "UNR"));
        pq.add(new Employee(2, "Mahesh", "MUM"));
        pq.add(new Employee(3, "Rajesh", "KAN"));

        for (int i = 0; i < 10; i++) {
            try {
                logger.info(String.valueOf(pq.take()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
