package com.exuberant.tutorials.javaconcept.concurrent.blockingqueue.priority;

import com.exuberant.tutorials.javaconcept.customObjects.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTester {

    private static Logger logger = LoggerFactory.getLogger(PriorityQueueTester.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        Queue<Employee> pq = new PriorityQueue<>(2, null);
        pq.add(new Employee(1, "Rakesh", "UNR"));
        pq.add(new Employee(2, "Mahesh", "MUM"));
        pq.offer(new Employee(3, "Rajesh", "KAN"));
        for (int i = 0; i < 10; i++) {
            logger.info(String.valueOf(pq.poll()));
        }
    }

}
