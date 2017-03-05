package com.exuberant.tutorials.javaconcept.concurrent.blockingQueue.priorityQ;

import com.exuberant.tutorials.javaconcept.customObjects.Employee;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTester {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Queue<Employee> pq = new PriorityQueue<Employee>(2, null);
        pq.add(new Employee(1, "Rakesh", "UNR"));
        pq.add(new Employee(2, "Mahesh", "MUM"));
        pq.offer(new Employee(3, "Rajesh", "KAN"));
        for (int i = 0; i < 10; i++) {
            System.out.println(pq.poll());
        }
    }

}
