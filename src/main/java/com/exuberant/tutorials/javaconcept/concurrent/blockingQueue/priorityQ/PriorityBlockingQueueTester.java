package com.exuberant.tutorials.javaconcept.concurrent.blockingQueue.priorityQ;

import com.exuberant.tutorials.javaconcept.customObjects.Employee;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;


public class PriorityBlockingQueueTester {
    public static void main(String[] args) {
        BlockingQueue<Employee> pq = new PriorityBlockingQueue<Employee>();
        pq.add(new Employee(1, "Rakesh", "UNR"));
        pq.add(new Employee(2, "Mahesh", "MUM"));
        pq.add(new Employee(3, "Rajesh", "KAN"));

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(pq.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
