package com.exuberant.tutorials.javaconcept.multithreading.object.locks;

public class LockDemo {

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.main();
    }
}