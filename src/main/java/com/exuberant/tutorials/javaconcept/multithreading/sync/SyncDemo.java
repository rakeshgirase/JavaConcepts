package com.exuberant.tutorials.javaconcept.multithreading.sync;

public class SyncDemo {
    //Run this multiple times to fetch exact details
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.run();
    }
}
